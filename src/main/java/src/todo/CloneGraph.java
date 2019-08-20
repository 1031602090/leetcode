package todo;

import other.Node;

import java.util.*;
import java.util.stream.Collectors;

public class CloneGraph {
    Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }
        Node clonedNode = new Node();
        cloned.put(node, clonedNode);
        List<Node> clonedNeighbors = cloneNeighbors(node.neighbors);
        clonedNode.val = node.val;
        clonedNode.neighbors = clonedNeighbors;
        return clonedNode;
    }

    private List<Node> cloneNeighbors(List<Node> node) {
        List<Node> t=null;
        if(node!=null){
            t = new LinkedList<>();
            for(Node n:node){
                t.add(cloneGraph(n));
            }
        }
        return t;
    }
}
