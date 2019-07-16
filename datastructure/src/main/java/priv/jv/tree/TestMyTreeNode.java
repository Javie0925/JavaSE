package priv.jv.tree;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/4 23:41
 */
public class TestMyTreeNode {

    @Test
    public void fun(){
        MyTreeNode treeNode = new MyTreeNode(0);
        MyTreeNode treeNode1 = new MyTreeNode(3);
        MyTreeNode treeNode2 = new MyTreeNode(2);
        MyTreeNode treeNode3 = new MyTreeNode(5);
        MyTreeNode treeNode4 = new MyTreeNode(9);
        MyTreeNode treeNode5 = new MyTreeNode(99);

        treeNode.setLeftNode(treeNode1);
        treeNode.setRightNode(treeNode2);
        treeNode1.setLeftNode(treeNode3);
        treeNode1.setRightNode(treeNode4);
        treeNode4.setRightNode(treeNode5);
        // 遍历
        treeNode.preOrderTraversal();
        System.out.println();
        treeNode.inOrderTraversal();
        System.out.println();
        treeNode.postOrderTraversal();
        //查找
        System.out.println();
        MyTreeNode result = treeNode.preOrderSearch(3);
        System.out.println(result);
        result.inOrderTraversal();
        System.out.println(result==treeNode1);
        // 删除结点
        System.out.println("#########################");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(treeNode);
        boolean delete = binaryTree.delete(3);
        System.out.println(delete);
        binaryTree.inOrderTraversal();
    }
}
