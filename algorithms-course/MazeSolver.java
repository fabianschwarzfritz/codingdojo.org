import java.util.LinkedList;
import java.util.List;

class MazeSolver {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Point o = (Point) obj;
            return this.x == o.x && this.y == o.y;
        }
    }

    public Point[] solve(String[] maze, String wall, Point start, Point end) {
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        List<Point> path = new LinkedList<>();
        this.walk(maze, wall, start, end, seen, path);
        return path.toArray(new Point[]{});
    }

    private boolean walk(String[] maze, String wall, Point curr, Point end, boolean[][] seen, List<Point> path) {
        System.out.println("Looking at X: " + curr.x + " and Y: " + curr.y);

        // 1 Base cases. Off the map.
        if (curr.x < 0 || maze[0].length() <= curr.x) {
            return false;
        } else if (curr.y < 0 || maze.length <= curr.y) {
            return false;
        }
        // 2 base case wall
        if (maze[curr.y].charAt(curr.x) == wall.charAt(0)) {
            return false;
        }
        // 3 Base case Exit
        if (curr.x == end.x && curr.y == end.y) {
            // Ending has to get pushed in as well
            path.add(new Point(curr.x, curr.y));
            return true;
        }

        if (seen[curr.y][curr.x]) {
            return false;
        }

        // Pre = For tracking
        seen[curr.y][curr.x] = true;
        path.add(curr);

        // Four relative directions
        int[][] dir = new int[][]{
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {0, -1}
        };

        // go into the direction
        for (int i = 0; i < dir.length; i++) {
            int[] d = dir[i];
            Point p = new Point(curr.x + d[0], curr.y + d[1]);
            boolean foundEnd = this.walk(maze, wall, p, end, seen, path);

            if (foundEnd) { 
                return true;
            }
        }

        // Post = For tracking
        path.remove(path.size() - 1);

        return false;
    }
}
