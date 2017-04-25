import java.io.*;
import java.rmi.*;

 /**
 * Esta clase representa el cliente de un objeto
 * distribuido de clase HolaMundo, que implementa la
 * interfaz remota HolaMundoInterfaz.
 */

 public class HolaMundoCliente {

 public static void main(String args[]) {
            
     try {
            int numPuertoRMI;
            String nombreNodo;
            InputStreamReader ent = new InputStreamReader(System.in);
            BufferedReader buf = new BufferedReader(ent);
            System.out.println("Introducir el del registro RMI:");
            nombreNodo = buf.readLine();
            System.out.println("Introducir el número de puerto del registro RMI:");
            String numPuerto = buf.readLine();
            numPuertoRMI = Integer.parseInt(numPuerto);
            String URLRegistro = "rmi://" + nombreNodo + ":" + numPuerto + "/holaMundo";
            //Búsqueda del objeto remoto y cast del objeto de la interfaz
            HolaMundoInt h = (HolaMundoInt)Naming.lookup(URLRegistro);
            System.out.println("Busqueda completa ");
            // Invocar el método remoto
            String mensaje = h.decirHola("Pato Donald");
            System.out.println("HolaMundoCliente: " + mensaje);
        } // fin try
        catch (Exception e) {
        System.out.println("Excepcion en HolaMundoCliente:" + e);
        } // fin catch
    } // fin main
 } // fin clase

          
