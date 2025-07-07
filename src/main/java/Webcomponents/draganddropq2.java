package Webcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class draganddropq2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 //Load the url
		 driver.get("https://jqueryui.com/droppable/");
		 
		// Set path to your ChromeDriver executable
		 System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
		 
		 try {
	            // Switch to the iframe that contains the drag and drop elements
	            WebElement iframe = driver.findElement(By.className("demo-frame"));
	            driver.switchTo().frame(iframe);

	            // Find the source and target elements
	            WebElement source = driver.findElement(By.id("draggable"));
	            WebElement target = driver.findElement(By.id("droppable"));

	            // Perform the drag and drop operation
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(source, target).perform();

	            // Wait for a moment to ensure the action completes
	            Thread.sleep(1000);

	            // Verify background color change (optional visual check)
	            String bgColor = target.getCssValue("background-color");
	            System.out.println("Target background color: " + bgColor);

	            // Verify that the text has changed to "Dropped!"
	            String droppedText = target.getText();
	            System.out.println("Target text after drop: " + droppedText);

	            if (droppedText.equals("Dropped!")) {
	                System.out.println("✅ Drag and Drop operation successful!");
	            } else {
	                System.out.println("❌ Drag and Drop operation failed!");
	            }

	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	}

}
