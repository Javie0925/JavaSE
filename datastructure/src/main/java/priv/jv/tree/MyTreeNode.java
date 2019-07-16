package priv.jv.tree;

/**
 * @author javie
 * @date 2019/7/4 23:38
 */
public class MyTreeNode {

    private int value;

    private MyTreeNode leftNode;

    private MyTreeNode rightNode;

    public MyTreeNode(int value){
        this.value=value;
    }

    public MyTreeNode(int value, MyTreeNode leftNode, MyTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftNode(MyTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(MyTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public MyTreeNode getLeftNode() {
        return leftNode;
    }

    public MyTreeNode getRightNode() {
        return rightNode;
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        System.out.print(this.value+",");
        if (this.leftNode!=null) {
            leftNode.preOrderTraversal();
        }
        if (this.rightNode!=null) {
            rightNode.preOrderTraversal();
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        if (this.leftNode!=null)
            leftNode.inOrderTraversal();
        System.out.print(this.value+",");
        if (this.rightNode!=null)
            rightNode.inOrderTraversal();
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        if (this.leftNode!=null)
            leftNode.postOrderTraversal();
        if (this.rightNode!=null)
            rightNode.postOrderTraversal();
        System.out.print(this.value+",");
    }

    /**
     * 前序查找
     * @param value
     * @return
     */
    public MyTreeNode preOrderSearch(int value){
        MyTreeNode target = null;
        if (this.value==value)
            return this;
        if (this.leftNode!=null) {
            target = leftNode.preOrderSearch(value);
            if (target!=null)
                return target;
        }
        if (this.rightNode!=null) {
            target = rightNode.preOrderSearch(value);
            if (target!=null)
                return target;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.value+"";
    }

    /**
     * 删除子结点
     * @param dst
     */
    public boolean delete(int dst){

        // 左结点
        if (this.leftNode!=null) {
            if (this.leftNode.value == dst) {
                this.leftNode = null;
                return true;
            } else {
                if(this.leftNode.delete(dst)){
                    return true;
                }
            }
        }
        // 右结点
        if (this.rightNode!=null) {
            if (this.rightNode.value == dst) {
                this.rightNode = null;
                return true;
            } else {
                return this.rightNode.delete(dst);
            }
        }
        return false;

    }


}
