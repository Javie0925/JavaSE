package priv.jv;

/**
 * @author javie
 * @date 2019/7/2 16:16
 */
public class SingleLinkedTableMain {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.append(node2).append(node3).append(node4);
        node.show();
        node.removeNext();
        node.removeNext();
        System.out.println("############");
        node.show();
    }
}
class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node childNode) {
        this.data = data;
        this.next = childNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node append(Node node){
        if (node.hasNext()){
            node.getNext().append(node);
        }
        this.next = node;
        return node;
    }

    public boolean hasNext(){
        return !(this.next ==null);
    }

    public void removeNext(){
        if (this.getNext()!=null){
            this.next = this.getNext().getNext();
        }
    }

    public void show(){
        Node currentNode = this;
        while (currentNode.hasNext()){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getData());
    }
}