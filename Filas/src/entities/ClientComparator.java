package entities;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client>{

	public int compare(Client cli1, Client cli2) {
		
		Client client1 = (Client)cli1;
		Client client2 = (Client)cli2;

		if (client1.getPriority() > client2.getPriority()) {
			return -1;
		}
		else {
			return +1;
		}
	}

}
