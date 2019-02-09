package ru.job4j.chess.firuges.white;

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

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] result = new Cell[] { source };
        for (Cell cell : possibleWays(source)) {
            if (cell.equals(dest)) {
                result = new Cell[] {dest};
            }
        }
        return result;
    }

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

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
