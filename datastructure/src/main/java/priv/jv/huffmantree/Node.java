package priv.jv.huffmantree;

/**
 * @author javie
 * @date 2019/7/6 19:49
 */
public class Node implements Comparable<Node>{

    private int weight;

    private Byte data;

    private Node leftNode;

    private Node rightNode;

    public Node( Byte data,int weight) {
        this.weight = weight;
        this.data = data;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getWeight() {
        return weight;
    }

    public Byte getData() {
        return data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        // 遍历左子树
        if (this.leftNode!=null)
            this.leftNode.inOrderTraversal();
        // 打印自己
        System.out.print(this.weight+",");
        // 遍历右子树
        if (this.rightNode!=null)
            this.rightNode.inOrderTraversal();
    }

    @Override
    public String toString() {
        if (data!=null) {
            return "{" + (char)data.byteValue() +
                    "," + weight +
                    '}';
        }else {
            return "{" + data +
                    "," + weight +
                    '}';
        }
    }

    public int compareTo(Node o) {
        return this.weight - o.weight;//正序
    }
}
