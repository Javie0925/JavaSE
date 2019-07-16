package priv.jv.avltree;

/**
 * @author javie
 * @date 2019/7/8 15:51
 */
public class AVLTreeNode {

    private int value;

    private AVLTreeNode leftNode;

    private AVLTreeNode rightNode;

    public AVLTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftNode(AVLTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(AVLTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public AVLTreeNode getLeftNode() {
        return leftNode;
    }

    public AVLTreeNode getRightNode() {
        return rightNode;
    }

    /**
     * 添加结点
     * @param node
     */
    public void addNode(AVLTreeNode node){
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
        // 检查子树的高度
        int leftHeight = leftNode==null?1:(1+leftNode.height());
        int rightHeight = rightNode==null?1:(1+rightNode.height());
        if (leftHeight-rightHeight>1){ //左边比右边高，进行右旋转
            // 检查左子树是否平衡
            if (leftNode!=null&&leftNode.rightHeight()-leftNode.leftHeight()>0){
                // 左子树左斜，需要进行双旋转
                leftNode.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }else if (rightHeight-leftHeight>1){ //右边比左边高，进行左旋转
            if (rightNode!=null&&rightNode.leftHeight()-rightNode.rightHeight()>0){
                // 右子树右斜，需要进行双旋转
                rightNode.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
        }
    }
    public int leftHeight(){
        if (leftNode==null)
            return 1;
        return 1+leftNode.height();
    }

    public int rightHeight(){
        if (rightNode==null){
            return 1;
        }
        return 1+rightNode.height();
    }

    /**
     * 左旋方法
     */
    public void leftRotate() {
        AVLTreeNode newNode = new AVLTreeNode(this.value);
        newNode.leftNode = this.leftNode;
        newNode.rightNode = this.rightNode.leftNode;
        this.value = rightNode.value;
        this.rightNode = rightNode.rightNode;
        this.leftNode = newNode;

    }

    /**
     * 右旋方法
     */
    private void rightRotate() {
        //1.新建一个结点，值为根结点的值
        AVLTreeNode newNode = new AVLTreeNode(this.value);
        //2.新结点的右结点是根节点的右结点
        newNode.rightNode = this.rightNode;
        //3.新结点的左结点是根节点的左结点的右子结点
        newNode.leftNode = this.leftNode.rightNode;
        //4.根节点的值替换为其左结点的值
        this.value = leftNode.value;
        //5.根结点指向其左结点的左结点
        this.leftNode = leftNode.leftNode;
        //6.根节点的右结点指向新结点
        this.rightNode = newNode;
    }

    public int height(){
        return 1+Math.max(leftNode==null?0:leftNode.height(), rightNode==null?0:rightNode.height());
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
    public AVLTreeNode search(int value){
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
