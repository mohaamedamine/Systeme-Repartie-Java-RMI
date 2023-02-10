import java.rmi.*;

public interface FabObjectInterface extends Remote {
	public ObjectInterface newObject() throws RemoteException;
}

