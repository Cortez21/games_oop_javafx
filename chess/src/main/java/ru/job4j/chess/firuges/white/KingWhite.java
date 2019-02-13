package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite implements Figure {
    private final Cell position;

    public KingWhite(final Cell position) {
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
        Cell[] result = new Cell[1];
        if (dest.equals(Cell.getCell(source.x + 1, source.y))
                || dest.equals(Cell.getCell(source.x, source.y + 1))
                || dest.equals(Cell.getCell(source.x - 1, source.y))
                || dest.equals(Cell.getCell(source.x, source.y - 1))) {
            result[0] = dest;
        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * re-creating a new figure on the destination cell
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
