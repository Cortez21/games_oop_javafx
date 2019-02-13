package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
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
        for (Cell cell : possibleWays(source)) {
            if (cell.equals(dest)) {
                result = new Cell[] {dest};
            }
        }
        if (result[0] == null) {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * Calculating all possible ways for knight moving
     * @param source start position of figure
     * @return array of possible ways for figure
     */
    public ArrayList<Cell> possibleWays(Cell source) {
        ArrayList<Cell> possibleWays = new ArrayList<>();
        possibleWays.add(Cell.getCell(source.x - 1, source.y - 2));
        possibleWays.add(Cell.getCell(source.x + 1, source.y - 2));

        possibleWays.add(Cell.getCell(source.x + 2, source.y - 1));
        possibleWays.add(Cell.getCell(source.x + 2, source.y + 1));

        possibleWays.add(Cell.getCell(source.x + 1, source.y + 2));
        possibleWays.add(Cell.getCell(source.x - 1, source.y + 2));

        possibleWays.add(Cell.getCell(source.x - 2, source.y + 1));
        possibleWays.add(Cell.getCell(source.x - 2, source.y - 1));
        int max = 8;
        for (int i = 0; i < max; i++) {
            if (possibleWays.get(i) == null) {
                possibleWays.remove(i);
                i--;
                max--;
            }
        }
        return possibleWays;
    }

    /**
     * re-creating a new figure on the destination cell
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
