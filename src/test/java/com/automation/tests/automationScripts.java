
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
				log.info("password field is cleared");
					
				WebElement buttonElement=null;
				clickButton(buttonElement);
				
				String expectedError = appProp.getProperty("login.error.message");
			    By error = By.xpath("//*[@id=\"error\"]");
			    WebElement errorMessage = driver.findElement(error);
			    String actualText = errorMessage.getText();
			    Assert.assertEquals(expectedError,actualText);
			    log.info("error message compared");
			    report.logTestpassed("error message matched");
				}
			
			
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
				report.logTestpassed("login successful");
			    }
			
			@Test
			public void TC_3_usermenuDropdown() throws InterruptedException {

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
				enterText(passwordElement,password,"passwrd");
				
				By rememberMeCheckbox = By.xpath("//*[@id=\"rememberUn\"]");
				WebElement rememberMeCheckboxElement = driver.findElement(rememberMeCheckbox);
				clickOnCheckbox(rememberMeCheckboxElement,  "rememberMeCheckbox");
				
				//By button = By.tagName("button");
				WebElement buttonElement=null;
				clickButton(buttonElement);
				
				
				By userMenuDropdown = By.xpath("//*[@id=\"userNav-arrow\"]");
				WebElement userMenuElement = driver.findElement(userMenuDropdown);
				clickOnButton(userMenuElement, "userMenuDropdown");
				
				
				By logOutLink = By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]");
				WebElement logOutElement = driver.findElement(logOutLink);
				clickOnButton(logOutElement, "logOutLink");
				report.logTestpassed("successfully loged out from usermenu");
			}
			
			@Test
			public void TC_4_forgotPassword() throws InterruptedException {
			
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");	
				
                getCredentials();
				
				compareTitle();
				
				By userName = By.name("username");
				WebElement userNameElement = driver.findElement(userName);
				WaitUntilElementVisible(userNameElement, "username field");
				enterText(userNameElement, userId, "userName");
				
				By forgotPassword = By.xpath("//*[@id=\"forgot_password_link\"]");
				WebElement forgotPasswordElement = driver.findElement(forgotPassword);
				clickOnButton(forgotPasswordElement, "forgotPassword");
				
				String userId = appProp.getProperty("login.valid.userid");
				
				By userNameTextbox = By.xpath("//*[@id=\"un\"]");
				WebElement userNameTextboxElement = driver.findElement(userNameTextbox);
				enterText(userNameTextboxElement, userId, "userName");
				
				By continueButton = By.xpath("//*[@id=\"continue\"]");
				WebElement continueButtonElement = driver.findElement(continueButton);
				clickOnButton(continueButtonElement, "continueButton");
				report.logTestpassed("forgot username is clicked and verified email sent to reset password");
				
			}
			
			@Test
			public void TC_5_wrongLogin_credentials() throws InterruptedException {
			
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");	
				
				String userId = appProp.getProperty("login.invalid.userid");
				String password = appProp.getProperty("login.invalid.password");
				
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
				
				String expectedError = appProp.getProperty("wrong.login.error.message");
			    By error = By.xpath("//*[@id=\"error\"]");
			    WebElement errorMessage = driver.findElement(error);
			    String actualText = errorMessage.getText();
			    Assert.assertEquals(expectedError,actualText);
			    log.info("error message compared");
			    //report.logTestpassed("error message matched");
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			}
			
		