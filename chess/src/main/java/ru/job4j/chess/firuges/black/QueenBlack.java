package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;


/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    /**
     *
     * @return position of current figure
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Finding the way of this move and check the right of this way
     * @param source start position of figure
     * @param dest - finish position
     * @return - array of steps on the board
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] result = null;
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        if (abs(deltaX) == abs(deltaY)) {
            result = new Cell[abs(deltaX)];
            int index = 0;
            if (deltaX < 0 && deltaY < 0) {
                for (int i = 1; i <= abs(deltaX); i++) {
                    result[index++] = Cell.getCell(source.x + i, source.y + i);
                }
            } else if (deltaX > 0 && deltaY < 0) {
                for (int i = 1; i <= abs(deltaX); i++) {
                    result[index++] = Cell.getCell(source.x - i, source.y + i);
                }
            } else if (deltaX > 0 && deltaY > 0) {
                for (int i = 1; i <= abs(deltaX); i++) {
                    result[index++] = Cell.getCell(source.x - i, source.y - i);
                }
            } else if (deltaX < 0 && deltaY > 0) {
                for (int i = 1; i <= abs(deltaX); i++) {
                    result[index++] = Cell.getCell(source.x + i, source.y - i);
                }
            }
        } else if(source.x == dest.x || source.y == dest.y) {
            if (source.x == dest.x && dest.y > source.y) {
                result = new Cell[dest.y - source.y];
                int a = 0;
                for (int i = source.y + 1; i < dest.y + 1; i++) {
                    result[a++] = Cell.getCell(source.x, i);
                }
            } else if (source.x == dest.x && dest.y < source.y) {
                result = new Cell[source.y - dest.y];
                int a = 0;
                for (int i = source.y - 1; i > dest.y - 1; i--) {
                    result[a++] = Cell.getCell(source.x, i);
                }
            } else if (source.y == dest.y && dest.x > source.x) {
                result = new Cell[dest.x - source.x];
                int a = 0;
                for (int i = source.x + 1; i < dest.x + 1; i++) {
                    result[a++] = Cell.getCell(i, source.y);
                }
            } else if (source.y == dest.y && dest.x < source.x) {
                result = new Cell[source.x - dest.x];
                int a = 0;
                for (int i = source.x - 1; i > dest.x - 1; i--) {
                    result[a++] = Cell.getCell(i, source.y);
                }
            }
        } else throw new ImpossibleMoveException();

        return result;
    }

    /**
     * re-creating a new figure on the destination cell
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
