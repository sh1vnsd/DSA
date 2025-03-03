public class ratsinmaze {
    static void solveMaze(int maze[][], int i, int j, int n, StringBuilder path) {
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            System.out.println(path);
            return;
        }

        maze[i][j] = 0;

        // up
        path.append('U');
        solveMaze(maze, i - 1, j, n, path);
        path.deleteCharAt(path.length() - 1);

        // down
        path.append('D');
        solveMaze(maze, i + 1, j, n, path);
        path.deleteCharAt(path.length() - 1);

        // left
        path.append('L');
        solveMaze(maze, i, j - 1, n, path);
        path.deleteCharAt(path.length() - 1);

        // right
        path.append('R');
        solveMaze(maze, i, j + 1, n, path);
        path.deleteCharAt(path.length() - 1);

        maze[i][j] = 1;
    }

    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int n = maze.length;
        StringBuilder path = new StringBuilder();
        solveMaze(maze, 0, 0, n, path);
    }
}
