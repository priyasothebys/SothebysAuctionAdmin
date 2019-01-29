package admin.sothelabs.pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectPageElements {
	
	@FindBy(xpath = "//a[contains(@href, '/objects/new')]")
	public WebElement sidebarMenuObject;
	
	@FindBy(xpath = "//input[@placeholder = 'Title of Work']")
	public WebElement titleOfWork;
	
	@FindBy(xpath = "//input[@placeholder = 'English Title']")
	public WebElement englishTitle;
	
	@FindBy(xpath = "//input[@placeholder = 'Creator']")//input[@placeholder = 'Creator']/ancestor::div[@class = 'sc-dxgOiQ hbPIWe sc-cSHVUG dQvtQT']")
	public WebElement creatorListBox;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Description...']")
	public WebElement descriptionTextEdit;
	
	@FindBy(xpath = "//select[@name = 'select']")
	public WebElement objectDropdown;
	
//	@FindBy(xpath = "//div[contains(text(), 'Serial')]/parent::div/following-sibling::div/div/input")
//	public WebElement serialTextEdit;
	
	@FindBy(xpath = "//label[contains(text(), 'Provenance')]/parent::div/following-sibling::div/div/div/div[2]/div")
	public WebElement provenanceInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Exhibition')]/parent::div/following-sibling::div/div/div/div[2]/div")
	public WebElement exhibitionInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Literature')]/parent::div/following-sibling::div/div/div/div[2]/div")
	public WebElement literatureInput;
	
	@FindBy(xpath = "//input[@type = 'file']")
	public WebElement uploadImage;
	
	@FindBy(xpath = "//input[@placeholder = 'Dimension text']")
	public WebElement dimensionInput;
	
	@FindBy(xpath = "//input[@placeholder = 'Materials']")
	public WebElement materialsListBox;
	
	@FindBy(xpath = "//input[@placeholder = 'Country']")
	public WebElement countryListBox;
	
	@FindBy(xpath = "//input[@placeholder = 'Genre']")
	public WebElement GenreListBox;
	
	@FindBy(xpath = "//label[contains(text(), 'Signature Details')]/parent::div/following-sibling::div/div/div/div[2]/div")
	public WebElement signatureDetailsInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Height')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement heightInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Height')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement heightDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Width')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement widthInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Width')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement widthDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Depth')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement depthInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Depth')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement depthDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Length')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement lengthInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Length')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement lengthDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Diameter')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement diameterInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Diameter')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement diameterDropdown;
	
	@FindBy(xpath = "//label[contains(text(), 'Weight')]/parent::div/following-sibling::div/div/div[2]/input")
	public WebElement weightInput;
	
	@FindBy(xpath = "//label[contains(text(), 'Weight')]/parent::div/following-sibling::div/div/div/div/div/select")
	public WebElement weightDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Year']")
	public WebElement yearInput;
	
	@FindBy(xpath = "//div[@id = 'dateCreatedFrom']/div/div/div/select")
	public WebElement unitDropdown;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	public WebElement createButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Title of work')]/following-sibling::span")
	public WebElement titleOfWorkValue;
	
	@FindBy(xpath = "//a[@class = 'navLink'][@href ='/objects']")
	public WebElement navItemObject;
	
	@FindBy(xpath = "//span[contains(text(), 'English title')]/following-sibling::span")
	public WebElement englishTitleValue;
	
	@FindBy(xpath = "//span[contains(text(), 'Creator')]/following-sibling::span")
	public WebElement creatorValue;
	
	@FindBy(xpath = "//span[contains(text(), 'Description')]/following-sibling::span")
	public WebElement descriptionValue;
	
	@FindBy(xpath = "//span[contains(text(), 'Provenance')]/following-sibling::span/div/div/p")
	public WebElement provenanceValue;
	
	@FindBy(xpath = "//span[contains(text(), 'Exhibition')]/following-sibling::span/div/div/p")
	public WebElement exhibitionValue;
	
	@FindBy(xpath = "//span[contains(text(), 'Literature')]/following-sibling::span/div/div/p")
	public WebElement LiteratureValue;
	


}
