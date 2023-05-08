import javax.swing.JOptionPane;
public class App {

    public static void main(String[] args) throws Exception {
        int pilaActual = 0;
        Pila pilas[];
        pilas = new Pila[2];

        Pila pila1 = new Pila(2);
        pilas[pilaActual] = pila1;
        pilas[pilaActual].apilar(2);
        
        while (true) {
            switch (menu(pilaActual)) {
                case 1: 
                    //JOptionPane.showMessageDialog(null, pilas[pilaActual].mostrar());
                    
                    break;
                
                case 2:
                    float d = Float.parseFloat(JOptionPane.showInputDialog(null, "Numero a apilar: "));
                    pilas[pilaActual].apilar(d);
                    break;

                case 3:
                    pilas[pilaActual].desapilar();
                    break;
                
                case 8: // config pila

                case 9:
                    System.exit(0);
                    break;

                default: break;
            }


        }

    }

    public static int menu(int pilaActual) {

        return Integer.parseInt(JOptionPane.showInputDialog(null, "Pila Actual: "+pilaActual+"""

                1. Mostrar Pila.
                2. Apilar.
                3. Desapilar.
                4. Pasar. (desde / hacia)
                8. configurar pilas.
                9. Salir.
                """));
            }
}
