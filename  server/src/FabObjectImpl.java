import java.rmi.*;
import java.rmi.server.*;

public class FabObjectImpl extends UnicastRemoteObject implements FabObjectInterface {

	public FabObjectImpl() throws RemoteException {
	};

	public ObjectInterface newObject() throws RemoteException {
		return new Object();
	}
}

