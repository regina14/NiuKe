package CrackingCodeInterview;

//空格替换
public class Replacement {
    public static String replaceSpace(String iniString, int length) {
        // write code here
        if(length <= 0){
            return iniString;
        }
        String res = iniString.replaceAll(" ", "\\%20");
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String t1 = "Mr John Smith";
        String t2 = "Hello  World";
        replaceSpace(t1, 13);
        replaceSpace(t2, 12);
    }
}
