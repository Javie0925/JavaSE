package priv.jv.binarysorttree;

/**
 * @author javie
 * @date 2019/7/8 15:50
 */
public class AVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 添加结点
     * @param node
     */
    public void add(Node node){
        if (root==null){ //如果根节点为空
            root=node;
        }else { //如果根节点不为空
            root.addNode(node);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        if (root!=null){
            this.root.inOrderTraversal();
        }
    }

    public Node search(int value){
        if (root==null)
            return null;
        return root.search(value);
    }
    public boolean delete(int value){
        if (root==null)
            return false;
        if (root.getValue()==value){
            if (root.getLeftNode()!=null&&root.getRightNode()==null) {
                root = root.getLeftNode();
                return true;
            }else if (root.getRightNode()!=null&&root.getLeftNode()==null){
                root=root.getRightNode();
                return true;
            }else if (root.getLeftNode()==null&&root.getRightNode()==null){
                root = null;
                return true;
            }else {
                root.getRightNode().addNode(root.getLeftNode());
                root = root.getRightNode();
                return true;
            }
        }else {
            return root.deleteChild(value);
        }
    }
}
