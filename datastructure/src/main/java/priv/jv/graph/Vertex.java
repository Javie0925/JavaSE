package priv.jv.graph;

/**
 * 图结构顶点类
 * @author javie
 * @date 2019/7/10 16:07
 */
public class Vertex {

    private String value;
    // 标识是否被遍历过
    public boolean visited;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public Vertex(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return this.value+",";
    }
}
