package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private T data;
    private List<AdjacencyVertex> lst;

    public Vertex(T data) {
        this.data = data;
        lst = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void addEdge(T w){
        lst.add(new AdjacencyVertex(w));
    }

    public void removeEdge(T w) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getData() == w){
                lst.remove(i);
            }
        }
    }

    public boolean hasEdge(T w){
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getData() == w){
                return true;
            }
        }
        return false;
    }

    public List<AdjacencyVertex> getLst() {
        return lst;
    }

    public T getVertexData(int i){
        return (T) lst.get(i).getData();
    }
}
