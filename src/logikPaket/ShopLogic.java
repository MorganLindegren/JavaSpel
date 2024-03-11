package logikPaket;

public class ShopLogic {
	
	/**
	 * Håller koll på hur mycket pengar spelaren har och uppdateras
	 * beroende på om spelaren köper ett torn i Shop eller om en fiende
	 * dör
	 */
	
	private static Integer money = 6;
	
	public ShopLogic() {
		
	}
	
	public Integer getMoney() {
		return money;
	}
	
	public void buy() {
		money -= 1;	
	}
	
	public void increaseMoney() {
		money += 1;
	}
	
	public void setMoney(int i) {
		
		money = i;
	}

}
