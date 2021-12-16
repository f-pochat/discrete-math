package tp3;

public class EdgeDirectedWeighted<T> {

    private T[] edge = (T[]) new Object[2];
    private int capacity;
    private int flow;

    public EdgeDirectedWeighted(T first, T second) {
        edge[0] = first;
        edge[1] = second;
        capacity = 0;
        flow = 0;
    }

    public EdgeDirectedWeighted(T origin, T destination, int capacity) {
        edge[0] = origin;
        edge[1] = destination;
        this.capacity = capacity;
        flow = 0;
    }

    public T getFirst(){
        return edge[0];
    }

    public T getSecond(){
        return edge[1];
    }

    public void setFlow(int newFlow){
        flow = newFlow;
    }

    public int getFlow() {
        return flow;
    }

    public int getCapacity() {
        return capacity;
    }
}
