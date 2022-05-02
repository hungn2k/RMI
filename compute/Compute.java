package lab02.compute;

import java.rmi.*;

public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
