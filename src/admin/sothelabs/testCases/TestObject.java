package admin.sothelabs.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class TestObject {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//priya.ganesan//Documents//Browsers//chromedriver");
		//System.setProperty("webdriver.gecko.driver", "//Users//priya.ganesan//Documents//Browsers//geckodriver 2");
		
		WebDriver dr = new ChromeDriver();
		//WebDriver dr = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) dr;
		dr.get("https://admin.staging.sothelabs.com");
		Thread.sleep(1000);
		waitforElement(dr, dr.findElement(By.xpath("//input[@type = 'email']")));
		dr.findElement(By.xpath("//input[@type = 'email']")).sendKeys("priya.ganesan@sothebys.com");
		dr.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Testing123");
		dr.findElement(By.id("login-button-id")).click();
		//waitforElement(dr, dr.findElement(By.xpath("/button[@class = 'sc-eInJlc ggyyxR']")));
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@class = 'sc-gPzReC kbNpvG']")).click();
		
		waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
		dr.findElement(By.xpath("//ul/li/a[contains(@href, '/objects/new')]")).click();
		Thread.sleep(3000);
		
		waitforElement(dr, dr.findElement(By.xpath("//input[@placeholder = 'Title of work']")));
		excelDataConfig("//Users//priya.ganesan//Documents//ExcelSheet//Workbook5.xlsx");
		//getNumOfRows("CreateObject")
		for(int i=876; i <= getNumOfRows("CreateObject") ; i++){
			String data = getData("CreateObject", i , 0);
			dr.findElement(By.xpath("//input[@placeholder = 'Title of work']")).sendKeys(data);

			WebElement dropdown = dr.findElement(By.xpath("//input[@placeholder = 'Creator']/ancestor::div[@class = 'sc-ckVGcZ dtZFfk sc-kAzzGY cCHKYQ']"));
			Actions actions = new Actions(dr);
			actions.moveToElement(dropdown).click();
			Thread.sleep(1000);
			actions.sendKeys(getData("CreateObject", i , 1));
			actions.sendKeys(Keys.ENTER);
			actions.build().perform();
			Thread.sleep(1000);
			dr.findElement(By.xpath("//div[@data-placeholder = 'Description']")).sendKeys(getData("CreateObject", i , 2));
			
			js.executeScript("scroll(0,250);");

			//dr.findElement(By.xpath("//div[@data-placeholder = 'Description']")).sendKeys(Keys.ENTER);
			//webdriver.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
			Thread.sleep(1000);
			Select dropdown_gender = new Select(dr.findElement(By.xpath("//select[@name = 'select']")));
			dropdown_gender.selectByVisibleText("Generic");
			Thread.sleep(3000);
			
			
			
			dr.findElement(By.xpath("//div[@data-placeholder = 'Provenance']")).sendKeys(getData("CreateObject", i , 10));
			dr.findElement(By.xpath("//div[@data-placeholder = 'Provenance']")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			dr.findElement(By.xpath("//div[@data-placeholder = 'Exhibition']")).sendKeys(getData("CreateObject", i , 9));
			//dr.findElement(By.xpath("//div[@data-placeholder = 'Exhibition']")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			dr.findElement(By.xpath("//div[@data-placeholder = 'Literature']")).sendKeys(getData("CreateObject", i , 7));
			//dr.findElement(By.xpath("//div[@data-placeholder = 'Literature']")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			dr.findElement(By.xpath("//input[@placeholder = 'Executed In']")).sendKeys(getData("CreateObject", i , 8));
			//dr.findElement(By.xpath("//input[@placeholder = 'Executed In']")).sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			dr.findElement(By.xpath("//button[contains(text(), 'Create')]")).click();

			if(dr.findElements(By.xpath("//button[contains(text(), 'Edit')]")).size() > 0){
				writeData("CreateObject", i, 11, "//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
			}else{
				System.out.println("Fails at creator : " + data);
			}

			System.out.println(data);
			Thread.sleep(3000);
			dr.findElement(By.xpath("//img[@class = 'logo']")).click();
			Thread.sleep(2000);
			waitforElement(dr,dr.findElement(By.xpath("//button[@class = 'sc-gPzReC kbNpvG']")));
			dr.findElement(By.xpath("//button[@class = 'sc-gPzReC kbNpvG']")).click();
			waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
			dr.findElement(By.xpath("//ul/li/a[contains(@href, '/objects/new')]")).click();
			Thread.sleep(2000);

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
	
	public static String getData(String sheetname, int row, int column){
		sheet = wb.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
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


