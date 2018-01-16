package CrackingCodeInterview;

import java.util.Arrays;

//确定两串乱序同构
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        if (stringA.length() != stringB.length()){
            return false;
        }

        char[] csA = stringA.toCharArray();
        char[] csB = stringB.toCharArray();

        Arrays.sort(csA);
        Arrays.sort(csB);
        return Arrays.equals(csA, csB);
    }
}
