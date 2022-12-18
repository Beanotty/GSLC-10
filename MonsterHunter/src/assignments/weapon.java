package assignments;

public class weapon implements Methods {
	private String weaponElement;
	private double weaponMultiplier;
	
	
	
	public weapon(String weaponElement, double weaponMultiplier) {
		super();

		this.weaponElement = weaponElement;
		this.weaponMultiplier = weaponMultiplier;
	}




	public String getWeaponElement() {
		return weaponElement;
	}


	public void setWeaponElement(String weaponElement) {
		this.weaponElement = weaponElement;
	}

	public double getWeaponMultiplier() {
		return weaponMultiplier;
	}

	public void setWeaponMultiplier(double weaponMultiplier) {
		this.weaponMultiplier = weaponMultiplier;
	}

	@Override
	public int genDamage(int damage) {

		int newDamage = (int) (this.getWeaponMultiplier() * damage);
		return newDamage;
	}


	@Override
	public void showData() {
		// TODO Auto-generated method stub
		
	}



	

	
}
