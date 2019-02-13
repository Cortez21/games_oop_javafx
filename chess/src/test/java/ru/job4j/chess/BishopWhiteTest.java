package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhiteTest {

    @Test
    public void whenSourceC8DestH3() throws ImpossibleMoveException {
        assertThat(new BishopWhite(Cell.C8).way(Cell.C8,Cell.H3), is(new Cell[] {
                Cell.D7,
                Cell.E6,
                Cell.F5,
                Cell.G4,
                Cell.H3
        }));
    }

    @Test
    public void whenSourceD7DestH2() {
        boolean isException = false;
        try {
            new BishopWhite(Cell.D7).way(Cell.D7, Cell.H2);
        } catch (ImpossibleMoveException e) {
            isException = true;
        }
        assertThat(isException, is(true));
    }
}