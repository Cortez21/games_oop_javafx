package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CellTest {
    @Test
    public void whenCellHasCoordinates1And1() {
        assertThat(Cell.getCell(7, 6).toString(), is("H7"));
    }
}
