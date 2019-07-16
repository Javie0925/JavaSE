package priv.jv.binarysorttree;

/**
 * @author javie
 * @date 2019/7/8 15:51
 */
public class Node {

    private int value;

    private Node leftNode;

    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    /**
     * 添加结点
     * @param node
     */
    public void addNode(Node node){
        // 比自己小或等于
        if (node==null)
            return;
        if (node.value<=this.value){
            if (this.leftNode==null){
                this.leftNode = node;
            }else {
                this.leftNode.addNode(node);
            }
        }else { // 比自己大
            if (this.rightNode==null){
                this.rightNode=node;
            }else {
                this.rightNode.addNode(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        if (this.leftNode!=null){
            this.leftNode.inOrderTraversal();
        }
        System.out.print(this.value+",");
        if (this.rightNode!=null){
            this.rightNode.inOrderTraversal();
        }
    }

    /**
     * 查找方法
     * @param value
     * @return
     */
    public Node search(int value){
        if (value==this.value){
            return this;
        }else if (value<=this.value){
            if (this.leftNode==null){
                return null;
            }else {
                return this.leftNode.search(value);
            }
        }else {
            if (this.rightNode==null){
                return null;
            }else {
                return this.rightNode.search(value);
            }
        }
    }

    public boolean deleteChild(int value){
        // 左结点
        if (value<this.value){
            if (this.leftNode==null)
                return false;
            if (this.leftNode.value== value){
                // 没有子结点
                if (this.leftNode.childNode()==0) {
                    this.leftNode = null;
                    return true;
                }else if (this.leftNode.childNode()==1){// 有一个子结点
                    if (this.leftNode.leftNode!=null){
                        this.leftNode = this.leftNode.leftNode;
                        return true;
                    }else {
                        this.leftNode = this.leftNode.rightNode;
                        return true;
                    }
                }else if (this.leftNode.childNode()==2){// 有两个子结点
                    this.leftNode.rightNode.addNode(this.leftNode.leftNode);
                    this.leftNode = this.leftNode.rightNode;
                    return true;
                }
            }else {
                return this.leftNode.deleteChild(value);
            }
        }else {//右结点
            if (this.rightNode==null){
                return false;
            }
            if (this.rightNode.value==value){
                // 没有子结点
                if (this.rightNode.childNode()==0){
                    this.rightNode=null;
                    return true;
                }else if (this.rightNode.childNode()==1){//有一个子结点
                    if (this.rightNode.leftNode!=null){
                        this.rightNode = this.rightNode.leftNode;
                        return true;
                    }else {
                        this.rightNode = this.rightNode.rightNode;
                        return true;
                    }
                }else { //有两个子结点
                    this.rightNode.rightNode.addNode(this.rightNode.leftNode);
                    this.rightNode = this.rightNode.rightNode;
                    return true;
                }
            }
        }
        return false;
    }

    public int childNode(){
        int count = 0;
        if (this.leftNode!=null)
            count++;
        if (this.rightNode!=null)
            count++;
        return count;
    }

    @Override
    public String toString() {
        return value+",";
    }
}
