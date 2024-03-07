public class NQueens {
    static int N = 4;

    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        for (j = col; j >= 0; j--)
            if (board[row][j] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    static boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;
            }
            board[i][col] = 0;
        }
        return false;
    }

    public static void main(String args[]) {
        int board[][] = new int[N][N];

        if (solveNQUtil(board, 0)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(" " + board[i][j] + " ");
                System.out.println();
            }
        } else
            System.out.print("Solution does not exist");
    }

}
