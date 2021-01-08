package Entity;

public class OxygenCylinder {

	public OxygenCylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OxygenCylinder(String id, Integer volume) {
		super();
		this.id = id;
		this.volume = volume;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "ID: " + id + "| Volume: " + volume;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OxygenCylinder other = (OxygenCylinder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	private String id;
	private Integer volume;

}
