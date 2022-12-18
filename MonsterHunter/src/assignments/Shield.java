package assignments;

public class Shield extends weapon {
	private int damageTaken; 

	public Shield(String weaponElement, double weaponMultiplier, int damageTaken) {
		super(weaponElement, weaponMultiplier);
		this.damageTaken = damageTaken;
	}
	
	
	
	public int getDamageTaken() {
		return damageTaken;
	}



	public void setDamageTaken(int damageTaken) {
		this.damageTaken = damageTaken;
	}

}
