package priv.jv.tree;

/**
 * @author javie
 * @date 2019/7/5 1:33
 */
public class BinaryTree {

    private MyTreeNode rootNode;

    public void setRoot(MyTreeNode node){
        this.rootNode = node;
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        rootNode.preOrderTraversal();
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        rootNode.inOrderTraversal();
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        rootNode.postOrderTraversal();
    }

    /**
     * 前序查找
     * @param value
     * @return
     */
    public MyTreeNode preOrderSearch(int value){
        return rootNode.preOrderSearch(value);
    }

    /**
     * 删除节点
     */
    public boolean delete(int dst){
        // 如果是根节点
        if (rootNode.getValue()==dst) {
            rootNode = null;
            return true;
        }
        // 如果不是，调用rootNode的删除方法
        return rootNode.delete(dst);
    }
}
