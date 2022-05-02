package Server;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import ComputePi.ComputePi;
import ComputePi.Pi;

public class MyServer extends UnicastRemoteObject implements ComputePi{	
	
	protected MyServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigDecimal computePi( Pi val) throws RemoteException {
		return val.execute();
	}

	public static void main (String args[]) {
		try {
			Registry r = LocateRegistry.getRegistry();
			r.bind("myserver", new MyServer());
			System.out.println("The PI Computer is ready for action!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
