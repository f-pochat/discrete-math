package tp1;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// TODO: implement
public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        for (int i = 0; i < graph.order(); i++) {
            System.out.println("Vertex: " + graph.getVertexes().get(i));
            String str = "Edges: ";
            for (int j = 0; j < graph.getAdjacencyList(graph.getVertexes().get(i)).size(); j++) {
                str += " -> " + graph.getAdjacencyList(graph.getVertexes().get(i)).get(j);
            }
        }
    }

    @Override
    public int exercise_b(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_c(Graph<T> graph) {
        List<T> lst = new ArrayList<>();
        for (int i = 0; i < graph.order(); i++) {
            if (graph.getAdjacencyList(graph.getVertexes().get(i)).contains(graph.getVertexes().get(i))){
               lst.add(graph.getVertexes().get(i));
            }
        }
        return lst;
    }

    @Override
    public boolean exercise_d(Graph<T> graph, T vertex) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_e(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph) {
        List<T> lst = new ArrayList<>();
        for (int i = 0; i < graph.order(); i++) {
            if (graph.getAdjacencyList(graph.getVertexes().get(i)).isEmpty()){
                lst.add(graph.getVertexes().get(i));
            }
        }
        return lst;
    }

    @Override
    public Graph<T> exercise_g(Graph<T> graph) {
        List<T> lst_loops = exercise_c(graph);
        List<T> lst_isolated = exercise_f(graph);
        for (int i = 0; i < lst_loops.size(); i++) {
            graph.removeEdge(lst_loops.get(i), lst_loops.get(i));
        }
        for (int i = 0; i < lst_isolated.size(); i++) {
            graph.removeVertex(lst_isolated.get(i));
        }
        return graph;
    }

    @Override
    public int[][] exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_i(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }
}
