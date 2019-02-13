package ru.job4j.chess.firuges.white;

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
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
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
        Cell[] result;
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
        return new BishopWhite(dest);
    }
}
