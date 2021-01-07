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

	private String id;
	private Integer volume;

}
