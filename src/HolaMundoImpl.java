import java.rmi.*;
import java.rmi.server.*;

 /**
 * Esta clase implementa la interfaz remota
 * HolaMundoInt.
 */

 public class HolaMundoImpl extends UnicastRemoteObject implements HolaMundoInt {

    public HolaMundoImpl () throws RemoteException {
          
                super();
    
    }

    public String decirHola(String nombre) throws RemoteException {
    
            return "Hola mundo" + nombre;
        }
 }