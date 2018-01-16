package CrackingCodeInterview;



//基本字符串压缩
public class zipString {
    public static String zipString(String iniString) {
        // write code here
        if (iniString == null || iniString.length() <= 1){
            return "";
        }
        int i = 0;
        int len = iniString.length();
        StringBuilder sb  = new StringBuilder();
        while(i < len){
            char c = iniString.charAt(i);
            int j = i;
            while (j < len && iniString.charAt(j) == c){
                j++;
            }

            sb.append(String.valueOf(c) + (j - i));

            i = j;
        }
        System.out.println(sb.toString());
        return sb.toString().length() > len? iniString : sb.toString();
    }

    public static void main(String[] args) {
        zipString("aabcccccaaa");
    }
}
