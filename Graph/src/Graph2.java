import java.util.ArrayList;

public class Graph2 {

    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public Graph2(ArrayList<GraphNodeList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int node1, int node2) {
        GraphNodeList first = nodeList.get(node1);
        GraphNodeList second = nodeList.get(node2);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("   ");
        int size  = nodeList.size();
        for (GraphNodeList graphNodeList : nodeList) {
            s.append(graphNodeList.name).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < size; i++) {
            s.append(nodeList.get(i).name).append(": ");
            for (GraphNodeList j :nodeList.get(i).neighbours) {
                s.append(j.name).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
