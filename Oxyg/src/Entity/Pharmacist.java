package Entity;

public class Pharmacist {


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	
	

	@Override
	public String toString() {
		return "Pharmacist [Id: " + id + "| Name: " + name + "| Surname: " + surname + "| Pharmacy Name: " + pharmacyName;
	}




	private String id;
	private String name;
	private String surname;
	private String pharmacyName;


}
