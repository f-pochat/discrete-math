package tp2;

import graph.Graph;
import graph.Vertex;

import java.util.*;

public class Tp2Impl<T> implements Tp2<T> {
    @Override
    public List<T> depth_first_search(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> breadth_first_search(Graph<T> graph) {
        return breadth_first_search(graph,graph.getVertexes().get(0));
    }

    private List<T> breadth_first_search(Graph<T> graph, T first) {
        if (graph.alpha() == 0){
            return null;
        }
        List<T> visited = new ArrayList<>();
        LinkedList<T> queue = new LinkedList<>();
        List<T> result = new ArrayList<>();
        visited.add(first);
        queue.add(first);
        while(queue.size() != 0) {
            first = queue.poll();
            result.add(first);

            for (T n : graph.getAdjacencyList(first)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        return result;
    }

    @Override
    public boolean exercise_a(Graph<T> graph, T v, T w) {
        List<T> bfs = breadth_first_search(graph,v);
        if (bfs == null){
            return false;
        }
        return bfs.contains(w);
    }

    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_g(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_h(Graph<T> graph) {
        int counter = 0;
        List<T> visited = new ArrayList<>();
        for (int i = 0; i < graph.order(); i++) {
            if (!visited.contains(graph.getVertexes().get(i))) {
                visited.add(graph.getVertexes().get(i));
                List<T> bfs = breadth_first_search(graph,graph.getVertexes().get(i));

                if (bfs == null) {
                    counter++;
                    continue;
                }

                Iterator<T> aux = bfs.iterator();
                while (aux.hasNext()){
                    T vertex = aux.next();
                    if (!visited.contains(vertex)) visited.add(vertex);
                }
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean exercise_i(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_k(Graph<T> g1) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_l(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_m(Graph<T> graph, T v) {
        return graph.getAdjacencyList(v).size();
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}
