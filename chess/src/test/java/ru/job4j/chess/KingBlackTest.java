package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KingBlack;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * //TODO add comments.
 *
 * @author Maxim Yunusov (cortezzz1987gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KingTest {
    @Test
    public void whenSourceE8DestE7() {
        assertThat(new KingBlack(Cell.E8).way(Cell.E8, Cell.E7), is (new Cell[] {Cell.E7}));
    }

    @Test
    public void whenSourceE8DestF7() {
        assertThat(new KingBlack(Cell.E8).way(Cell.E8, Cell.F7), is (new Cell[] {Cell.E8}));
    }
}
