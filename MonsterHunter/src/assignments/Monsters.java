package assignments;

public abstract class Monsters {
	private String name, type, element, area;


	public Monsters(String name, String type, String element, String area) {
		super();
		this.name = name;
		this.type = type;
		this.element = element;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
