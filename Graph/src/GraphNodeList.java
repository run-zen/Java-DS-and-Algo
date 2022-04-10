import java.util.ArrayList;

public class GraphNodeList {
    public String name;
    public int index;

    ArrayList<GraphNodeList> neighbours  = new ArrayList<>();

    public GraphNodeList(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
