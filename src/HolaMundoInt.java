 import java.rmi.*;

 /**
 * Interfaz remota.
 * 
 */
 public interface HolaMundoInt extends Remote {
 /**
 * Este método remoto devuelve un mensaje.
 * @para name – una cadena de caracteres con un nombre.
 * @return - una cadena de caracteres.
 */
 public String decirHola(String nombre)
 throws java.rmi.RemoteException;

 }