package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumlocatorsQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 //Load the url
		 driver.get("http://google.com");	
		 
		 //Print the url
		 String currenturl = driver.getCurrentUrl();
		 System.out.println("URL: " + currenturl);
		 
		 //Reload the page
		 driver.navigate().refresh();
		 
		 //Close the browser
		 driver.close();
			
	}

}
