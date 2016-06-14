package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Reporter;
import wrapper.LinkedInWrappers;

public class TC02_InviteSecondConnections extends LinkedInWrappers{

	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC02";
		testCaseName 	= "TC02 - Invite Connection";
		testDescription = "Invite Second Connection Using LinkedIn";
	}
	
	@Test(dataProvider="fetchData")
	public void loginLogout(String userName, String password, String name,
							String location, String company){
		
		// Login to application
		login(userName,password,name);
		
		// Click on Advanced
		clickByLink("Advanced");
		
		// Enter Location
		enterById("advs-keywords", location);
		
		// Enter company
		enterById("advs-company", company);
		
		// Click Search
		clickByXpath("//*[@id='peopleSearchForm']/div[1]/input[1]");
		
		// Get the first Name
		Reporter.reportStep("The first profile name : "+getTextByXpath("//a[@class='title main-headline']"),"INFO");
		
		// Check if it is first or second connection
		Reporter.reportStep("The first connection is : "+getTextByXpath("//abbr[@class='degree-icon ']"),"INFO");
		
		// Click the first connect button
		clickByXpath("//a[contains(text(),'Connect') and contains(@class,'primary-action-button label')]");
				
		logout();
	}
	
	
}
