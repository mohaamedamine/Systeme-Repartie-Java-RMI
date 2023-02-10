
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;

public class DynamicServer {
	public static void main(String[] args) {
		try {
			//System.setProperty("java.security.policy", "server.policy");
			//System.setProperty("java.rmi.server.codebase", "http://localhost/codebase/");

			if (System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager());

			Registry registry = LocateRegistry.createRegistry(1099);

			System.out.println("Serveur : Construction de l'implementation");
			System.out.println("Objet Fabrique lie dans le RMIregistry");
			
			Properties p = System.getProperties();
			String url = p.getProperty("java.rmi.server.codebase");

			Class ClasseServeur1 = RMIClassLoader.loadClass(url, "FabObjectImpl");

			registry.rebind("Fabrique", (Remote) ClasseServeur1.getDeclaredConstructor().newInstance());

			System.out.println("Serveur pr�t.");
			System.out.println("Attente des invocations des clients ...");

		} catch (Exception e) {

			System.out.println("Erreur de liaison de l'objet Fabrique");
			System.out.println(e.toString());
		}
	}
}