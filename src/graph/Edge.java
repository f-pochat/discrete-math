package graph;

public class Edge<T> {
    T[] edge = (T[]) new Object[2];

    public Edge(T first, T second) {
        edge[0] = first;
        edge[1] = second;
    }
}
