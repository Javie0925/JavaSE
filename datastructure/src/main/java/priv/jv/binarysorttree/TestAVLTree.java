package priv.jv.binarysorttree;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/8 16:04
 */
public class TestAVLTree {

    @Test
    public void fun(){
//        int[] arr = {6,2,4,1,8,0,3,5,7,9};
        int[] arr = {1,1,1,1,1};
        AVLTree tree = new AVLTree();
        for (int i:arr){
            tree.add(new Node(i));
        }
        /*tree.inOrderTraversal();
        System.out.println();
        //AVLTreeNode search = tree.search(20);
        //System.out.println(search);
        tree.delete(6);
        tree.delete(8);
        tree.delete(1);
        tree.inOrderTraversal();
        System.out.println();
        System.out.println(tree.getRoot());*/
        Node root = tree.getRoot();
    }
}
