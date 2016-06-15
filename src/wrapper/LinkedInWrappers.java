package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;
import utils.Reporter;

public class LinkedInWrappers extends GenericWrappers {
	
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite
	public void beforeSuite(){
		Reporter.startResult();
	}

	@BeforeTest
	public void beforeTest(){
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		Reporter.startTestCase();
		invokeApp(browserName);
	}
		
	@AfterSuite
	public void afterSuite(){
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest(){
		
	}
	
	@AfterMethod
	public void afterMethod(){
		quitBrowser();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}
	
	/**
	 * This method will login to Linkedin project and verify the name
	 * @param userName The user name of the linked in login
	 * @param password The password of the linked in login
	 * @param name The name of the linked in login to be verified
	 * @author Babu - TestLeaf
	 */
	public void login(String userName, String password, String name){
		enterById("login-email", userName);
		enterById("login-password", password);
		clickByName("submit");
		verifyTextByXpath("//a[@class='name']",name);
	}
	
	/**
	 * This method will logout from Linkedin project
	 * @author Babu - TestLeaf
	 */
	public void logout(){
		mouseOverByXpath("//li[@class='nav-item account-settings-tab']");
		clickByLink("Sign Out");
	}

}
