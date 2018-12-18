package admin.sothelabs.testUtils;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import admin.sothelabs.pageObjectFactory.Pages;

public class SetupUtils {

	public String platform = System.getProperty("os.name");
	protected String envt ;
	public static WebDriver dr;
	public Properties prop;


	public SetupUtils() {
		PageFactory.initElements(dr, this);
	}
	
	

	public WebDriver initializeDriver() throws InterruptedException {
		if (platform.equals("Mac OS X")) {
			//TestData.ENVT = "stage";
		System.setProperty("webdriver.chrome.driver",
					"//Users//priya.ganesan//Documents//Browsers//chromedriver 2");
//			System.setProperty("webdriver.chrome.driver",
//					"//Users//priya.ganesan//Documents//Browsers//geckodriver 3");
		}else{
			TestData.ENVT = System.getProperty("Environment");
			System.setProperty("webdriver.chrome.driver", "//usr//bin//chromedriver");
		}
		dr = new ChromeDriver();
		dr.get(TestData.STAGE_URL);
		System.out.println("Automation Suite running in Envt : " + TestData.PROD_URL);
		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return dr;	
	}
	
	@BeforeSuite
	public void startSession() throws InterruptedException {
		dr = initializeDriver();
		Pages.consignmentPage().loginIntoApplication();	
	}

	@AfterSuite
	public void quitSession() {
		//dr.quit();
	}
	
	public String generateRandomEmail() {
		String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
		String emailID = "qaautotestso" + userName + "@sothebysqa.com";
		return emailID;
	}

	public static WebElement waitforElement(WebDriver dr, WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(dr, 80);
			return wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			Assert.fail("Unable to find Element on page: " + webElement);
			return null;
		} finally {
			dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}
	
	public static WebElement dynamicWait(WebDriver dr, WebElement webElement){
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(dr)                            
				.withTimeout(20, TimeUnit.SECONDS)          
				.pollingEvery(5, TimeUnit.SECONDS)          
				.ignoring(NoSuchElementException.class);    

		WebElement aboutMe =  wait.until(new Function<WebDriver, WebElement>() {       
			public WebElement apply(WebDriver driver) { 
				return driver.findElement(By.id("about_me"));     
				 }  
				});        
				return aboutMe;   
		
	}
	
	/*XSSFWorkbook wb ;
	XSSFSheet sheet;
	
	
	public void excelDataConfig(String excelPath) {
		
		try {
			File src  = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getNumOfRows(String sheetname){
		sheet = wb.getSheet(sheetname);
		int num_row = sheet.getLastRowNum();
		return num_row;
		
	}
	
	public String getData(String sheetname, int row, int column){
		sheet = wb.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
	public void writeData(String sheetname, int row, int column, String src1){
		sheet = wb.getSheet(sheetname);
		sheet.getRow(row).createCell(column).setCellValue("Pass");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(src1);
			wb.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeExcel() throws IOException{
		wb.close();
	}*/
		

	

	@AfterMethod
	public void afterMethodInvocation(ITestResult testResult, Method m) {
		if(testResult.isSuccess()){
			System.out.println("***** " + m.getName() + " ***** PASSED *****");
			}else{
				System.out.println("***** " + m.getName() + " ***** FAILED *****");	
			}
	}
	
	public ArrayList<String> getArrayItems(List<WebElement> e) {
		ArrayList<String> Actual_list = new ArrayList<String>();
		for (WebElement arr : e) {
			Actual_list.add(arr.getText());
			//System.out.println(Actual_list);
		}
		return Actual_list;
	}
	
	public int generateRandomNumber(){
		Random rnd = new Random();
		int n = 1000 + rnd.nextInt(9000);
		return n;
	}
	

	  
	
	
	

}
