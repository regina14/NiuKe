package CrackingCodeInterview;

public class clearZero {
    //清楚行列
    public static int[][] clearZero(int[][] mat, int n) {
        // write code here
        if (mat == null || mat.length == 0){
            return mat;
        }
        printMatrix(mat);

        int r = mat.length;
        int c = mat[0].length;
        int col0 = 1;
        for (int i = 0; i < r; i++){
            if (mat[i][0] == 0) col0 = 0;
            for (int j = 1; j < c; j++){
                if (mat[i][j] == 0){

                    mat[i][0] = mat[0][j] = 0;

                }
            }
        }
        printMatrix(mat);
        for(int i = r - 1; i >= 0; i--){
            for(int j = c - 1; j >= 1; j--){
                if(mat[i][0] == 0 || mat[0][j] == 0){

                    System.out.printf("mat[%d][%d] : %d = 0, mat[%d][%d] : %d = 0\n", i, 0, mat[i][0], 0, j, mat[0][j]);
                    System.out.printf("i:%d , j:%d, %d \n", i, j, mat[i][j]);
                    mat[i][j] = 0;
                }
            }
            if(col0 == 0) mat[i][0] = 0;
        }
        printMatrix(mat);
        return mat;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{0,1,2},{0,0,1}};
        clearZero(mat, 3);
    }

}
