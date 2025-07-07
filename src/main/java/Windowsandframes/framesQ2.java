package Windowsandframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class framesQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 // Load the URL
		 driver.get("http://the-internet.herokuapp.com/nested_frames");
		 
		 
		// Set ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
	        
	        try {
	            
	        	// Switch to top frame
	            driver.switchTo().frame("frame-top");
	            System.out.println("Switched to top frame");
	            Thread.sleep(1000);

	            // Switch to left frame
	            driver.switchTo().frame("frame-left");
	            String leftText = driver.findElement(By.xpath("//body")).getText();
	            System.out.println("Left Frame Text: " + leftText);
	            Thread.sleep(1000);

	            // Back to top, then to middle
	            driver.switchTo().parentFrame();
	            driver.switchTo().frame("frame-middle");
	            String middleText = driver.findElement(By.cssSelector("body > div")).getText();
	            System.out.println("Middle Frame Text: " + middleText);
	            Thread.sleep(1000);

	            // Back to top, then to right
	            driver.switchTo().parentFrame();
	            driver.switchTo().frame("frame-right");
	            String rightText = driver.findElement(By.xpath("//body")).getText();
	            System.out.println("Right Frame Text: " + rightText);
	            Thread.sleep(1000);

	            // Switch back to main page
	            driver.switchTo().defaultContent();
	            System.out.println("Switched back to main content");
	            Thread.sleep(1000);

	            // Switch to bottom frame
	            driver.switchTo().frame("frame-bottom");
	            String bottomText = driver.findElement(By.xpath("//body")).getText();
	            System.out.println("Bottom Frame Text: " + bottomText);
	            Thread.sleep(1000);

	            // Back to main content and check title
	            driver.switchTo().defaultContent();
	            String pageTitle = driver.getTitle();
	            System.out.println("Page Title: " + pageTitle);

	            // Verify page title
	            if (pageTitle.equals("Frames")) {
	                System.out.println("Page title is verified as 'Frames'.");
	            } else {
	                System.out.println("Page title is not 'Frames'. It is: " + pageTitle);
	            }

	        } catch (Exception e) {
	            System.out.println("Error occurred: " + e.getMessage());
	        } finally {
	            driver.quit();
	            System.out.println("Browser closed.");
	        }

	}

}
