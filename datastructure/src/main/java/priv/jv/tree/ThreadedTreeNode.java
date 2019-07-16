package priv.jv.tree;

/**
 * @author javie
 * @date 2019/7/5 23:30
 */
public class ThreadedTreeNode {

    public ThreadedTreeNode(int data) {
        this.data = data;
    }

    private int data;
    // 左结点
    private ThreadedTreeNode leftNode;
    // 右结点
    private ThreadedTreeNode rightNode;
    // 左结点类型
    private int leftType;
    // 右结点类型
    private int rightType;

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftNode(ThreadedTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(ThreadedTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getData() {
        return data;
    }

    public ThreadedTreeNode getLeftNode() {
        return leftNode;
    }

    public ThreadedTreeNode getRightNode() {
        return rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        //遍历左子树
        if (this.leftNode!=null){
            leftNode.inOrderTraversal();
        }
        //当前结点
        System.out.println(this.data);
        //右子树
        if (this.rightNode!=null){
            rightNode.inOrderTraversal();
        }
    }

    /**
     * 中序查找
     */
    public ThreadedTreeNode inOrderSearch(int data) {
        // 查找左子树
        if (leftNode != null) {
            if (leftNode.data == data) {
                return leftNode;
            } else {
                ThreadedTreeNode result = leftNode.inOrderSearch(data);
                if (result != null)
                    return result;
            }
        }
        // 当前结点
        if (this.data == data)
            return this;
        // 右子树
        if (rightNode != null) {
            if (rightNode.data == data) {
                return rightNode;
            } else {
                return rightNode.inOrderSearch(data);
            }
        }
        return null;
    }
}
