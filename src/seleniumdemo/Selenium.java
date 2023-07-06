package seleniumdemo;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Selenium {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(options);
		
	
		
		driver.get("https://www.alza.sk/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Odmietnuť všetko']")).click();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(1000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Gaming, hry a zábava')]"))).build().perform();
		Thread.sleep(1000);
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Hry na PC a konzoly')]"));
		builder.moveToElement(link).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Hry na PC a konzoly')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='alzaDialog']/div[2]")).click();
		WebElement act = driver.findElement(By.xpath("//header/div[5]/div[1]/div[1]/div[1]/input[1]"));
		builder.moveToElement(act).build().perform();
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//header/div[5]/div[1]/div[1]/button[1]"));
		builder.moveToElement(search).build().perform();
		Thread.sleep(3000);
		
		Action seriesOfActions = builder.sendKeys(act, "Diablo IV")
				.keyDown(search, Keys.SHIFT)
				.keyUp(search, Keys.SHIFT)
				.build();
		seriesOfActions.perform();
					
		Thread.sleep(3000);
		driver.quit();
	}

	
	
}
