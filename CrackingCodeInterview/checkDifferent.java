package CrackingCodeInterview;

import java.util.*;

//确定字符互异
public class checkDifferent {
    public boolean checkDifferent(String iniString) {
        // write code here
        Set<Character> set = new HashSet<>();
        for (char a: iniString.toCharArray()){
            set.add(a);
        }
        return set.size() == iniString.length();
    }
}
