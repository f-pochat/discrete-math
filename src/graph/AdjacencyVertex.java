package graph;

public class AdjacencyVertex<T> {
    private T data;

    public AdjacencyVertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
