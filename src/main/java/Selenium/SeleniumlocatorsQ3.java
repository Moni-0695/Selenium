package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumlocatorsQ3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 		 	 
		 //Load the url
		 driver.get("https://www.wikipedia.org/");	
		 
		//Maximize the window
		 driver.manage().window().maximize();
		 
		//Search for "Artificial Intelligance"
		 
	        driver.findElement(By.id("searchInput")).sendKeys("Artificial Intelligance");
	        driver.findElement(By.className("pure-button-primary-progressive")).click();

	        // Step 5: Wait for page to load
	        Thread.sleep(2000);

	        // Step 6: Click on correct suggestion if available
	        try {
	            driver.findElement(By.partialLinkText("Artificial intelligence")).click();
	            Thread.sleep(2000);
	        } 
	        catch (Exception e) {
	            // If no suggestion, continue
	        }
	        
	        //Click "History" section
	        driver.findElement(By.linkText("History")).click();
	        Thread.sleep(2000);

	        // Print section title
	        String title = driver.findElement(By.id("History")).getText();
	        System.out.println("Section title is: " + title);

	        // Close browser
	        driver.close();

	}

}
