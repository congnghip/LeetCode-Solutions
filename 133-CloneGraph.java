import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution{
    public Node cloneGraph(Node node){
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            for (Node ser : curr.neighbors){
                if (!visited.containsKey(ser)) {
                    Node cne = new Node(ser.val, new ArrayList<Node>());
                    visited.put(ser, cne);
                    queue.add(ser);
                }
                visited.get(curr).neighbors.add(visited.get(ser));
            }
        }
        return visited.get(node);
    }
}