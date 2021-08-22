package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: implement
public class AdjacencyListGraphImpl<T> implements Graph<T> {
    private Vertex[] V;
    private int n;
    private int alpha;

    public AdjacencyListGraphImpl() {
        V = new Vertex[10];
        n = 0;
        alpha = 0;
    }

    public AdjacencyListGraphImpl(int capacity) {
        V = new Vertex[capacity];
        n = 0;
        alpha = 0;
    }

    @Override
    public void addVertex(T x) {
        if (n == V.length){
            Vertex[] aux = new Vertex[n+10];
            for (int i = 0; i < n; i++) {
                aux[i] = V[i];
            }
            V = aux;
        }

        V[n] = new Vertex(x);
        n++;
    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == v)
                return true;
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == x){
                for (int j = i+1; j < n; j++) {
                    V[j-1] = V[j];
                }
                n--;
            }
        }
    }

    @Override
    public void addEdge(T v, T w) {
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == v)
                V[i].addEdge(w);

            if (V[i].getData() == w)
                V[i].addEdge(v);
        }
        alpha++;
    }

    @Override
    public void removeEdge(T v, T w) {
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == v)
                V[i].removeEdge(w);

            if (V[i].getData() == w)
                V[i].removeEdge(v);
        }
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == v){
                if (V[i].hasEdge(w)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int alpha() {
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        return (List<T>) Arrays.asList(V);
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        List<T> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (V[i].getData() == v){
                for (int j = 0; j < V[i].getLst().size(); j++) {
                    adjList.add((T) V[i].getVertexData(j));
                }
            }
        }
        return adjList;
    }
}
