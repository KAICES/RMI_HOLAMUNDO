	import java.rmi.*; 
	import java.rmi.server.*; 
	import java.rmi.registry.Registry; 
	import java.rmi.registry.LocateRegistry; 
	import java.net.*; 
	import java.io.*; 
  
	/** 
	* Esta clase representa el servidor de un objeto 10  * de la clase HolaMundo, que implementa la 11  * interfaz remota HolaMundoInterfaz. 
		*/ 
   
	public class HolaMundoServidor { 
         
            public static void main (String args[]) { 
            InputStreamReader ent = new InputStreamReader(System.in); 
            BufferedReader buf = new BufferedReader(ent); 
            String numPuerto, URLRegistro; 
                    try { 
                            System.out.println("Introducir el número de puerto del registro RMI:"); 
                            numPuerto = buf.readLine().trim(); 
                            int numPuertoRMI = Integer.parseInt(numPuerto); 
                            arrancarRegistro(numPuertoRMI);   	 
                            HolaMundoImpl objExportado = new HolaMundoImpl(); 
                            URLRegistro = "rmi://localhost:" + numPuerto + "/holaMundo"; 
                            Naming.rebind(URLRegistro, objExportado); 
                            /*   */ 	System.out.println 
                            /* 	*/  	("Servidor registrado. El registro contiene actualmente:"); 
                            /* 	*/  	// lista de los nombres que se encuentran en el registro actualmente 
                            /* 	*/  	listaRegistro(URLRegistro); 
                            System.out.println("Servidor HolaMundo preparado."); 
                    } // fin try 
                    catch (Exception excr) { 
                    System.out.println("Excepción en HolaMundoServidor.main: " + excr); 
                    } // fin catch 
	} // fin main 
   
	// Este método arranca un registro RMI en la máquina 
	// local, si no existe en el número de puerto especificado. 
            
	private static void arrancarRegistro(int numPuertoRMI) throws RemoteException { 
	
            try { 
                    Registry registro = LocateRegistry.getRegistry(numPuertoRMI); 
                    registro.list(); // Esta llamada lanza una excepción si el registro no existe
                }
                catch (RemoteException e) { // Registro no válido en este puerto
                    /* */ System.out.println
                    /* */ ("El registro RMI no se puede localizar en el puerto " + numPuertoRMI);
        
                    Registry registro =  LocateRegistry.createRegistry(numPuertoRMI);
                    /* */      System.out.println("Registro RMI creado en el puerto" + numPuertoRMI);
                } // fin catch
        } // fin arrancarRegistro

 // Este método lista los nombres registrados con un objeto Registry
        
            private static void listaRegistro(String URLRegistro) throws RemoteException, MalformedURLException {
            
                System.out.println("Registro " + URLRegistro + " contiene: " );
                    
                    String [] nombres = Naming.list(URLRegistro);
                    
                    for (int i=0; i<nombres.length; i++)
                    System.out.println(nombres[i]);
                    
            } // fin listaRegistro

 } 
                    

        
            
