package entities;

public class Pacient {
	private String name;

	public Pacient(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
@Override
	public String toString() {
	return name;
	}
	
	
}
