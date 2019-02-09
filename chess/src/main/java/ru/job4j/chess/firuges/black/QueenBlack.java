package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;

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

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] result = new Cell[] {source};
        for (Cell cell : possibleWays(source)) {
            if (dest.equals(cell)) {
                result = getSteps(source, dest);
            }
        }
        return result;
    }

    public Cell[] getSteps(Cell source, Cell dest) {
        int numOfSteps = getNumOfSteps(source, dest);
        Cell[] result = new Cell[numOfSteps];
        int index = 0;
        if (source.x == dest.x && source.y > dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x, source.y - i);
            }
        } else if (source.x < dest.x && source.y > dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x + i, source.y - i);
            }
        } else if (source.x < dest.x && source.y == dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x + i, source.y);
            }
        } else if (source.x < dest.x && source.y < dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x + i, source.y + i);
            }
        } else if (source.x == dest.x && source.y < dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x, source.y + i);
            }
        } else if (source.x > dest.x && source.y < dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x - i, source.y + i);
            }
        } else if (source.x > dest.x && source.y == dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x - i, source.y);
            }
        } else if (source.x > dest.x && source.y > dest.y) {
            for (int i = 1; i <= numOfSteps; i++) {
                result[index++] = Cell.getCell(source.x - i, source.y - i);
            }
        }

        return result;
    }

    public int getNumOfSteps(Cell source, Cell dest) {
        int numOfSteps;
        if (source.x == dest.x && source.y > dest.y) {
            numOfSteps = source.y - dest.y;
        } else if (source.x == dest.x && source.y < dest.y) {
            numOfSteps = dest.y - source.y;
        } else if (source.y == dest.y && source.x > dest.x) {
            numOfSteps = source.x - dest.x;
        } else if (source.y == dest.y && source.x < dest.x) {
            numOfSteps = dest.x - source.x;
        } else {
            numOfSteps = Math.abs(source.x - dest.x);
        }
        return numOfSteps;
    }

    /**
     * Check all possible ways for action
     * @param source - source position of figure
     * @return - array of all cells for possible action
     */
    public ArrayList<Cell> possibleWays(Cell source) {
        Cell[] possibleWays = new Cell[28];
        ArrayList<Cell> result = new ArrayList<>();
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
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x, source.y - i) != null) {
                possibleWays[index++] = Cell.getCell(source.x, source.y - i);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x + i, source.y) != null) {
                possibleWays[index++] = Cell.getCell(source.x + i, source.y);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x, source.y + i) != null) {
                possibleWays[index++] = Cell.getCell(source.x, source.y + i);
            } else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (Cell.getCell(source.x - i, source.y) != null) {
                possibleWays[index++] = Cell.getCell(source.x - i, source.y);
            } else {
                break;
            }
        }
        for (Cell cell : possibleWays) {
            if (cell != null) {
                result.add(cell);
            }
        }

        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
