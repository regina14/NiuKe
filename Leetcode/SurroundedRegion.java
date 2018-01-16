package Leetcode;

public class SurroundedRegion {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
        int r = board.length;
        int c = board[0].length;
        boolean[][] vis = new boolean[r][c];
        printMatrix(board);
        for (int i = 0; i < r; i++){
            helper(board, vis, i, 0);
            helper(board, vis, i, c - 1);
        }

        for (int j = 0; j < c; j++){
            helper(board, vis, 0, j);
            helper(board, vis, r - 1, j);
        }
        System.out.println();
        printMatrix(board);
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
        System.out.println();
        printMatrix(board);
    }

    public static void helper(char[][] board, boolean[][] vis, int i, int j){
        int r = board.length;
        int c = board[0].length;
        if (i < 0 || i > r || j < 0 || j > c || board[i][j] != 'O' ){
            return;
        }
        //vis[i][j] = true;
        board[i][j] = '*';
        if (i < r - 2 && board[i + 1][j] == 'O'){
            helper(board, vis, i + 1, j);
        }
        if (i > 1 && board[i - 1][j] == 'O' ){
            helper(board, vis, i - 1, j);
        }

        if (j > 1 && board[i][j - 1] == 'O'){
            helper(board, vis, i, j - 1);
        }

        if (j < c - 2 && board[i][j + 1] == 'O'){
            helper(board, vis, i, j + 1);
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] test = {{'X','X','X','X'}, {'X','O','X','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] test2 = {"OOOOXX".toCharArray(),"OOOOOO".toCharArray(),"OXOXOO".toCharArray(),
                "OXOOXO".toCharArray(),"OXOXOO".toCharArray(),"OXOOOO".toCharArray()};
        solve(test2);
    }
}
