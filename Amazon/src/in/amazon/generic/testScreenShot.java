package in.amazon.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Listner(in.amazon.generic.ListnerImplementation.class)
public class testScreenShot extends BaseClass {
	
	@Test
	public void screenShotTest() throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis=new FileInputStream("./data/generic.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet("testDATA").getRow(0).getCell(1).getStringCellValue();
		driver.get(data);
		String data1 = wb.getSheet("testDATA").getRow(1).getCell(1).getStringCellValue();
		driver.get(data1);
		TakesScreenshot t=(TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE); 
		File dest=new File("./ScreenShot/amazon.png");
		FileUtils.copyFile(source, dest);
		driver.close();
		Assert.fail();
		
		
	}

}
