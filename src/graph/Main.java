package graph;

public class Main {

    public static void main(String[] args) {

        EdgeArrayGraphImpl<Integer> graph = new EdgeArrayGraphImpl();

        System.out.println(graph.getVertexes().isEmpty());
        graph.addVertex(2);
        System.out.println(graph.getVertexes().isEmpty());
        graph.removeVertex(2);
        System.out.println(graph.getVertexes().isEmpty());
    }
}
