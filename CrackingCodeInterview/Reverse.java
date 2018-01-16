package CrackingCodeInterview;

//原串翻转
public class Reverse {
    public String reverseString(String iniString) {
        // write code here
        if (iniString == null || iniString.length() == 0){
            return "";
        }

        int len = iniString.length();
        char[] cs = iniString.toCharArray();
        for (int i = 0; i < len/2; i++){
            swap(cs, i, len - 1 - i);
        }
        return new String(cs);
    }

    public void swap(char[] cs, int l, int r){
        char temp = cs[l];
        cs[l] = cs[r];
        cs[r] = temp;
    }
}
