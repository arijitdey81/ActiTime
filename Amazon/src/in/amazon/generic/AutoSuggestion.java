package in.amazon.generic;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Google AutoSuggestion
 * @author ARIJIT
 *
 */
public class AutoSuggestion {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	/**
	 * 
	 * @param args
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./data/generic.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String page = wb.getSheet("testDATA").getRow(1).getCell(1).getStringCellValue();
		driver.get(page);
		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> allSugg = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		for(WebElement textLinks:allSugg) {
			String text = textLinks.getText();
			System.out.println(text);
		}
		driver.close();
	}

	
}
