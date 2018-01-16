package Leetcode;
import java.util.*;

class Word{
    Word pre = null;
    int step = 0;
    String s = "";
    public Word(String s, int step, Word pre){
        this.pre = pre;
        this.s = s;
        this.step = step;
    }
}
public class wordLadderII {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if (dict.size() == 0) {
            return res;
        }
        dict.add(end);
        Deque<Word> que = new ArrayDeque<>();
        que.offer(new Word(start, 1, null));

        Set<String> vis = new HashSet<>();
        Set<String> unvis = new HashSet<>();
        unvis.addAll(dict);
        int minStep = 0;
        int preStep = 0;

        while (!que.isEmpty()) {
            //int size = que.size();
            //for (int j = 0; j < size; j++) {
                System.out.print("que: ");
                printQ(que);
                System.out.print("set: ");
                System.out.println(dict);
                Word cur = que.poll();
                String curs = cur.s;
                int curStep = cur.step;
                System.out.print("cur: ");
                printW(cur);
                System.out.printf("minStep: %d\n", minStep);
                if (curs.equals(end)) {
                    if (minStep == 0) {
                        minStep = curStep;
                    }

                    if (curStep == minStep && minStep != 0) {
                        ArrayList<String> list = new ArrayList<>();
                        while (cur != null) {
                            list.add(0, cur.s);
                            cur = cur.pre;
                        }
                        System.out.print("list: ");
                        System.out.println(list);
                        res.add(list);
                        continue;
                    }
                }

                if (preStep < curStep) {
                    preStep = curStep;
                }
                unvis.removeAll(vis);
                System.out.print("vis: ");
                System.out.println(vis);
                System.out.print("unvis: ");
                System.out.println(unvis);


                char[] cs = curs.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char temp = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cs[i] == c) continue;
                        cs[i] = c;
                        String ns = new String(cs);
                        if (unvis.contains(ns)) {
                            que.offer(new Word(ns, cur.step + 1, cur));
                            vis.add(cur.s);
                            System.out.print("After que: ");
                            printQ(que);
                            System.out.print("After vis: ");
                            System.out.println(vis);
                            System.out.print("After unvis: ");
                            System.out.println(unvis);
                        }
                        cs[i] = temp;
                    }
                }
            }
        //}
        System.out.println(res);
        return res;
    }

    public static void printQ(Deque<Word> que){
        for (Word w: que){
            System.out.print("(");
            printW(w);
            System.out.print(")");
        }
        System.out.println();
    }

    public static void printW(Word w){
        System.out.printf("String: %s, Step: %d,", w.s, w.step);
        if (w.pre == null){
            System.out.print("null");
        } else {
            System.out.print(w.pre.s);
        }
    }

    public static void main(String[] args) {
        String start ="hit";
        String end ="cog";
        HashSet<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        findLadders(start, end, dict);
    }
}
