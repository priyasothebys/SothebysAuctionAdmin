package admin.sothelabs.pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuctionPageElements {
	
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
	
	@FindBy(xpath = "//div[contains(text(), 'New York (USD)')]")
	public WebElement bidIncrementItem;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Conditions Of Sale']")
	public WebElement conditionTextEdit;
	
	@FindBy(xpath = "//a[@class = 'navLink'][@href ='/auctions']")
	public WebElement navItemAuction;
	
	
	
	
	
	

}
