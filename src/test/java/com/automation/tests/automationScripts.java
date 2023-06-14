
package com.automation.tests;

		import org.testng.annotations.Test;
        import org.testng.AssertJUnit;
		import org.testng.annotations.Test;
        import org.testng.AssertJUnit;
		import org.testng.annotations.Test;
        import org.testng.AssertJUnit;
		import org.testng.annotations.Test;
		import java.time.Duration;
		import java.util.Properties;
		import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.Alert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.ElementNotInteractableException;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.NoSuchElementException;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.FluentWait;
		import org.openqa.selenium.support.ui.Wait;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import org.testng.Assert;
		import org.testng.annotations.Test;
        import com.automation.BaseTests.BaseTestsSalesforce;
        import com.automation.utility.PropertiesUtility;
		import io.github.bonigarcia.wdm.WebDriverManager;
		import org.apache.logging.log4j.core.Logger;
        import org.apache.logging.log4j.spi.AbstractLogger;
		public class automationScripts extends BaseTestsSalesforce{
			
			@Test
			public void login_to_salesforce_testscript() throws InterruptedException {
				
				
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				
				/*String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");*/
				
				getCredentials();
				
				
				/*String expectedTitle = "Login | Salesforce";
				String actualTitle = getPageTitle();
				AssertJUnit.assertEquals(actualTitle, expectedTitle);*/
				
				compareTitle();
			
			
				By userName = By.name("username");
				WebElement userNameElement = driver.findElement(userName);
				WaitUntilElementVisible(userNameElement, "username field");
				enterText(userNameElement, userId, "userName");
				
				By passwrd = By.xpath("//input[@name='pw']");
				WebElement passwordElement = driver.findElement(passwrd);
				WaitUntilElementVisible(passwordElement, "password field");
				enterText(passwordElement,password,"passwrd");
				
				//By button = By.tagName("button");
				WebElement buttonElement=null;
				clickButton(buttonElement);
				
			    }
				
			@Test
			public  void TC_1_error_login_salesforce_testscript() throws InterruptedException {
				
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");	
				
				getCredentials();
				
				compareTitle();
					
				By userName = By.name("username");
				WebElement userNameElement = driver.findElement(userName);
				WaitUntilElementVisible(userNameElement, "username field");
				enterText(userNameElement, userId, "userName");
					
				By passwrd = By.xpath("//input[@name='pw']");
				WebElement passwordElement = driver.findElement(passwrd);
				WaitUntilElementVisible(passwordElement, "password field");
				passwordElement.clear();
					
				WebElement buttonElement=null;
				clickButton(buttonElement);
				
				String expectedError = appProp.getProperty("login.error.message");
				By error = By.xpath("//*[@id=\"error\"]");
				WebElement errorMessage = driver.findElement(error);
				String actualText = errorMessage.getText();
				Assert.assertEquals(expectedError,actualText);
				log.info("error message compared");
				
					
				}
			
			
			}
			
		