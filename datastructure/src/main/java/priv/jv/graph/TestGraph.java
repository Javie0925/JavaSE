package priv.jv.graph;

import org.junit.Test;

import java.util.*;

/**
 * @author javie
 * @date 2019/7/10 16:24
 */
public class TestGraph {

    @Test
    public void fun(){
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Graph graph = new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        // 增加边
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "A");
        graph.addEdge("B", "D");
        graph.addEdge("D", "E");

        for (int[] ints:graph.getAdjMat()){
            System.out.println(Arrays.toString(ints));
        }

        graph.dfs();
    }


    @Test
    public void fun2(){
        "(".lastIndexOf("");
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<Object, Object> map = new HashMap<>();
        //arrayList.remove()
        //System.out.println(Integer.parseInt("00000"));
        System.out.println(Math.sqrt(10)+"");
        String[] split = (Math.sqrt(10) + "").split("\\.");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(Integer.parseInt("000000000000000000001"));
        //System.out.println(Integer.parseInt((Math.sqrt(10)+"").split(".")[0]));
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            Set<Map.Entry<Object, Object>> entrySet = hashMap.entrySet();
        }
        Object obj = new Object();
        //"".hashCode()
    }
}
