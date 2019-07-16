package priv.jv.graph;

import priv.jv.stack.MyStack;

/**
 * 图结构类
 * @author javie
 * @date 2019/7/10 16:09
 */
public class Graph {

    // 顶点数组
    private Vertex[] vertexs;
    // 顶点个数
    private int size;
    // 邻接矩阵
    private int[][] adjMat;

    public Graph(int size){
        vertexs = new Vertex[size];
        adjMat = new int[size][size];
        for (int i=0;i<size;i++){
            adjMat[i][i] = 1;
        }
    }

    public int[][] getAdjMat() {
        return adjMat;
    }

    /**
     * 向图中添加一个顶点
     * @param v
     */
    public void addVertex(Vertex v){
        vertexs[size++] = v;
    }

    /**
     * 设置两个顶点相通
     * @param v1
     * @param v2
     */
    public void addEdge(String v1,String v2){
        int index1=0;
        for (int i=0;i<size;i++){
            if (vertexs[i].getValue()==v1){
                index1 = i;
            }
        }
        int index2=0;
        for (int i=0;i<size;i++){
            if (vertexs[i].getValue()==v2){
                index2 = i;
            }
        }
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;

    }

    /**
     * 深度优先算法遍历图
     */
    public void dfs(){
        MyStack stack = new MyStack();
        stack.push(0);
        vertexs[0].visited = true;
        System.out.println(vertexs[0]);
        while (!stack.isEmpty()){
            boolean found = false;
            for (int i=stack.peek()+1;i<size;i++){
                if (vertexs[i]!=null && !vertexs[i].visited && adjMat[stack.peek()][i]==1){
                    stack.push(i);
                    System.out.println(vertexs[i]);
                    vertexs[i].visited = true;
                    found = true;
                    break;
                }
            }
            // 没有找到，栈弹出一个数据，继续遍历
            if (!found) {
                int pop = stack.pop();
                System.out.println(pop);
            }
        }
    }


}
