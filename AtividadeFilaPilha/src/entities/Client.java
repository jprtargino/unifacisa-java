package entities;

public class Client {
	private String name;
	private Integer priority;

	public Client(String name, Integer priority) {
		this.name = name;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		if (priority == 2) {
			return "Cliente: " + name + " - Atendimento preferencial";
		} else {
			return "Cliente: " + name + " - Atendimento normal";
		}
	}
	
	/*Nesse caso, criei uma classe "normal" para guardar as informações do cliente, determinando seus únicos atributos 
	 * (nome e "level" de prioridade - normal ou prioritária)*/
	
}
