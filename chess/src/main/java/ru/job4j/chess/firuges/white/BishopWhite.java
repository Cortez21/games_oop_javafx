package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] result = new Cell[] {source};
        Cell[] possibleWays = possibleWays(source);
        for (Cell cell : possibleWays) {
            if (dest == cell) {
                result = getSteps(source, dest);
                break;
            }
        }

        return result;
    }

    /**
     * Check all possible ways for action
     * @param source - source position of figure
     * @return - array of all cells for possible action
     */
    public Cell[] possibleWays(Cell source) {
        Cell[] possibleWays = new Cell[13];
        int index = 0;
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x+ i, source.y + i) != null) {
                possibleWays[index++] = Cell.getCell(source.x + i, source.y+ i);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x - i, source.y + i) != null) {
                possibleWays[index++] = Cell.getCell(source.x - i, source.y + i);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x - i, source.y - i) != null) {
                possibleWays[index++] = Cell.getCell(source.x - i, source.y - i);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x + i, source.y - i) != null) {
                possibleWays[index++] = Cell.getCell(source.x + i, source.y - i);
            } else {
                break;
            }
        }

        return possibleWays;
    }

    public Cell[] getSteps(Cell source, Cell dest) {
        int steps = Math.abs(source.x - dest.x);
        Cell[] result = new Cell[steps];
        int index = 0;
        if (source.x < dest.x && source.y < dest.y) {
            for (int i = 1; i <= steps; i++) {
                result[index++] = Cell.getCell(source.x + i, source.y + i);
            }
        } else if (source.x > dest.x && source.y < dest.y) {
            for (int i = 1; i <= steps; i++) {
                result[index++] = Cell.getCell(source.x - i, source.y + i);
            }
        } else if (source.x > dest.x && source.y > dest.y) {
            for (int i = 1; i <= steps; i++) {
                result[index++] = Cell.getCell(source.x - i, source.y - i);
            }
        } else if (source.x < dest.x && source.y > dest.y) {
            for (int i = 1; i <= steps; i++) {
                result[index++] = Cell.getCell(source.x + i, source.y - i);
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
