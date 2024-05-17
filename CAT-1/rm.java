import java.util.Scanner;

public class rm {
    static int sol[][], count = 0;

    public static boolean mazesolve(int[][] maze, int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (ispassible(maze, x, y)) {
            sol[x][y] = 1;

            if (mazesolve(maze, x, y + 1)) {
                return true;
            }
            if (mazesolve(maze, x + 1, y)) {
                return true;
            }
            sol[x][y] = 0;
        }
        return false;
    }
    
    public static boolean ispassible(int[][] maze, int x, int y) {
        count++;
        if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        sol = new int[maze.length][maze[0].length];
        if (mazesolve(maze, 0, 0)) {
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    System.out.print(" " + sol[i][j] + " ");

                }
                System.out.println();
            }
        }
        else {
            System.out.println("Solution is not possible");
        }
        sc.close();
        
     }
}
