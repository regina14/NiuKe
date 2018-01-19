package 剑指offer;

//正则表达式匹配
public class RegularExpression {
    public static boolean match(char[] str, char[] pattern)
    {
        int l1 = str.length;
        int l2 = pattern.length;
        boolean[][] mt = new boolean[l1 + 1][l2 + 1];
        mt[0][0] = true;

        for (int j = 1; j <= l2; j++){
            if (pattern[j - 1] == '*'){
                mt[0][j] = mt[0][j - 2];
            }
        }

        for (int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++){
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.'){
                    mt[i][j] = mt[i - 1][j - 1];
                } else if (pattern[j - 1] == '*'){
                    mt[i][j] = mt[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]){
                        mt[i][j] = mt[i][j] | mt[i - 1][j];
                    }
                }
            }
        }

        printMatrix(mt);

        return mt[l1][l2];
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] s1 = "aaa".toCharArray();
        char[] p1 = "a.*ac*a".toCharArray();
        //match(s1, p1);

        char[] s2 = "a".toCharArray();
        char[] p2 = {'.','*'};
        match(s2, p2);
    }
}
