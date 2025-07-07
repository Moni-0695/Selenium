package Webcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signupq3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the browser		
		 WebDriver driver = new ChromeDriver();
		 
		 //Maximize the window
		 driver.manage().window().maximize();
		 
		 //Load the url
		 driver.get("https://www.guvi.in/");
		 
		// Set path to your ChromeDriver executable
		 System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
		
		 try {
					// Load the GUVI homepage
		            driver.get("https://www.guvi.in/");

		            // Click on the "Sign up" button (top right corner)
		            driver.findElement(By.linkText("Sign up")).click();

		            // Wait until redirected to /register page
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            wait.until(ExpectedConditions.urlContains("/register"));

		            // Generate a unique email for testing
		            String email = "testuser" + System.currentTimeMillis() + "@mail.com";

		            // Fill in the signup form
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Test User");
		            driver.findElement(By.id("email")).sendKeys(email);
		            driver.findElement(By.id("password")).sendKeys("Test@1234");

		            // Corrected: Mobile field ID is "mobileNumber"
		            driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");

		            // Click the "Sign Up" button
		            driver.findElement(By.id("signup-btn")).click();

		            // Wait for registration to process
		            Thread.sleep(5000);
		            System.out.println("Signup completed. Page title: " + driver.getTitle());

		            // Navigate to Login page
		            driver.get("https://www.guvi.in/login");

		            // Perform login with the same email and password
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
		            driver.findElement(By.id("password")).sendKeys("Test@1234");

		            driver.findElement(By.id("login-btn")).click();

		            // Wait for login to complete
		            Thread.sleep(5000);
		            System.out.println("Login completed. Page title: " + driver.getTitle());

		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        } finally {
		            // Close the browser
		            driver.quit();
		        }

	}
}
