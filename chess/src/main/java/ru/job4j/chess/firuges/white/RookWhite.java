package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[] {source};
        if (source.x == dest.x || source.y == dest.y) {
            if (source.x == dest.x && dest.y > source.y) {
                steps = new Cell[dest.y - source.y];
                int a = 0;
                for (int i = source.y + 1; i < dest.y + 1; i++) {
                    steps[a] = Cell.getCell(source.x, i);
                    a++;
                }
            } else if (source.x == dest.x && dest.y < source.y) {
                steps = new Cell[source.y - dest.y];
                int a = 0;
                for (int i = source.y - 1; i > dest.y - 1; i--) {
                    steps[a] = Cell.getCell(source.x, i);
                    a++;
                }
            } else if (source.y == dest.y && dest.x > source.x) {
                steps = new Cell[dest.x - source.x];
                int a = 0;
                for (int i = source.x + 1; i < dest.x + 1; i++) {
                    steps[a] = Cell.getCell(i, source.y);
                    a++;
                }
            } else if (source.y == dest.y && dest.x < source.x) {
                steps = new Cell[source.x - dest.x];
                int a = 0;
                for (int i = source.x - 1; i > dest.x - 1; i--) {
                    steps[a] = Cell.getCell(i, source.y);
                    a++;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
