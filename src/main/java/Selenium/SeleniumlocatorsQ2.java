package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumlocatorsQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 		 	 
		 //Load the url
		 driver.get("https://www.demoblaze.com/");	
		 
		//Maximize the window
		 driver.manage().window().maximize();
		 
		 //Print the url
		 String title = driver.getTitle();
		 System.out.println("Page title: " + title);
		 
		 //Verify the title
		 if (title.equals("STORE")) {
			 System.out.println("Page landed on correct website.");
		 }
		 else {
			 System.out.println("Page not landed on correct website");
		 }
		 
		 //Close the browser
		 driver.close();
			

	}

}
