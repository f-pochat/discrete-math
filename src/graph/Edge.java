package graph;

public class Edge<T> {
    private T[] edge = (T[]) new Object[2];

    public Edge(T first, T second) {
        edge[0] = first;
        edge[1] = second;
    }

    public T getFirst(){
        return edge[0];
    }

    public T getSecond(){
        return edge[1];
    }
}
