package CrackingCodeInterview;
import java.util.*;
//猫狗收容所
public class CatDogAsylum {
    public static ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if (ope == null || ope.length == 0){
            return res;
        }
        int len = ope.length;
        int cnt = 0;
        Deque<int[]> queDog  = new ArrayDeque<>();
        Deque<int[]> queCat = new ArrayDeque<>();

        for (int i = 0; i < len; i++){
            System.out.printf("[%d, %d]\n", ope[i][0], ope[i][1]);
            if (ope[i][0] == 1){
                if (ope[i][1] > 0){
                    queDog.addLast(new int[]{ope[i][1], cnt++});
                } else if (ope[i][1] < 0){
                    queCat.addLast(new int[]{ope[i][1], cnt++});
                }
                System.out.print("DogQueue: ");
                System.out.println(queDog);
                System.out.print("CatQueue: ");
                System.out.println(queCat);
            } else if (ope[i][0] == 2){
                if (ope[i][1] == 0){
                    if (queDog.isEmpty() && queCat.isEmpty()) {
                        continue;
                    } else if (queDog.isEmpty() || queCat.isEmpty()){
                        res.add(queCat.isEmpty()? queDog.poll()[0] : queCat.poll()[0]);
                    } else {
                        int catCnt = queCat.peekFirst()[1];
                        int dogCnt = queDog.peekFirst()[1];
                        System.out.printf("catCnt: %d, dogCnt: %d\n", catCnt, dogCnt);
                        res.add(catCnt < dogCnt? queCat.pollFirst()[0] : queDog.pollFirst()[0]);
                        System.out.println(res);
                    }
                } else if (ope[i][1] == 1){
                    if(!queDog.isEmpty()){
                        res.add(queDog.poll()[0]);
                    }
                } else if (ope[i][1] == -1){
                    if (!queCat .isEmpty()){
                        res.add(queCat.poll()[0]);
                    }
                }
            }
        }
        System.out.println(res);
        return res;
     }

    public static void main(String[] args) {
        int[][] t = {{1,1},{1,-1},{2,0},{2,-1}};
        int[][] t2 = {
                {1,-5},{1,-1},{1,9},{1,9},{2,0},{2,1},{1,-8},{2,1},{1,-71},{1,-92},{1,18},{1,91},{1,61},{2,-1},{1,-35},{1,95},{1,-49},{1,9},{1,78},{2,0},{1,91},{1,-96},{2,-1},{2,0},{2,-1},{2,1},{1,38},{2,0},{1,45},{2,0},{1,-51},{2,1},{2,1},{2,-1},{1,39},{1,59},{1,45},{2,0},{1,-70},{2,0},{1,23},{1,88},{1,83},{1,69},{1,-78},{1,-3},{1,-9},{1,-20},{1,-74},{1,-62},{1,5},{1,55},{1,-36},{1,-21},{1,-94},{1,-27},{1,-69},{2,0},{1,-30},{1,-84},{2,0},{2,0},{2,-1},{1,92},{1,60},{2,1},{2,0},{1,-63},{2,0},{1,-87},{1,66},{2,0},{1,17},{2,0},{2,1},{1,-41},{1,-3},{1,-29},{1,72},{2,1},{1,35},{1,81},{1,-83},{1,-17},{1,36},{1,99},{1,-17},{1,8},{2,0},{1,80},{1,50},{1,80},{2,0},{1,-48},{1,-82},{1,-63},{1,2},{2,1},{1,-43},{1,59},{1,93},{1,55},{1,-93},{2,-1},{1,2},{1,13},{2,0}
        };

        //String s = "[2,1],[1,-8],[2,1],[1,-71],[1,-92],[1,18],[1,91],[1,61],[2,-1],[1,-35],[1,95],[1,-49],[1,9],[1,78],[2,0],[1,91],[1,-96],[2,-1],[2,0],[2,-1],[2,1],[1,38],[2,0],[1,45],[2,0],[1,-51],[2,1],[2,1],[2,-1],[1,39],[1,59],[1,45],[2,0],[1,-70],[2,0],[1,23],[1,88],[1,83],[1,69],[1,-78],[1,-3],[1,-9],[1,-20],[1,-74],[1,-62],[1,5],[1,55],[1,-36],[1,-21],[1,-94],[1,-27],[1,-69],[2,0],[1,-30],[1,-84],[2,0],[2,0],[2,-1],[1,92],[1,60],[2,1],[2,0],[1,-63],[2,0],[1,-87],[1,66],[2,0],[1,17],[2,0],[2,1],[1,-41],[1,-3],[1,-29],[1,72],[2,1],[1,35],[1,81],[1,-83],[1,-17],[1,36],[1,99],[1,-17],[1,8],[2,0],[1,80],[1,50],[1,80],[2,0],[1,-48],[1,-82],[1,-63],[1,2],[2,1],[1,-43],[1,59],[1,93],[1,55],[1,-93],[2,-1],[1,2],[1,13],[2,0]]";
        //s = s.replaceAll("\\[", "{");
        //s = s.replaceAll("\\]", "}");
        //System.out.println(s);
        asylum(t2);
    }
}
