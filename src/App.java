import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        int pilaActual = 0;
        Pila e = new Pila(5);
        ArrayList<Pila> pilas = new ArrayList<Pila>();
        pilas.add(e);
        pilas.get(pilaActual);

        // enteros auxiliares
        int a = 0;

        while (true) {
            try {
                switch (menu(pilaActual, pilas.size())) {
                    case 1: // mostra
                        // JOptionPane.showMessageDialog(null, pilas[pilaActual].mostrar());

                        break;

                    case 2: // apilar
                        float d = Float.parseFloat(JOptionPane.showInputDialog(null, "Numero a apilar: "));
                        pilas.get(pilaActual).apilar(d);
                        break;

                    case 3: // desapilar
                        pilas.get(pilaActual).desapilar();
                        break;

                    case 4: // Pasar
                        a = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "Desde que pila desea pasar a esta? actualmente hay "
                                        + pilas.size() + (pilas.size() != 1 ? " pilas" : " pila")));
                        try {
                            if (a != pilaActual + 1 && pilas.size() >= a && a > -1) {
                                System.out.println("En espera del metodo.");
                                // pilas.get(a-1).pasar();
                            }
                        } catch (Exception er) {
                            System.out.println(er.getCause());
                        }

                        break;

                    case 5: // cambiar de pila
                        if (pilas.size() == 0)
                            JOptionPane.showMessageDialog(null, "No hay pilas");
                        a = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "A que pila desea cambiar? Actualemente hay "
                                        + pilas.size() + (pilas.size() != 1 ? " pilas" : " pila")));
                        if (a < 0 && a >= pilas.size())
                            pilaActual = a - 1;
                        else
                            JOptionPane.showMessageDialog(null, "Pila no existente");
                        break;

                    case 6:
                        String s = "Sin pilas";
                        if (pilas.size() != 0)
                            s = "";
                        for (int i = 0; i < pilas.size(); i++) {
                            s +=  "| "+ i + (pilas.get(i).pilaVacia() ? " Vacia "
                                    : pilas.get(i).pilaLlena() ? " pila llena " : "Tiene elementos ") + "| \n";
                        }
                        JOptionPane.showMessageDialog(null, "pilas : \n\n" + s);
                        break;

                    case 7:
                        e = new Pila(5);
                        pilas.add(e);
                        break;

                    case 8: // config pila
                        if (pilas.size() == 1) {
                            config(pilas, pilaActual);
                            break;

                        }
                        a = Integer.parseInt(JOptionPane.showInputDialog(null, "Que Pila desea editar? Actualmente hay "
                                + pilas.size() + (pilas.size() != 1 ? " pilas" : " pila")));
                        config(pilas, pilaActual);
                        break;

                    case 9:
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            } catch (Exception err) {
                if (err.getMessage() == "Cannot parse null string") {
                    System.exit(0);
                } else if (err.getMessage() == "For input string: \"\"") {
                    JOptionPane.showMessageDialog(null, "No option selected");
                } else {
                    System.out.println(err.getMessage());
                    JOptionPane.showMessageDialog(null, "Invalid Option");
                }
            }
        }
    }

    public static int menu(int pilaActual, int npilas) {

        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Pila Actual: " + (pilaActual + 1) +
                        "\nNumero de pilas" + npilas
                        +
                        """

                                1. Mostrar Pila.
                                2. Apilar.
                                3. Desapilar.
                                4. Pasar.
                                5. Cambiar pila actual.
                                6. Pilas.
                                7. Añadir pila.
                                8. configurar pilas.
                                9. Salir.
                                """));
    }

    public static void config(ArrayList<Pila> pilas, int actual) {
        switch (Integer.parseInt(JOptionPane.showInputDialog(null, """

                1. Cambiar limite.
                2. Eliminar Pila.
                3. Vaciar pila.
                """))) {

            case 1:
                pilas.get(actual).setLimite(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Limite.")));
                break;

            case 2:
                pilas.remove(actual);
                break;

            case 3:
                pilas.get(actual).vaciar();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida.");
                break;

        }

    }

}
