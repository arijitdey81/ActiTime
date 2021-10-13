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

public class PrintAllLinks {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./data/generic.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet("testDATA").getRow(0).getCell(1).getStringCellValue();
		driver.get(data);
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(WebElement text:allLinks) {
			String textLinks = text.getText();
			System.out.println(textLinks);
		}
		
		driver.close();
		
	}

}
