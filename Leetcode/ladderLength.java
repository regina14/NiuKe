package Leetcode;
import java.util.*;
public class ladderLength {
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0){
            return 0;
        }
        dict.add(end);

        Deque<String> que = new ArrayDeque<>();
        que.offer(start);
        int cnt = 1;
        while (!que.isEmpty()){
            System.out.printf("cnt: %d\n", cnt);
            System.out.print("que: ");
            System.out.println(que);
            System.out.print("set: ");
            System.out.println(dict);

            int size = que.size();
            for (int i = 0; i < size; i++){
                String cur = que.poll();
                char[] cs = cur.toCharArray();
                System.out.printf("cur: %s\n", cur);
                for (int j = 0; j < cur.length(); j++){
                    char temp = cs[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        if (temp == c) continue;
                        cs[j] = c;
                        String ns = new String(cs);
                        if (dict.contains(ns)){
                            System.out.printf("new String: %s\n", ns);
                            if (ns.equals(end)){
                                return cnt + 1;
                            }
                            que.offer(ns);
                            dict.remove(ns);
                            System.out.print("After que: ");
                            System.out.println(que);
                            System.out.print("After set: ");
                            System.out.println(dict);

                        }
                        cs[j] = temp;
                    }
                }
            }
            cnt++;
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args) {
        String start ="hit";
        String end ="cog";
        HashSet<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(start, end, dict));
    }
}
