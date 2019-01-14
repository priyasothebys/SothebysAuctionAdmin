package admin.sothelabs.pageObjectFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import admin.sothelabs.testUtils.SetupUtils;

public class AuctionPageElements extends SetupUtils {

	@FindBy(xpath = "//a[@href = '/auctions/timed/new']")
	public WebElement sidebarMenuTimedAuction;

	@FindBy(xpath = "//input[@placeholder = 'Title']")
	public WebElement titleTextEdit;

	@FindBy(xpath = "//input[@placeholder = 'Location']")
	public WebElement locationListBox;

	@FindBy(xpath = "//input[@placeholder = 'Sale Number']")
	public WebElement SaleNumTextEdit;

	@FindBy(xpath = "//input[@placeholder = 'Department']")
	public WebElement departmentListBox;

	@FindBy(xpath = "//div[@data-placeholder = 'Overview']")
	public WebElement overviewTextEdit;

	@FindBy(xpath = "//div[@class = 'sc-cSHVUG dQvtQT']")
	public WebElement bidIncrementListBox;

	@FindBy(xpath = "//div[contains(text(), 'Online only (CNY)')]")
	public WebElement bidIncrementItem;

	@FindBy(xpath = "//div[@data-placeholder = 'Conditions Of Sale']")
	public WebElement conditionTextEdit;

	@FindBy(xpath = "//a[@class = 'navLink'][@href ='/auctions']")
	public WebElement navItemAuction;
	
	@FindBy(xpath = "//input[@id = 'start']")
	public WebElement startDate;
	
	@FindBy(xpath = "//span[@class = 'rc-time-picker datetime']")
	public WebElement startTimePicker;
	
	@FindBy(xpath = "//html/body/div[2]/div/div/div/div[2]/div[1]/ul/li")
	public List<WebElement> startHourPicker;
	
	@FindBy(xpath = "//html/body/div[2]/div/div/div/div[2]/div[2]/ul/li")
	public List<WebElement> startMinutePicker;
	
	@FindBy(xpath = "//html/body/div[2]/div/div/div/div[2]/div[3]/ul/li")
	public List<WebElement> startMeredianPicker;

	@FindBy(xpath = "//input[@id = 'end']")
	public WebElement endDate;
	
	@FindBy(xpath = "//span[@class = 'rc-time-picker ']")
	public WebElement endTimePicker;
//	@FindBy(xpath = "//input[@id= 'end']/ancestor::div[@class = 'sc-hEsumM fMhkjF']/following-sibling::span/div/span/input")
//	public WebElement endTimePicker;
	
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div[2]/div[1]/ul/li")
	public List<WebElement> endHourPicker;
	
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div[2]/div[2]/ul/li")
	public List<WebElement> endMinutePicker;
	
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div[2]/div[3]/ul/li")
	public List<WebElement> endMeredianPicker;
	
	@FindBy(xpath = "//a[contains(text(), 'Details')]")
	public WebElement detailsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Lots')]")
	public WebElement lotsLink;
	
	@FindBy(xpath = "//div[contains(text( ),'Title')]/parent::div[@class = 'col-xs-3']/following-sibling::div")
	public WebElement auctionTitleLabel;
	
	@FindBy(xpath = "//button[contains(text(), 'Publish Auction')]")
	public WebElement publishButton;
	
	@FindBy(xpath = "//button[@data-test-id = 'confirm-action']")
	public WebElement confirmPublishButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Published')]")
	public WebElement publishStatus;

	public void enterStartAndEndTime() throws InterruptedException {
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String start_date = format.format(curDate);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 2); // Adding 1 days
		String end_date = format.format(c.getTime());
		curDate.setTime(curDate.getTime() + 10 * 60000);// add 10 mins to current time
		format = new SimpleDateFormat("hh");
		String hour = format.format(curDate);
		format = new SimpleDateFormat("mm");
		String min = format.format(curDate);
		format = new SimpleDateFormat("a");
		String meredian = format.format(curDate);//AM or PM
		startDate.sendKeys(start_date + Keys.ENTER);
		Thread.sleep(500);
		startTimePicker.click();
		Thread.sleep(1000);
		selectElementFromList(startHourPicker, hour);
		selectElementFromList(startMinutePicker, min);
		selectElementFromList(startMeredianPicker, meredian);
		Thread.sleep(1000);
//		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", Pages.auctionPage().endDate);
//		Thread.sleep(500);
		endDate.sendKeys(end_date + Keys.ENTER);
		Thread.sleep(2000);
		endTimePicker.click();
		Thread.sleep(1000);
		selectElementFromList(endHourPicker, hour);
		selectElementFromList(endMinutePicker, min);
		selectElementFromList(endMeredianPicker, meredian);
		Thread.sleep(1000);
	}

	public void selectElementFromList(List<WebElement> list, String item) {
		// List<WebElement> hour_list =
		// dr.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li"));
		for (WebElement li : list) {
			if (li.getText().contains(item)) {
				li.click();
			}
		}
	}

}
