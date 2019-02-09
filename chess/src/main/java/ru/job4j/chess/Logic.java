package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 *
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            System.out.print("Steps: ");
            for (Cell cell : steps) {
                System.out.print(cell);
            }
            System.out.println();
            for (Figure figure : figures) {
                if (figure.position().equals(source)) {
                    System.out.println(figure.getClass().getSimpleName());
                }
            }

            if (steps.length > 0 && steps[steps.length - 1].equals(dest) && allowedMove(steps, source, dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
            System.out.println(new StringBuilder().append(rst).append(System.lineSeparator()));
        }
        System.out.println("Index is " + index);
        return rst;
    }

    public boolean isKnight(Cell position, Cell dest) {
        boolean result = false;
        for (Figure figure : figures) {
            if ((figure.position().equals(position) && figure.getClass().getSimpleName().equals("KnightBlack") && this.findBy(dest) == -1)
            || figure.position().equals(position) && figure.getClass().getSimpleName().equals("KnightWhite") && this.findBy(dest) == -1) {
                result = true;
            }
        }
        return result;
    }

    public boolean allowedMove(Cell[] steps, Cell source, Cell dest) {
        boolean allow = false;
        boolean hasFigures = false;
        for (Figure figure : figures) {
            for (Cell step : steps) {
                if (step.equals(figure.position())) {
                    hasFigures = true;
                }
            }
        }
        if (!hasFigures || isKnight(source, dest)){
            allow = true;
        }
        System.out.println("HasFigures = " + hasFigures);
        System.out.println("Allow is = " + allow);
        return allow;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
