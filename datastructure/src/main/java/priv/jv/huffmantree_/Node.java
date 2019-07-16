package priv.jv.huffmantree_;
public class Node implements Comparable<Node>{
     Integer value;
     Byte data;
     Node left;
     Node right;
     public Node(Byte data,Integer value) {
           super();
           this.value = value;
           this.data = data;
     }
     @Override
     public int compareTo(Node o) {
           // TODO Auto-generated method stub
           return -(this.value-o.value);
     }
     @Override
     public String toString() {
           return "AVLTreeNode [value=" + value + ", data=" + data +  "]";
     }
     
}