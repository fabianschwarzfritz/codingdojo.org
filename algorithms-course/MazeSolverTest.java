import static org.junit.Assert.*;

import org.junit.Test;

public class MazeSolverTest {
    @Test
    public void testSimple() {
        String[] maze = new String[] {
            "##### #",
            "#     #",
            "# #####",
        };


        MazeSolver.Point[] trip =
            new MazeSolver().solve(maze, "#",
            new MazeSolver.Point(1, 2),
            new MazeSolver.Point(5, 0));

        for (MazeSolver.Point p : trip) {
            System.out.println(p.toString());
        }

        MazeSolver.Point[] exp = new MazeSolver.Point[]{
            new MazeSolver.Point(1, 2),
            new MazeSolver.Point(1, 1),
            new MazeSolver.Point(2, 1),
            new MazeSolver.Point(3, 1),
            new MazeSolver.Point(4, 1),
            new MazeSolver.Point(5, 1),
            new MazeSolver.Point(5, 0),
        };

        assertArrayEquals(exp, trip);
    }
}
