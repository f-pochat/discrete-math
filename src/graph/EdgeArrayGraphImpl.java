package graph;

import java.util.LinkedList;
import java.util.List;

// TODO: implement
public class EdgeArrayGraphImpl<T> implements Graph<T> {
    private int n;
    private int alpha;
    private T[] V;
    private LinkedList<Edge> lst;

    public EdgeArrayGraphImpl() {
        V = (T[]) new Object[10];
        n = 0;
        alpha = 0;
        lst = new LinkedList<>();
    }

    public EdgeArrayGraphImpl(int capacity) {
        V = (T[]) new Object[capacity];
        n = 0;
        alpha = 0;
        lst = new LinkedList<>();
    }

    @Override
    public void addVertex(T x) {
        if (n == V.length){
            T[] aux = (T[]) new Object[n+10];
            for (int i = 0; i < n; i++) {
                aux[i] = V[i];
            }
            V = aux;
        }

        V[n] = x;
        n++;

    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i < n; i++) {
            if (V[i] == v){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        for (int i = 0; i < n; i++) {
            if (V[i] == x){
                for (int j = i+1; j < n; j++) {
                    V[j-1] = V[j];
                }
                n--;
            }
        }
    }

    @Override
    public void addEdge(T v, T w) {
        lst.add(new Edge(v,w));
        alpha++;
    }

    @Override
    public void removeEdge(T v, T w) {
        lst.remove(new Edge(v,w));
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        return lst.contains(new Edge(v,w));
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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        throw new UnsupportedOperationException("TODO");
    }
}
