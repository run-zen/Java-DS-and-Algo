import java.util.*;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        int size = nodeList.size();
        adjacencyMatrix = new int[size][size];
    }

    public void addUndirectedEdge(int row, int col) {
        adjacencyMatrix[row][col] = 1;
        adjacencyMatrix[col][row] = 1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("   ");
        int size  = nodeList.size();
        for (int i = 0; i < size; i++) {
            s.append(nodeList.get(i).name).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < size; i++) {
            s.append(nodeList.get(i).name).append(": ");
            for (int j :adjacencyMatrix[i]) {
                s.append(j).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}