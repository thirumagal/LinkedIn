package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;

public class RunScripts extends LinkedInWrappers{

	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
	testCaseName 	= "TC01 - Login (Keyword)";
		testDescription = "Login to Linked In Using Keyword";
		//testCaseName 	= "TC05 - Change Phone Number(Keyword)";
		//testDescription = "Change Phone Number in LinkedIn Using Keyword";
//		testCaseName 	= "TC06 - Search Jobs (Keyword)";
	//	testDescription = "Search jobs in Linked In Using Keyword";
	
	}

	@Test
	public void runScripts() throws IOException {

		CallWrappersUsingKeyword keywords = new CallWrappersUsingKeyword();

		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\Keywords\\KeywordDriver.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			int rowCount = sheet.getLastRowNum();			

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					if(row.getCell(3).getStringCellValue().toLowerCase().equals("yes"))
						keywords.getAndCallKeyword("./keywords/"+row.getCell(1).getStringCellValue()+".xlsx");
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
