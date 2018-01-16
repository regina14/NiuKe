package Leetcode;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class CloneGraph {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Deque<UndirectedGraphNode> que = new ArrayDeque<>();
        que.offer(node);
        map.put(node, newNode);

        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = que.poll();
                List<UndirectedGraphNode> ne = cur.neighbors;
                for (UndirectedGraphNode n: ne) {
                    if (map.containsKey(n)) {
                        map.get(cur).neighbors.add(map.get(n));
                    } else {
                        UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                        map.put(n, copy);
                        map.get(cur).neighbors.add(copy);
                        que.offer(n);
                    }
                }
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        cloneGraph(node0);
    }

    public static void printNode(UndirectedGraphNode node){
        System.out.print(node.label + " : ");
        for (UndirectedGraphNode n: node.neighbors){
            System.out.print(n.label + " | ");
        }
        System.out.println();
    }
}
