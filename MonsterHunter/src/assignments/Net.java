package assignments;



public class Net {
	private int captureChance;

	
	
	public Net(int captureChance) {
		super();
		this.captureChance = captureChance;
	}


	public int getCaptureChance() {
		return captureChance;
	}


	public void setCaptureChance(int captureChance) {
		this.captureChance = captureChance;
	}


	public int genChance () {
		int success;
		if (this.getCaptureChance() % 2 == 0)  success = 1;
		else success = 0;
		
		return success;
	}
}
