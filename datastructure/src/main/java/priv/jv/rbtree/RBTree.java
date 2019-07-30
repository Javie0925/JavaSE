package priv.jv.rbtree;

/**
 * @author javie
 * @date 2019/7/24 16:41
 */
public class RBTree {

    Node root = null;

    public Node findParent(Double d){
        Node current = root;
        Node parent = null;
        while(current!=null){
            if (current.value>=d){
                parent = current;
                current = current.left;
            }else{
                parent = current;
                current = current.right;
            }
        }
        return parent;
    }

    public void add(Double d){
        Node n = new Node(d);
        if (root==null){ // 如果根节点为空，则设为根节点
            root = n;
            this.root.color = false;
        }else{ // 根节点不为空，添加到叶子结点下
            // 查找叶子节点
            Node parent = findParent(d);
            Node newNode = new Node(d);
            newNode.parent = parent;    // 指定父节点
            if (parent.value>newNode.value){
                parent.left = newNode;
            }else {
                parent.right = newNode;
            }
            // 调整
            addModify(newNode);
        }
    }

    // 添加结点时调整树结构
    private void addModify(Node node) {
        if (node == root){
            root.color = false;
        }
        Node parent = node.parent;
        Node grand = parent.parent;
        Node uncle = grand.left==parent?grand.right:grand.left;
        // 1.未破坏结构，无需修改
        if(!parent.color){
            return;
        }
        // 2.parent为红色，uncle无
        if(parent.color && uncle==null){
            double temp = grand.value;
            grand.value = parent.value;
            if (node.value<grand.value){
                grand.left=node;
                node.parent=grand;
                grand.right=parent;
                parent.parent=grand;
                parent.right=null;
                parent.left=null;
                parent.value=temp;
            }else if (node.value>=grand.value){
                grand.right=node;
                node.parent=grand;
                grand.left=parent;
                parent.parent=grand;
                parent.right=null;
                parent.left=null;
                parent.value=temp;
            }
        }
        // 3.parent为红色，uncle为红色
        if (grand.left==parent && parent.color && grand.right.color){
            // 右旋
            double temp = grand.value;
            grand.value=parent.value;
            Node tempNode = new Node(temp);
            tempNode.right = grand.right;
            tempNode.parent=grand;
            grand.left = parent.left;
            grand.right=tempNode;
            tempNode.left=parent.right;
            parent.right.parent=tempNode;
        }
    }

    public void rightRotate(){

    }
    public void leftRotate(){

    }



}
