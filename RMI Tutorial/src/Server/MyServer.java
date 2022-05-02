package Server;

import java.math.BigDecimal;

import ComputePi.ComputePi;
import ComputePi.Pi;

public class MyServer implements ComputePi{	
	
	public BigDecimal computePi( Pi val) {
		return val.execute();
	}


}
