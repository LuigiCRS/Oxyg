package Entity;

public class OxygenCylinder {

	public OxygenCylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OxygenCylinder(Integer id, Integer volume) {
		super();
		this.id = id;
		this.volume = volume;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	private Integer id;
	private Integer volume;

}
