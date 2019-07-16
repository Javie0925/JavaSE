package priv.jv.tree;

/**
 * @author javie
 * @date 2019/7/5 23:45
 */
public class ThreadedTree {

    private ThreadedTreeNode rootNode;

    //前驱结点
    private ThreadedTreeNode pre;

    public ThreadedTree(ThreadedTreeNode rootNode) {
        this.rootNode = rootNode;
        // 线索化
        threadedNodes(rootNode);
    }

    public ThreadedTreeNode getRootNode() {
        return rootNode;
    }

    /**
     * 中序线索化二叉树
     */
    public void threadedNodes(ThreadedTreeNode node){
        // 如果为空，返回
        if (node==null)
            return;
        // 处理左子树
        threadedNodes(node.getLeftNode());
        // 处理当前结点
        if (node.getLeftNode()==null){
            // 处理前驱结点的左指针
            node.setLeftNode(pre);
            node.setLeftType(1);
        }
        // 处理前驱结点的右指针
        if (pre!=null&&pre.getRightNode()==null){
            pre.setRightNode(node);
            pre.setRightType(1);
        }
        // 每处理完一个结点，当前结点是下一个结点的前驱结点
        pre = node;
        // 处理右子树
        threadedNodes(node.getRightNode());
    }

    public void threadedNodes(){
        this.threadedNodes(rootNode);
    }
    /**
     * 线索化遍历
     */
    public void inOrderIterator(){
        ThreadedTreeNode node = rootNode;
        if (node!=null){
            // 找到最前的一个结点
            while (node!=null&&node.getLeftType()!=1){
                node = node.getLeftNode();
            }
            do {
                System.out.println(node.getData());
                if (node.getRightType()==1){ //node是线索结点
                    node = node.getRightNode();
                }else { //node不是线索结点
                    node = node.getRightNode();
                    while (node!=null&&node.getLeftType()!=1){
                        // 找到此子树下的最左边
                        node = node.getLeftNode();
                    }
                }
            }while (node!=null);

        }
    }
}

