package assignments;


public class ElementedMonster extends Monsters implements Methods{
	private String lowWeakness, highWeakness;
	private double multiplier;
	
	
	public ElementedMonster(String name, String type, String element, String area, String lowWeakness,
			String highWeakness, double multiplier) {
		super(name, type, element, area);
		this.lowWeakness = lowWeakness;
		this.highWeakness = highWeakness;
		this.multiplier = multiplier;
	}
	
	public String getLowWeakness() {
		return lowWeakness;
	}
	public void setLowWeakness(String lowWeakness) {
		this.lowWeakness = lowWeakness;
	}
	
	public String getHighWeakness() {
		return highWeakness;
	}
	public void setHighWeakness(String highWeakness) {
		this.highWeakness = highWeakness;
	}
	
	public double getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	
	@Override
	public void showData() {
		// TODO Auto-generated method stub
		System.out.printf("| %-16s | %-10s | %-8s | %-8s |\n", this.getName(), this.getType(), this.getElement(), this.getArea());
	}
	@Override
	public int genDamage(int damage) {
		int newDamage = (int) (this.getMultiplier() * damage);
		return newDamage;
	}
	
	

}
