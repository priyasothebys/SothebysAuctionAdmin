package admin.sothelabs.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class NewCreator {

	/*public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//priya.ganesan//Documents//Browsers//chromedriver");
		WebDriver dr = new ChromeDriver();
		dr.get("https://admin.staging.sothelabs.com");
		Thread.sleep(1000);
		waitforElement(dr, dr.findElement(By.xpath("//input[@type = 'email']")));
		dr.findElement(By.xpath("//input[@type = 'email']")).sendKeys("priya.ganesan@sothebys.com");
		dr.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Testing123");
		dr.findElement(By.id("login-button-id")).click();
		//waitforElement(dr, dr.findElement(By.xpath("/button[@class = 'sc-eInJlc ggyyxR']")));
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")).click();
		waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
		dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")).click();
		Thread.sleep(5000);
		waitforElement(dr, dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")));
		excelDataConfig("//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
		for(int i= 442; i <= 450 ; i++){
			String data = getData("Sheet1", i);
			dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")).sendKeys(data);
			Select dropdown_gender = new Select(dr.findElement(By.xpath("//select[@name = 'select']")));
			dropdown_gender.selectByVisibleText("Male");
			WebElement dropdown = dr.findElement(By.xpath("//input[@placeholder = 'Preferred Role']/ancestor::div[@class = 'sc-eNQAEJ cdBVrU sc-kgoBCf gcURcx']"));
			dropdown.click(); // assuming you have to click the "dropdown" to open it
			Thread.sleep(1000);
			dropdown.findElement(By.xpath("//li[@id = 'react-autowhatever-1--item-0']/div/span")).click();
			dr.findElement(By.xpath("//button[contains(text(), 'Create')]")).click();
			if(dr.findElements(By.xpath("//div[@role = 'button'][contains(text(), 'Primary Details')]")).size() > 0){
				writeData("Sheet1", i, 1, "//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
			}else{
				System.out.println("Fails at creator : " + data);
			}
			
			//wb.write(fout);
			System.out.println(data);
			Thread.sleep(5000);
			dr.findElement(By.xpath("//img[@class = 'logo']")).click();
			waitforElement(dr,dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")));
			
			dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")).click();
			waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
			dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")).click();
			//Thread.sleep(3000);
			waitforElement(dr, dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")));
		}
	}*/
	
	
	
	///--------------CREATE OBJECTS---------------------
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//priya.ganesan//Documents//Browsers//chromedriver");
		WebDriver dr = new ChromeDriver();
		dr.get("https://admin.staging.sothelabs.com");
		Thread.sleep(1000);
		waitforElement(dr, dr.findElement(By.xpath("//input[@type = 'email']")));
		dr.findElement(By.xpath("//input[@type = 'email']")).sendKeys("priya.ganesan@sothebys.com");
		dr.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Testing123");
		dr.findElement(By.id("login-button-id")).click();
		//waitforElement(dr, dr.findElement(By.xpath("/button[@class = 'sc-eInJlc ggyyxR']")));
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")).click();
		waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
		dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")).click();
		Thread.sleep(5000);
		waitforElement(dr, dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")));
		excelDataConfig("//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
		for(int i= 545; i <= 587 ; i++){
			String data = getData("Sheet1", i);
			dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")).sendKeys(data);
			Select dropdown_gender = new Select(dr.findElement(By.xpath("//select[@name = 'select']")));
			dropdown_gender.selectByVisibleText("Male");
			WebElement dropdown = dr.findElement(By.xpath("//input[@placeholder = 'Preferred Role']/ancestor::div[@class = 'sc-eNQAEJ cdBVrU sc-kgoBCf gcURcx']"));
			dropdown.click(); // assuming you have to click the "dropdown" to open it
			Thread.sleep(1000);
			dropdown.findElement(By.xpath("//li[@id = 'react-autowhatever-1--item-0']/div/span")).click();
			dr.findElement(By.xpath("//button[contains(text(), 'Create')]")).click();
			if(dr.findElements(By.xpath("//div[@role = 'button'][contains(text(), 'Primary Details')]")).size() > 0){
				writeData("Sheet1", i, 1, "//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
			}else{
				System.out.println("Fails at creator : " + data);
			}
			
			//wb.write(fout);
			System.out.println(data);
			Thread.sleep(5000);
			dr.findElement(By.xpath("//img[@class = 'logo']")).click();
			waitforElement(dr,dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")));
			
			dr.findElement(By.xpath("//button[@class = 'sc-eInJlc ggyyxR']")).click();
			waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
			dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")).click();
			//Thread.sleep(3000);
			waitforElement(dr, dr.findElement(By.xpath("//input[@placeholder = 'Preferred Name']")));
		}
	}
		

	
	public static WebElement waitforElement(WebDriver dr, WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(dr, 60);
			return wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			System.out.println("Unable to find Element on page: " + webElement);
			return null;
		} finally {
			dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
	}
	
	static XSSFWorkbook wb ;
	static XSSFSheet sheet;
	
	
	public static void excelDataConfig(String excelPath) {
		try {
			File src  = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int getNumOfRows(String sheetname){
	sheet = wb.getSheet(sheetname);
	int num_row = sheet.getLastRowNum();
	return num_row;
	
	}
	
	public static String getData(String sheetname, int row){
		sheet = wb.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(0).getStringCellValue();
		return data;	
	}
	
	public static void writeData(String sheetname, int row, int column, String src1){
		sheet = wb.getSheet(sheetname);
		sheet.getRow(row).createCell(column).setCellValue("DONE");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(src1);
			wb.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}


