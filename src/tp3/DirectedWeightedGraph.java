package tp3;

import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedWeightedGraph<T> implements Graph<T> {
    private int n;
    private int alpha;
    private T[] V;
    private LinkedList<EdgeDirectedWeighted> A;

    public DirectedWeightedGraph() {
        V = (T[]) new Object[10];
        n = 0;
        alpha = 0;
        A = new LinkedList<>();
    }

    public DirectedWeightedGraph(int capacity) {
        V = (T[]) new Object[capacity];
        n = 0;
        alpha = 0;
        A = new LinkedList<>();
    }

    @Override
    public void addVertex(T x) {
        if (!hasVertex(x)) {
            if (n == V.length) {
                T[] aux = (T[]) new Object[n + 10];
                for (int i = 0; i < n; i++) {
                    aux[i] = V[i];
                }
                V = aux;
            }
            V[n] = x;
            n++;
        }
    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i < n; i++) {
            if (V[i].equals(v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        for (int i = 0; i < n; i++) {
            if (V[i] == x){
                for (int j = 0; j < alpha; j++) {
                    EdgeDirectedWeighted<T> edge = A.get(j);
                    T first = (T) edge.getFirst();
                    T second = (T) edge.getSecond();
                    if (first.equals(x) || second.equals(x)) {
                        removeEdge(first, second);
                    }
                }
                for (int j = i+1; j < n; j++) {
                    V[j-1] = V[j];
                }
                V[n-1] = null;
                n--;
            }
        }
    }

    @Override
    public void addEdge(T first, T second) {
        if (hasVertex(first) && hasVertex(second)) {
            A.add(new EdgeDirectedWeighted(first,second));
            alpha++;
        }
    }

    public void addEdge(T first, T second, int capacity) {
        if (hasVertex(first) && hasVertex(second)) {
            A.add(new EdgeDirectedWeighted(first,second, capacity));
            alpha++;
        }
    }

    @Override
    public void removeEdge(T first, T second) {
        for (int i = 0; i < alpha; i++) {
            if (A.get(i).getFirst().equals(first) && A.get(i).getSecond().equals(second)){
                A.remove(i);
                alpha--;
            }
        }
    }

    @Override
    public boolean hasEdge(T first, T second) {
        for (int i = 0; i < alpha; i++) {
            if (A.get(i).getFirst().equals(first) && A.get(i).getSecond().equals(second)) {
                return true;
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
        List<T> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(V[i]);
        }
        return lst; // por más que el arreglo esté vacío toma la lista como que no está vacía
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        List<T> adjList = new LinkedList<T>(); //lo cambié a linked list porque alicia dijo en clase
        for (int i = 0; i < n; i++) {
            if (V[i] == v){
                for (int j = 0; j < alpha; j++) {
                    T first = (T) A.get(j).getFirst();
                    T second = (T) A.get(j).getSecond();
                    if (first.equals(v)) {
                        adjList.add(second);
                    }
                    if (second.equals(v)) {
                        adjList.add(first);
                    }
                }
            }
        }
        return adjList;
    }
}
