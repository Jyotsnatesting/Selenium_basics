package charmingcharle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CharmingCharlie {

	
	ChromeDriver driver;
	
	public void invokeBrowser() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\jyotsna\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.charmingcharlie.com/");
		
	}
	
	public void SelectCategory() {

		WebElement handbags = driver.findElement(By.xpath("//a[contains(text(),'Handbags') and @data-opened=\"false\"]"));
		//handbags.click();
		Actions action = new Actions(driver);
		action.moveToElement(handbags).build().perform();
		
		waitTillElementVisible(By.xpath("//li[@class='menu-item-level-2']/a[contains(text(),'Crossbody Bags')]"), 10);
	
		WebElement crossbodybags = driver.findElement(By.xpath("//li[@class='menu-item-level-2']/a[contains(text(),'Crossbody Bags')]"));
		//crossbodybags.click();
		action.moveToElement(crossbodybags).click().build().perform();
		System.out.println("The action performed in the charming charlie");
		
		System.out.println("Closing the alert");
		WebElement closebutton = driver.findElement(By.xpath("//button[@title='Close (Esc)']"));
		closebutton.click();
	}
	
	public void selectDropdown() {
		
		WebElement sort = driver.findElement(By.id("grid-sort-header-mobile"));
		Select select = new Select(sort);
		select.selectByVisibleText("Low to High");
		System.out.println("Selected the option that we have bags from low price to high");
				
	}
	public void closeBrowser() {
		
		driver.close();
	}
	
	//Using Explicit wait
	private void waitTillElementVisible(By by, int timeOutSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	
}
