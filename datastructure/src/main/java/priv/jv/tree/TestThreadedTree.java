package priv.jv.tree;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/6 17:04
 */
public class TestThreadedTree {

    @Test
    public void fun(){
        ThreadedTreeNode node = new ThreadedTreeNode(5);
        ThreadedTreeNode node1 = new ThreadedTreeNode(3);
        ThreadedTreeNode node2 = new ThreadedTreeNode(6);
        ThreadedTreeNode node3 = new ThreadedTreeNode(57);
        ThreadedTreeNode node4 = new ThreadedTreeNode(51);
        ThreadedTreeNode node5 = new ThreadedTreeNode(9);
        ThreadedTreeNode node6 = new ThreadedTreeNode(0);
        node.setLeftNode(node1);
        node.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        node2.setLeftNode(node5);
        node2.setRightNode(node6);
        node.inOrderTraversal();
        ThreadedTree threadedTree = new ThreadedTree(node);
        System.out.println("#########################");
        threadedTree.inOrderIterator();

    }
}
