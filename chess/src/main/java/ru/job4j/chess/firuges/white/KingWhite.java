package ru.job4j.chess.firuges.white;

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

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] result = new Cell[1];
        if (dest.equals(Cell.getCell(source.x + 1, source.y))
                || dest.equals(Cell.getCell(source.x, source.y + 1))
                || dest.equals(Cell.getCell(source.x - 1, source.y))
                || dest.equals(Cell.getCell(source.x, source.y - 1))) {
            result[0] = dest;
        } else {
            result[0] = source;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
