
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class gg {

	 public static int longestPathWithSameValue(int[] A, int[] E) {
	        if (A == null || A.length < 1 || E == null ) {
	            return 0;
	        }
	        Node[] nodes = new Node[A.length];
	        int i = 0;
	        while( i< A.length) {
	            nodes[i] = new Node(A[i]);
	            i++;
	        }
	        int q = E.length;
	        for (int j = 0; j < q; j += 2) {
	            nodes[E[j] - 1].neighbors.add(nodes[E[j + 1] - 1]);
	            nodes[E[j + 1] - 1].neighbors.add(nodes[E[j] - 1]);
	        }
	        int[] res = new int []{0};
	        int ans =Math.max(res[0], helper(nodes[0], null, res));
	        return ans; 
	    }

	    public static int helper(Node root, Node prev, int[] res) {
	        int sum = 0;
	        for (Node neighbor : root.neighbors) {
	            if (neighbor == prev) {
	                continue;  
	            }
	            
	            int temp = helper(neighbor, root, res);
	            if (root.label == neighbor.label) {
	                sum += temp + 1;
	            }
	        }
	        res[0] = Math.max(res[0], sum);
	        return sum;
	    }

	    public static class Node {
	        public int label;
	        public ArrayList<Node> neighbors;
	        public Node(int label) {
	            this.label = label;
	            this.neighbors = new ArrayList<>();
	        }
	    }

	    public static void main(String[] args) {
	        int[] A = {1,2,3,4,5};
	        int[] E = {1,2,1,3,2,4,2,5};
//	        buildTree(A,E);
	        System.out.println(longestPathWithSameValue(A, E)); // 4
	    }
}