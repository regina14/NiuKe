package CrackingCodeInterview;

//翻转字串
public class checkReverseEqual {
    public static boolean checkReverseEqual(String s1, String s2) {
        // write code here
        if (s1.length() != s2.length()){
            return false;
        }

        int len = s1.length();
        for (int i = 1; i < len; i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, len - i);
            String s22 = s2.substring(len  - i);
            System.out.printf("s11: %s, s12: %s\n", s11, s12);
            System.out.printf("s21: %s, s22: %s\n", s21, s22);
            if (s11.equals(s22) && s12.equals(s21)){
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }

    public static void main(String[] args) {
        String t11 = "Hello world"; String t12 = "worldhello ";
        String t21 = "waterbottle"; String t22 = "erbottlewat";
        //checkReverseEqual(t11, t12);
        checkReverseEqual(t21, t22);
    }
}
