package Windowsandframes;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class windowhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 // Load the URL
		 driver.get("https://the-internet.herokuapp.com/windows");
		
		 // Suppress "Cast" button using ChromeOptions
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-features=EnableCastMediaRouteProvider");
	        
		// Set path to ChromeDriver executable
		 System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
		
		 try {
			 String mainWindow = driver.getWindowHandle();

			 driver.findElement(By.linkText("Click Here")).click();

	            Set<String> allWindows = driver.getWindowHandles();
	            for (String win : allWindows) {
	                if (!win.equals(mainWindow)) {
	                    driver.switchTo().window(win);
	                    break;
	                }
	            }

	            String heading = driver.findElement(By.tagName("h3")).getText();
	            System.out.println("New window heading: " + heading);

	            // Pause so user can see the new window
	            Thread.sleep(3000);  // 3 seconds

	            driver.close();
	            driver.switchTo().window(mainWindow);
	            System.out.println("Back to original window.");

	            // Pause so user can see original window
	            Thread.sleep(3000);  // 3 seconds

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            driver.quit(); // Close all windows
	        }
	}

}
