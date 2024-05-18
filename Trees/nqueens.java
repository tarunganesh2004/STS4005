import java.util.Scanner;

public class nqueens {
    public static boolean isSafe(int board[][], int row, int col, int N) {
        int i, j;
        
        for ( j = col; j >= 0; j--) {
            if (board[row][j] == 1) {
                return false;
            }
        }
        for ( i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for ( i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean solveNqutil(int[][] board, int col, int N) {
        if (col >= N)
            return true;
        

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;

                if (solveNqutil(board, col + 1, N)) {
                    return true;
                }
            }
            board[i][col] = 0;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int board[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        if (solveNqutil(board, 0, N)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(" " + board[i][j] + " ");

                }
                System.out.println();
            }
        } else {
            System.out.println("Solution does not exist");
        }
        sc.close();
    }
}
