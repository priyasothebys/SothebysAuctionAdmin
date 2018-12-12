package admin.sothelabs.pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectPageElements {
	
	@FindBy(xpath = "//a[contains(@href, '/objects/new')]")
	public WebElement sidebarMenuObject;
	
	@FindBy(xpath = "//input[@placeholder = 'Title of work']")
	public WebElement titleOfWork;
	
	@FindBy(xpath = "//input[@placeholder = 'English title']")
	public WebElement englishTitle;
	
	@FindBy(xpath = "//input[@placeholder = 'Creator']")//input[@placeholder = 'Creator']/ancestor::div[@class = 'sc-dxgOiQ hbPIWe sc-cSHVUG dQvtQT']")
	public WebElement creatorListBox;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Description']")
	public WebElement descriptionTextEdit;
	
	@FindBy(xpath = "//select[@name = 'select']")
	public WebElement objectDropdown;
	
	@FindBy(xpath = "//div[contains(text(), 'Serial')]/parent::div/following-sibling::div/div/input")
	public WebElement serialTextEdit;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Provenance']")
	public WebElement provenanceTextEdit;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Exhibition']")
	public WebElement exhibitionTextEdit;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Literature']")
	public WebElement literatureTextEdit;
	
	@FindBy(xpath = "//input[@type = 'file']")
	public WebElement uploadImage;
	
	@FindBy(xpath = "//input[@placeholder = 'Dimension text']")
	public WebElement dimensionTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Materials']")
	public WebElement materialsListBox;
	
	@FindBy(xpath = "//input[@placeholder = 'Country']")
	public WebElement countryListBox;
	
	@FindBy(xpath = "//input[@placeholder = 'Genre']")
	public WebElement GenreListBox;
	
	@FindBy(xpath = "//div[@data-placeholder = 'Signature Details']")
	public WebElement signatureDetailsTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Height']")
	public WebElement heightTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Height']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement heightDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Width']")
	public WebElement widthTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Width']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement widthDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Depth']")
	public WebElement depthTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Depth']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement depthDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Length']")
	public WebElement lengthTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Length']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement lengthDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Diameter']")
	public WebElement diameterTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Diameter']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement diameterDropdown;
	
	@FindBy(xpath = "//input[@placeholder = 'Weight']")
	public WebElement weightTextEdit;
	
	@FindBy(xpath = "//input[@placeholder = 'Weight']/ancestor::div[@class = 'sc-eLExRp DfgCq']/following-sibling::div/div/select")
	public WebElement weightDropdown;
	
	@FindBy(xpath = "//input[@id = 'year']")
	public WebElement yearTextEdit;
	
	@FindBy(xpath = "//select[@id = 'unit']")
	public WebElement unitDropdown;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	public WebElement createButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Title of work')]/parent::div/following-sibling::div")
	public WebElement titleOfWorkValue;
	
	@FindBy(xpath = "//a[@class = 'navLink'][@href ='/objects']")
	public WebElement navItemObject;
	
	@FindBy(xpath = "//div[contains(text(), 'English title')]/parent::div/following-sibling::div")
	public WebElement englishTitleValue;
	
	@FindBy(xpath = "//div[contains(text(), 'Creator')]/parent::div/following-sibling::div")
	public WebElement creatorValue;
	
	@FindBy(xpath = "//div[contains(text(), 'Description')]/parent::div/following-sibling::div")
	public WebElement descriptionValue;
	
	@FindBy(xpath = "//div[contains(text(), 'Provenance')]/parent::div/following-sibling::div/div/div/p")
	public WebElement provenanceValue;
	
	@FindBy(xpath = "//div[contains(text(), 'Exhibition')]/parent::div/following-sibling::div/div/div/p")
	public WebElement exhibitionValue;
	
	@FindBy(xpath = "//div[contains(text(), 'Literature')]/parent::div/following-sibling::div/div/div/p")
	public WebElement LiteratureValue;
	
//	@FindBy(xpath = "//div[contains(text(), 'English title')]/parent::div/following-sibling::div")
//	public WebElement englishTitleValue;
//	
//	@FindBy(xpath = "//div[contains(text(), 'English title')]/parent::div/following-sibling::div")
//	public WebElement englishTitleValue;
//	
	
	

}
