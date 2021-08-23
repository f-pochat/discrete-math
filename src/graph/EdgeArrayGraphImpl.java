package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EdgeArrayGraphImpl<T> implements Graph<T> {
    private int n;
    private int alpha;
    private T[] V;
    private LinkedList<Edge> A;

    public EdgeArrayGraphImpl() {
        V = (T[]) new Object[10];
        n = 0;
        alpha = 0;
        A = new LinkedList<>();
    }

    public EdgeArrayGraphImpl(int capacity) {
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
                    T first = (T) A.get(j).getFirst();
                    T second = (T) A.get(j).getSecond();
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
    public void addEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            A.add(new Edge(v,w));
            alpha++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        for (int i = 0; i < alpha; i++) {
            if (A.get(i).getFirst().equals(v) && A.get(i).getSecond().equals(w)){
                A.remove(i);
                alpha--;
            }
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        for (int i = 0; i < alpha; i++) {
            if ((A.get(i).getFirst().equals(v) && A.get(i).getSecond().equals(w)) || (A.get(i).getFirst().equals(w) && A.get(i).getSecond().equals(v))) {
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
                    } else if (second.equals(v)) {
                        adjList.add(first);
                    }
                }
            }
        }
        return adjList;
    }
}
