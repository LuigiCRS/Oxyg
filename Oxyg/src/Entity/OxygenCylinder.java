package Entity;

public class OxygenCylinder {

	public OxygenCylinder() {
		super();
	}

	public OxygenCylinder(String id, Integer volume) {
		super();
		this.id = id;
		this.volume = volume;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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
		if (state != other.state)
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OxygenCylinder [id=" + id + ", volume=" + volume + ", state=" + state + "]";
	}

	private String id;
	private Integer volume;
	private boolean state; // FALSE = available TRUE = not available

}
