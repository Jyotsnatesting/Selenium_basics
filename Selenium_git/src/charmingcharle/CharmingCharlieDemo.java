package charmingcharle;

public class CharmingCharlieDemo {

	public static void main(String[] args) {
		
		CharmingCharlie cc = new CharmingCharlie();
		
		cc.invokeBrowser();
		cc.SelectCategory();
		System.out.println("Selected handbags category");
		cc.selectDropdown();
		System.out.println("The handbags displayed in the order");
		cc.closeBrowser();

	}

}
