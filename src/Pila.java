public class Pila {
    private Nodo Punta;
    private int limite, tope;

    // Metodos Principales
    public void apilar(float d) {
        Nodo x = new Nodo(d);
        x.setNext(Punta);
        Punta=x;
        tope++;
    }

    public float desapilar() {
        Nodo d = Punta;
        d.setNext(null);
        Punta = Punta.getNext();
        tope--;
        return d.getData();
    }

    // Utilidad
    public boolean pilaLlena() {
        return tope == limite-1 ? true : false;
    }
    public boolean pilaVacia() {
        return tope == -1 ? true : false;
    }

    // Constructor
    public Pila (int l) {
        Punta = null;
        limite = l;
        tope = -1;
    }

    // Getters and Setters
    public Nodo getPunta() {
        return Punta;
    }
    public void setPunta(Nodo punta) {
        Punta = punta;
    }
    public int getLimite() {
        return limite;
    }
    public void setLimite(int limite) {
        this.limite = limite;
    }
    public int getTope() {
        return tope;
    }
    public void setTope(int tope) {
        this.tope = tope;
    }    
}
