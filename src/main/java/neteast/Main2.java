package neteast;// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class Main2 {

    static List<Node> nodesList = null;
    static List<Integer> sumList = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int group = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < group; i++){
            sumList = new ArrayList<>();
            nodesList = new ArrayList<>();
            int count = Integer.parseInt(sc.nextLine());
            //System.out.println(count);
            Set<Integer> set = new HashSet<>();
            // 创建结点，存入集合
            for (int j=0;j<count;j++){
                String s = sc.nextLine();
                String[] split = s.split(" ");
                Node node = new Node(j);
                node.val = Integer.parseInt(split[0]);
                node.lid = Integer.parseInt(split[1]);
                node.rid = Integer.parseInt(split[2]);
                nodesList.add(node);
                set.add(node.lid);
                set.add(node.rid);
            }
            // 找出根结点
            Node root = null;
            for (int l=0;l<count;l++){
                if (!set.contains(l)){
                    root = nodesList.get(l);
                }
            }
            // 判断
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(root);
            isIncrease(linkedList);
            boolean flag = true;
            for (int z=1;z<sumList.size();z++){
                if (sumList.get(z)<sumList.get(z-1)){
                    flag = false;
                }
            }
            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static void isIncrease(LinkedList<Node> list){
        if (list.isEmpty()){
            return;
        }
        int sum = 0;
        LinkedList<Node> nodes = new LinkedList<>();
        while (!list.isEmpty()){
            Node node = list.removeFirst();
            sum += node.val;
            if (node.lid!=-1){
                nodes.addLast(nodesList.get(node.lid));
            }
            if (node.rid!=-1){
                nodes.addLast(nodesList.get(node.rid));
            }
        }
        sumList.add(sum);
        isIncrease(nodes);
    }

    public static class Node{
        int id;
        int val;
        int lid;
        int rid;
        public Node(int id){
            this.id = id;
        }
    }
}