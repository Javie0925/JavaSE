package webank;

import java.util.*;

/**
 * @author javie
 * @date 2019/9/19 16:39
 * 一般来讲，一个国家级景区，都包含着很多的景点，在这些景点之间，有着很多条路，
 * 任意两个景点之间，可能有很多条不重复经过某一景点的道路可以到达。
 * 有一位强迫症患者去游览某景区，这个景区中有n个景点，编号为1-n，入口在s景点，出口在t景点，
 * 景区中有m条路径连接某两个景点，他通过某些道路从s走向t，但是因为强迫症的缘故，
 * 他不希望重复经过某个景点，这就注定了有些景点他是不可能到达的，请问这样的景点有多少个？
 * 第一行有两个整数,n,m分别表示景点数量，路的数量(1<=n<=100,1<=m<=n(n-1)/2)。
 *
    接下来有m行，每行有两个正整数u和v，表示u景点和v景点之间存在一条路径。
    最后一行是两个正整数 s，t，表示入口所在景点的编号和出口所在景点的编号。(1<=s,t<=n)
    5 4
    1 2
    2 3
    4 2
    5 2
    1 3
    4 5
 */
public class Main {


    static int in = 0;
    static int out = 0;
    static boolean[] visited = null;
    static List<List<Integer>> list = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String row1 = sc.nextLine();
            String[] split1 = row1.split(" ");
            int spot = Integer.parseInt(split1[0]);
            int route = Integer.parseInt(split1[1]);
            visited = new boolean[spot+1];
            list = new ArrayList<>();
            for (int i=0;i<=spot;i++){
                list.add(new ArrayList<Integer>());
            }
            for (int i=0;i<route;i++){
                String row2 = sc.nextLine();
                String[] split2 = row2.split(" ");
                int i1 = Integer.parseInt(split2[0]);
                int i2 = Integer.parseInt(split2[1]);

                list.get(i1).add(i2);

            }
            String row3 = sc.nextLine();
            String[] split3 = row3.split(" ");
            in = Integer.parseInt(split3[0]);
            out = Integer.parseInt(split3[1]);
            visited[in] = true;
            visited[out] = true;
            fun(new ArrayList<Integer>(),in);
            for (int z=1;z<visited.length;z++){
                if (!visited[z]){
                    System.out.print(z+" ");
                }
            }
            System.out.println();

        }
    }

    // 回溯算法
    public static void fun(List<Integer> trace,int current){
        //System.out.println("current: "+current);
        if (current==out){
            for (int i=0;i<trace.size();i++){
                visited[trace.get(i)] = true;
                //System.out.println(Arrays.toString(visited));
            }
            return;
        }
        List<Integer> currentList = list.get(current);
        if (currentList==null || currentList.size()==0){
            return;
        }
        for (int i=0;i<currentList.size();i++){
            if (!trace.contains(currentList.get(i))){
                trace.add(currentList.get(i));
                fun(trace, currentList.get(i));
            }
            trace.remove(trace.size()-1);
        }
    }

}
