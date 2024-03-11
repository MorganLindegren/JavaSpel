package logikPaket;

public class ShopLogic {
	
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

}
