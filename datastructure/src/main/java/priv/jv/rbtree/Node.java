package priv.jv.rbtree;

/**
 * @author javie
 * @date 2019/7/24 16:41
 */
public class Node {

    public Double value;

    public Node parent;

    public Node left;

    public Node right;

    public boolean color = true;  //true 表示红色

    public Node(Double value) {
        this.value = value;
    }

    // 中序遍历
    public void inOrderTraversal(){
        if (left!=null){
            left.inOrderTraversal();
        }
        System.out.println(toString());
        if (right!=null){
            right.inOrderTraversal();
        }
    }

    @Override
    public String toString() {
        return "val:["+value+"],color:["+color+"]";
    }
}
