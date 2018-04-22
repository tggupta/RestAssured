package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class UploadExcel_test {

	@Test
	public void uploadExcel() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tarun\\workspace\\RestAssuredLearning\\lib1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://s000.tinyupload.com/");	
		Thread.sleep(3000);
		String title=driver.getTitle();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Tarun\\workspace\\RestAssuredLearning\\lib1\\sample excel.xlsx");
		Thread.sleep(3000);
		System.out.println("File uploaded");
		//driver.findElement(By.xpath("//textarea[@name='file_description']")).sendKeys("Tg1");
		driver.findElement(By.xpath("//img[@alt='Upload']")).click();
		Thread.sleep(2000);
		//String currentWindow=driver.getWindowHandle();
		Set<String> totalWindows=driver.getWindowHandles();
		if(!totalWindows.isEmpty()){
			for(String winId: totalWindows){
				if(driver.switchTo().window(winId).getTitle().equals(title))
				{
					System.out.println("Title matched");
				}else{
					System.out.println("Title did not match and hence closing window");
					driver.close();
				}
			}
		}
	}
}
