package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
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
        Cell[] steps;
        if (dest.x == source.x && dest.y + 1 == source.y) {
            steps = new Cell[] {dest};
        } else {
            throw new ImpossibleMoveException();
        }
        return steps;

    }

    /**
     * re-creating a new figure on the destination cell
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
