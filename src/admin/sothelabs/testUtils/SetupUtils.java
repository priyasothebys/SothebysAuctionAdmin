package admin.sothelabs.testUtils;


import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import com.gurock.testrail.ConnectToTestRail;
import admin.sothelabs.testUtils.TestData;

import admin.sothelabs.pageObjectFactory.Pages;

public class SetupUtils extends ConnectToTestRail {

	public String platform = System.getProperty("os.name");
	protected String envt;
	public static WebDriver dr;
	public Properties prop;

	public SetupUtils() {
		PageFactory.initElements(dr, this);
	}

	public WebDriver initializeDriver() throws InterruptedException {
		if (platform.equals("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver",
					"//Users//priya.ganesan//Documents//Browsers//chromedriver 2");
		} else {
			TestData.ENVT = System.getProperty("Environment");
			System.setProperty("webdriver.chrome.driver", "//usr//bin//chromedriver");
		}
		dr = new ChromeDriver();
		dr.get(TestData.STAGE_URL);
		System.out.println("Automation Suite running in Envt : " + TestData.STAGE_URL);
		dr.manage().window().setSize(new Dimension(1920, 1080));
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return dr;
	}

	public String imagePathBasedOnEnvt() {
		String path;
		if (platform.equals("Mac OS X")) {
			path = TestData.IMAGE_PATH_MAC;
		} else {
			path = TestData.IMAGE_PATH_LINUX;
		}
		return path;
	}

	@BeforeSuite
	public void startSession() throws InterruptedException {
		dr = initializeDriver();
		Pages.consignmentPage().loginIntoApplication();
		try {
			addNewRun(myClient());
		} catch (IOException | APIException e) {
			System.out.println("Failed to start the session");
			e.printStackTrace();
		}

	}

	public static APIClient myClient() {
		APIClient client;
		client = new APIClient(TestData.TESTRAIL_URL);
		client.setUser(TestData.TESTRAIL_USERNAME);
		client.setPassword(TestData.TESTRAIL_PASSWORD);
		return client;
	}

	@AfterSuite
	public void quitSession() {
		dr.quit();
		try {
			closeRun(myClient(), getRunID(myClient()));
		} catch (IOException | APIException e) {
			System.out.println("Failed to close the session");
			e.printStackTrace();
		}
	}

	public String generateRandomEmail() {
		String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
		String emailID = "qaautotestso" + userName + "@sothebysqa.com";
		return emailID;
	}

	public static WebElement waitforElement(WebDriver dr, WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(dr, 20);
			return wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			Assert.fail("Unable to find Element on page: " + webElement);
			return null;
		} finally {
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static WebElement dynamicWait(WebDriver dr, WebElement webElement) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(dr).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement aboutMe = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("about_me"));
			}
		});
		return aboutMe;

	}

	@AfterMethod
	public void afterMethodInvocation(ITestResult testResult, Method m)
			throws MalformedURLException, IOException, APIException {
		ITestResult result = testResult;
		if (testResult.isSuccess()) {
			System.out.println("***** " + m.getName() + " ***** PASSED *****");
			sendResultsToTestrail(myClient(), result, getRunID(myClient()), getCaseID(m));
		} else {
			System.out.println("***** " + m.getName() + " ***** FAILED *****");
			sendResultsToTestrail(myClient(), result, getRunID(myClient()), getCaseID(m));
		}
	}

	public ArrayList<String> getArrayItems(List<WebElement> e) {
		ArrayList<String> Actual_list = new ArrayList<String>();
		for (WebElement arr : e) {
			Actual_list.add(arr.getText());
			// System.out.println(Actual_list);
		}
		return Actual_list;
	}

	public int generateRandomNumber() {
		Random rnd = new Random();
		int n = 1000 + rnd.nextInt(9000);
		return n;
	}

}
