package ComputePi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputePi extends Remote {
	BigDecimal computePi(Pi val) throws RemoteException;

}
