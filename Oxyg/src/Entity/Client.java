package Entity;

public class Client {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String surname, String address, String cF) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		CF = cF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", address=" + address + ", CF=" + CF + "]";
	}

	private String name;
	private String surname;
	private String address;
	private String CF;

}
