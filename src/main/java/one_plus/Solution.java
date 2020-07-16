package one_plus;

import java.util.*;

/**
 * @author javie
 * @date 2019/9/19 10:12
 */

// 3241423

class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
}


class Solution {

    private List<TreeNode> list = new ArrayList<>();

    public boolean isSymmetric(TreeNode root){

        inOrder(root);
        int tail = list.size() - 1;
        for (int i=0;i<list.size();i++){
            if (list.get(i)!=null && list.get(tail-i)!=null){
                if (list.get(i).val!=list.get(tail-i).val){
                    return false;
                }
            }else if (list.get(i)==null && list.get(tail-i)!=null){
                return false;
            }else if (list.get(i)!=null && list.get(tail-i)==null){
                return false;
            }
        }

        return true;
    }

    public void inOrder(TreeNode node){

        // 前
        if (node.left!=null){
            inOrder(node.left);
        }else if (node.left==null && node.right!=null){
            list.add(null);
        }
        // 中
        list.add(node);
        // 后
        if (node.right!=null){
            inOrder(node.right);
        }else if (node.right==null && node.left!=null){
            list.add(null);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        Solution s = new Solution();
        System.out.println(s.isSymmetric(root));
    }
}
