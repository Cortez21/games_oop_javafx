package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlackTest {
    @Test
    public void whenPositionIsD5() {
        assertThat(new BishopBlack(Cell.D5).possibleWays(Cell.D5), is(new Cell[] {
                Cell.E6,
                Cell.F7,
                Cell.G8,
                Cell.C6,
                Cell.B7,
                Cell.A8,
                Cell.C4,
                Cell.B3,
                Cell.A2,
                Cell.E4,
                Cell.F3,
                Cell.G2,
                Cell.H1
        }));
    }

    @Test
    public void whenSourceC8DestH3() {
        assertThat(new BishopBlack(Cell.C8).way(Cell.C8,Cell.H3), is(new Cell[] {
                Cell.D7,
                Cell.E6,
                Cell.F5,
                Cell.G4,
                Cell.H3
        }));
    }
}
