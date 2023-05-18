import java.util.Arrays;

public class Pila {
    private Nodo Punta;
    private int limite, tope;

    // Metodos Principales

    public Float[] mostrar() {
        // Se usa un array de objetos Float para usar null como diferenciador entre 0 y 0 real
        Float[] a = new Float[limite];
        Arrays.fill(a, null);

        Pila pilaAux = new Pila(limite);
        float aux = 0;
        while (!pilaVacia()){
            pilaAux.apilar(this.desapilar());
        }
        pilaAux.invertir();
        int i = 0;
        while(!pilaAux.pilaVacia()) {
            aux = pilaAux.desapilar();
            this.apilar(aux);
            a[i] = aux;
            i++;
        }

        return a; 
    }

    public void vaciar() {
        while(!pilaVacia()) {
            desapilar();
        }
    }

    public void apilar(float d) {
        Nodo x = new Nodo(d);
        x.setNext(Punta);
        Punta=x;
        tope++;
    }

    public float desapilar() {
        Nodo d = Punta;
        Punta = Punta.getNext();
        d.setNext(null);
        tope--;
        return d.getData();
    }

    public void invertir () {
        Pila aux1 = new Pila(limite);
        Pila aux2 = new Pila(limite);

        while(!pilaVacia()) {
            aux1.apilar(this.desapilar());
        }
        while(!aux1.pilaVacia()) {
            aux2.apilar(aux1.desapilar());
        }

        while(!aux2.pilaVacia()) {
            this.apilar(aux2.desapilar());
        }
    }

    public void pasar(Pila P){
        while(!P.pilaLlena()) {
            this.apilar(P.desapilar());
        }

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
    public void setLimite(int limite) { // hacer modificacion para cuando se disminuye el limite.
        this.limite = limite;
    }
    public int getTope() {
        return tope;
    }
    public void setTope(int tope) {
        this.tope = tope;
    }    
}
