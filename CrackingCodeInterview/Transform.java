package CrackingCodeInterview;

//像素翻转
public class Transform {
    public static int[][] transformImage(int[][] mat, int n) {
        // write code here
        int r = mat.length;
        int c = mat[0].length;
        //printMatrix(mat);
        //System.out.println();
        for (int i = 0; i < r / 2; i++){
            for (int j = 0; j < c; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[r - i - 1][j];
                mat[r - i - 1][j] = temp;
            }
        }

        //printMatrix(mat);
        //System.out.println();
        for (int i = 0; i < r; i++){
            for (int j = 0; j < i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //printMatrix(mat);
        return mat;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] t1 = {{1, 2, 3},{4, 5, 6},{7,8,9}};
        transformImage(t1, 3);
    }
}
