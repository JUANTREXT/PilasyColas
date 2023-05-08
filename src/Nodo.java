public class Nodo {
    private Nodo next;
    private float data;

    public Nodo() {
        this.next = null;
        this.data = 0;
    }

    public Nodo(float d) {
        this.next = null;
        this.data = d;
    }

    // getter setters

    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    public float getData() {
        return data;
    }
    public void setData(float data) {
        this.data = data;
    }
}
