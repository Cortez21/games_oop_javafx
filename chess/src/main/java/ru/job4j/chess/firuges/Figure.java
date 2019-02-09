package ru.job4j.chess.firuges;

/**
 * //TODO add comments.
 *
 * @author Maxim Yunusov (cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);


}
