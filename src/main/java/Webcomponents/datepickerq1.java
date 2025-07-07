package Webcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepickerq1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 //Load the url
		 driver.get("https://jqueryui.com/datepicker/");
		 
		// Set path to your ChromeDriver executable
		 System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
		 
		// Open the jQuery UI datepicker page
	        driver.get("https://jqueryui.com/datepicker/");

	        try {
	            // Switch to the iframe that contains the datepicker
	            WebElement iframeElement = driver.findElement(By.className("demo-frame"));
	            driver.switchTo().frame(iframeElement);

	            // Click on the input box to open the datepicker
	            WebElement dateInput = driver.findElement(By.id("datepicker"));
	            dateInput.click();

	            // Click the "Next" button to go to the next month
	            WebElement nextButton = driver.findElement(By.className("ui-datepicker-next"));
	            nextButton.click();

	            // Click on date "22"
	            WebElement date22 = driver.findElement(By.xpath("//a[text()='22']"));
	            date22.click();

	            // Get the selected date from the input box
	            String selectedDate = dateInput.getDomProperty("value");
	            System.out.println("Selected Date is: " + selectedDate);

	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        } finally {
	            // Close the browser and quit the driver
	            driver.quit();
	        }

	}

}
