package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
        boolean rst;
        Cell[] steps;
        int index = this.findBy(source);
        try {
            steps = figures[findBy(source)].way(source, dest);
        } catch (ImpossibleMoveException | ArrayIndexOutOfBoundsException e) {
            return false;
        }

        if (this.findBy(source) == -1 || !allow(steps, source, dest)) {
            rst = false;
        } else {
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
        }

        return rst;
    }

    public boolean allow(Cell[] steps, Cell source, Cell dest) {
        boolean result = false;
        boolean hasFigure = false;
        boolean isKnight = false;
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                hasFigure = true;
            }
        }
        for (Figure figure : figures) {
            if ((figure.position().equals(source) && figure.getClass().getSimpleName().equals("KnightBlack") && this.findBy(dest) == -1)
                    || figure.position().equals(source) && figure.getClass().getSimpleName().equals("KnightWhite") && this.findBy(dest) == -1) {
                isKnight = true;
            }
        }
        if (!hasFigure || isKnight) {
            result = true;
        }
        return result;
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
