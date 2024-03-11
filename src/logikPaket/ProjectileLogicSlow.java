package logikPaket;

public class ProjectileLogicSlow {
	
	/**
	 * Håller koll på hur mycket SlowProjectiles ska sakta ner
	 * fienderna
	 */
	
	private double slowAmount;
	
	public ProjectileLogicSlow (double slowAmount) {
		this.slowAmount = slowAmount;
	}
	
	public double getSlow() {
		return slowAmount;
	}
	
	public void setSlow(double amount) {
		slowAmount = amount;
	}

}
