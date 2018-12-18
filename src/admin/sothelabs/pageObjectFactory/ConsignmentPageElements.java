package admin.sothelabs.pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import admin.sothelabs.testUtils.SetupUtils;
import admin.sothelabs.testUtils.TestData;

public class ConsignmentPageElements extends SetupUtils {
	
	@FindBy(xpath = "//input[@label = 'consignorName']")
	public WebElement consignorName;
	
	@FindBy(xpath = "//input[@label = 'accountId']")
	public WebElement accountID;
	
	@FindBy(xpath = "//select[@name = 'ownerType']")
	public WebElement ownerTypeDropdown;
	
	@FindBy(xpath = "//div[@id = 'react-autowhatever-1']")
	public WebElement sourceOfficeDropdown;
	
	@FindBy(xpath = "//input[@label = 'consignmentTitle']")
	public WebElement consignmentTitle;
	
	@FindBy(xpath = "//textarea[@label = 'consignmentNotes']")
	public WebElement consignmentNotes;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	public WebElement createButton;
	
	@FindBy(xpath = "//a[@href = '/consignments/new']")
	public WebElement sidebarMenuConsignment;
	
	////////////////////////////////////////// Login into Application page elements///////////////////
	
	@FindBy(xpath = "//input[@aria-label = 'login-email-id']")
	public WebElement emailAddress;
	
	@FindBy(xpath = "//input[@aria-label = 'login-password-id']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@id = 'login-button-id']")
	public WebElement loginButton;
	
	
	@FindBy(xpath = "//h1[contains(text(), \"Welcome to Sotheby's Admin\")]")
	public WebElement adminWelcomeHeader;
	
	@FindBy(xpath = "//button/span[contains(text(), 'New')]")
	public WebElement newButton;
	
	@FindBy(xpath = "//h1[@class = 'css-1cbuwhv']")
	public WebElement consignment_header;
	
	@FindBy(xpath = "//label[@for = 'consignorName']/parent::div/following-sibling::div/div")
	public WebElement consignorNameValue;
	
	@FindBy(xpath = "//label[@for = 'accountId']/parent::div/following-sibling::div/div")
	public WebElement accountIDValue;
	
	@FindBy(xpath = "//label[@for = 'ownerType']/parent::div/following-sibling::div/div")
	public WebElement ownerTypeValue;
	
	@FindBy(xpath = "//div[@class = 'sc-kEYyzF iNGUkE']/span")
	public WebElement sourceOfficeValue;
	
	@FindBy(xpath = "//label[@for = 'consignmentTitle']/parent::div/following-sibling::div/div")
	public WebElement consignmentTitleValue;
	
	@FindBy(xpath = "//label[@for = 'consignmentNotes']/parent::div/following-sibling::div")
	public WebElement consignmentNotesValue;
	
	@FindBy(xpath = "//img[@class = 'logo']")
	public WebElement sothebysLogo;
	
	@FindBy(xpath = "//a[@class = 'navLink'][@href ='/consignments']")
	public WebElement navItemConsignment;
	
	@FindBy(xpath = "//input[@type = 'search']")
	public WebElement searchField;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement searchSubmitButton;
	
	@FindBy(xpath = "//a[@class = 'table-row-wrap link']/div/div[2]")
	public WebElement searchResultItem;
	
	@FindBy(xpath = "//button[contains(text(), 'Edit')]")
	public WebElement editButton;

	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	public WebElement saveButton;
	
	public void loginIntoApplication(){
		emailAddress.sendKeys(TestData.USERNAME);
		password.sendKeys(TestData.PASSWORD);
		loginButton.click();
		waitforElement(dr, Pages.consignmentPage().adminWelcomeHeader);
		Assert.assertEquals(Pages.consignmentPage().adminWelcomeHeader.getText(), "Welcome to Sotheby's Admin");
	}

}
