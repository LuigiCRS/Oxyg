package Entity;

import java.sql.Date;

public class Sale {

	public Sale() {
		super();
	}

	public Sale(Client client, OxygenCylinder oxygen, Integer id, Pharmacist pharmacist, Date date) {
		super();
		this.client = client;
		this.oxygen = oxygen;
		this.id = id;
		this.pharmacist = pharmacist;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OxygenCylinder getOxygen() {
		return oxygen;
	}

	public void setOxygen(OxygenCylinder oxygen) {
		this.oxygen = oxygen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oxygen == null) {
			if (other.oxygen != null)
				return false;
		} else if (!oxygen.equals(other.oxygen))
			return false;
		if (pharmacist == null) {
			if (other.pharmacist != null)
				return false;
		} else if (!pharmacist.equals(other.pharmacist))
			return false;
		return true;
	}

	private Integer id;
	private Client client;
	private OxygenCylinder oxygen;
	private Pharmacist pharmacist;
	private Date date;

}
