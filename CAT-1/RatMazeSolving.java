public class RatMazeSolving {
    static int sol[][], cont = 0;

    static boolean MazeSolve(int maze[][], int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (ispassible(maze, x, y)) {
            sol[x][y] = 1;

            if (MazeSolve(maze, x, y + 1))
                return true;

            if (MazeSolve(maze, x + 1, y))
                return true;

            sol[x][y] = 0;
        }
        return false;
    }

    static boolean ispassible(int maze[][], int x, int y) {
        cont++;
        if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {

        int maze[][] = { { 1, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };
        sol = new int[maze.length][maze[0].length];

        if (MazeSolve(maze, 0, 0))
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++)
                    System.out.print(" " + sol[i][j] + " ");
                System.out.println();
            }

        else
            System.out.println("Solution is not possible");
    }

}
