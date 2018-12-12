package admin.sothelabs.testCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Test;

import admin.sothelabs.pageObjectFactory.Pages;
import admin.sothelabs.testUtils.SetupUtils;

public class CreateObject extends SetupUtils{
	
	protected String title = "TestObject-" + RandomStringUtils.randomAlphanumeric(10);
	
	@Test(priority = 1, enabled = true)
	public void createNewObject() throws InterruptedException{
		Assert.assertEquals(Pages.consignmentPage().newButton.getText(), "NEW");
		Pages.consignmentPage().newButton.click();
		waitforElement(dr, Pages.consignmentPage().newButton);
		Pages.objectPage().sidebarMenuObject.click();
		waitforElement(dr, Pages.objectPage().titleOfWork);
		Pages.objectPage().titleOfWork.sendKeys(title);
		Pages.objectPage().englishTitle.sendKeys("test");
		Pages.objectPage().creatorListBox.sendKeys("Peter Doig"+ Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().descriptionTextEdit.sendKeys("test"+Keys.ENTER);
		//Thread.sleep(5000);
		//WebElement UploadImg = dr.findElement(By.xpath("//input[@type = 'file']"));
		Pages.objectPage().uploadImage.sendKeys("//Users//priya.ganesan//Documents//Browsers//abstract-art.jpg");
		Thread.sleep(2000);
		//-----------------Details---------------------
		Select dropdown_gender = new Select(Pages.objectPage().objectDropdown);
		dropdown_gender.selectByVisibleText("Generic");
		//Pages.objectPage().serialTextEdit.sendKeys("125678");
		Thread.sleep(2000);
		
		//---------------Attributes---------------------
		Pages.objectPage().provenanceTextEdit.sendKeys("test"+Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().exhibitionTextEdit.sendKeys("test"+Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().literatureTextEdit.sendKeys("test"+Keys.ENTER);
		Thread.sleep(2000);
		/*Pages.objectPage().dimensionTextEdit.sendKeys("test");
		
		Pages.objectPage().materialsListBox.sendKeys("acrylic paint"+Keys.ENTER);
		Pages.objectPage().heightTextEdit.sendKeys("111");
		Select height_dropdown = new Select(Pages.objectPage().heightDropdown);
		height_dropdown.selectByVisibleText("cm");
		Pages.objectPage().widthTextEdit.sendKeys("111");
		Select width_dropdown = new Select(Pages.objectPage().widthDropdown);
		width_dropdown.selectByVisibleText("mm");
		Pages.objectPage().depthTextEdit.sendKeys("111");
		Select depth_dropdown = new Select(Pages.objectPage().depthDropdown);
		depth_dropdown.selectByVisibleText("cm");
		Pages.objectPage().lengthTextEdit.sendKeys("111");
		Select length_dropdown = new Select(Pages.objectPage().lengthDropdown);
		length_dropdown.selectByVisibleText("cm");
		
		Pages.objectPage().diameterTextEdit.sendKeys("111");
		Select diameter_dropdown = new Select(Pages.objectPage().diameterDropdown);
		diameter_dropdown.selectByVisibleText("cm");
		
		Pages.objectPage().weightTextEdit.sendKeys("111");
		Select weight_dropdown = new Select(Pages.objectPage().weightDropdown);
		weight_dropdown.selectByVisibleText("kg");
		
		Pages.objectPage().countryListBox.sendKeys("India"+Keys.ENTER);
		
		Pages.objectPage().signatureDetailsTextEdit.sendKeys("test");
		
		
		Pages.objectPage().GenreListBox.sendKeys("Himalayan"+Keys.ENTER);
		
		//----------Research section--------------
		
		Pages.objectPage().yearTextEdit.sendKeys("1800");
		Select date_unit_dropdown = new Select(Pages.objectPage().unitDropdown);
		date_unit_dropdown.selectByValue("AD");
		Thread.sleep(2000);*/
		Pages.objectPage().createButton.click();
		Thread.sleep(5000);
		Assert.assertTrue(Pages.objectPage().titleOfWorkValue.getText().contains(title));
		System.out.println("Object Created successfully as  - " + title);
	}
	
	
	@Test(priority = 2, enabled = true)
	public void editAndSaveObject() throws InterruptedException{
		Thread.sleep(5000);
		dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.objectPage().navItemObject);
		Pages.objectPage().navItemObject.click();
		Pages.consignmentPage().searchField.sendKeys(title);
		Pages.consignmentPage().searchSubmitButton.click();
		Pages.consignmentPage().searchResultItem.click();
		
		String title_edit = Pages.objectPage().titleOfWorkValue.getText();
		String english_title_edit = Pages.objectPage().englishTitleValue.getText();
		String creator_edit = "PALMER";
		String description_edit = Pages.objectPage().descriptionValue.getText()+"-edit";
		String provenance_edit = Pages.objectPage().provenanceValue.getText()+"-edit";
		String exhibition_edit = Pages.objectPage().exhibitionValue.getText()+"-edit";
		String literature_edit = Pages.objectPage().LiteratureValue.getText()+"-edit";
		Pages.consignmentPage().editButton.click();
		Thread.sleep(2000);
		Pages.objectPage().titleOfWork.sendKeys("-edit");
		Pages.objectPage().englishTitle.sendKeys("-edit");
//		Pages.objectPage().creatorListBox.sendKeys(creator_edit+ Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().descriptionTextEdit.clear();
		Pages.objectPage().descriptionTextEdit.sendKeys(description_edit+Keys.ENTER);
		//---------------Attributes---------------------
		Thread.sleep(2000);
		Pages.objectPage().provenanceTextEdit.clear();
		Pages.objectPage().provenanceTextEdit.sendKeys(provenance_edit+Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().exhibitionTextEdit.clear();
		Pages.objectPage().exhibitionTextEdit.sendKeys(exhibition_edit+Keys.ENTER);
		Thread.sleep(2000);
		Pages.objectPage().literatureTextEdit.clear();
		Pages.objectPage().literatureTextEdit.sendKeys(literature_edit+Keys.ENTER);
		Thread.sleep(2000);
		/*Pages.objectPage().dimensionTextEdit.clear();
		Pages.objectPage().dimensionTextEdit.sendKeys("test");
		
		Pages.objectPage().materialsListBox.sendKeys("acrylic paint"+Keys.ENTER);
		Pages.objectPage().heightTextEdit.sendKeys("111");
		Select height_dropdown = new Select(Pages.objectPage().heightDropdown);
		height_dropdown.selectByVisibleText("cm");
		Pages.objectPage().widthTextEdit.sendKeys("111");
		Select width_dropdown = new Select(Pages.objectPage().widthDropdown);
		width_dropdown.selectByVisibleText("mm");
		Pages.objectPage().depthTextEdit.sendKeys("111");
		Select depth_dropdown = new Select(Pages.objectPage().depthDropdown);
		depth_dropdown.selectByVisibleText("cm");
		Pages.objectPage().lengthTextEdit.sendKeys("111");
		Select length_dropdown = new Select(Pages.objectPage().lengthDropdown);
		length_dropdown.selectByVisibleText("cm");
		
		Pages.objectPage().diameterTextEdit.sendKeys("111");
		Select diameter_dropdown = new Select(Pages.objectPage().diameterDropdown);
		diameter_dropdown.selectByVisibleText("cm");
		
		Pages.objectPage().weightTextEdit.sendKeys("111");
		Select weight_dropdown = new Select(Pages.objectPage().weightDropdown);
		weight_dropdown.selectByVisibleText("kg");
		Pages.objectPage().countryListBox.sendKeys("India"+Keys.ENTER);
		Pages.objectPage().signatureDetailsTextEdit.sendKeys("test");
		Pages.objectPage().GenreListBox.sendKeys("Himalayan"+Keys.ENTER);
		//----------Research section--------------
		
		Pages.objectPage().yearTextEdit.sendKeys("1800");
		Select date_unit_dropdown = new Select(Pages.objectPage().unitDropdown);
		date_unit_dropdown.selectByValue("AD");*/
		Thread.sleep(2000);
		Pages.consignmentPage().saveButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(Pages.objectPage().titleOfWorkValue.getText(), title_edit+"-edit");
		Assert.assertEquals(Pages.objectPage().englishTitleValue.getText(), english_title_edit+"-edit");
		//Assert.assertEquals(Pages.objectPage().creatorValue.getText(), creator_edit);
		Assert.assertEquals(Pages.objectPage().descriptionValue.getText(), description_edit);
		Assert.assertEquals(Pages.objectPage().provenanceValue.getText(), provenance_edit);
		Assert.assertEquals(Pages.objectPage().exhibitionValue.getText(), exhibition_edit);
		Assert.assertEquals(Pages.objectPage().LiteratureValue.getText(), literature_edit);	
		
	}
	
	
	
	
		
		
		

		

//		getNumOfRows("CreateObject")
//		for(int i=876; i <= getNumOfRows("CreateObject") ; i++){
//			String data = getData("CreateObject", i , 0);
//			dr.findElement(By.xpath("//input[@placeholder = 'Title of work']")).sendKeys(data);
//
//			WebElement dropdown = dr.findElement(By.xpath("//input[@placeholder = 'Creator']/ancestor::div[@class = 'sc-ckVGcZ dtZFfk sc-kAzzGY cCHKYQ']"));
//			Actions actions = new Actions(dr);
//			actions.moveToElement(dropdown).click();
//			Thread.sleep(1000);
//			actions.sendKeys(getData("CreateObject", i , 1));
//			actions.sendKeys(Keys.ENTER);
//			actions.build().perform();
//			Thread.sleep(1000);
//			dr.findElement(By.xpath("//div[@data-placeholder = 'Description']")).sendKeys(getData("CreateObject", i , 2));
//			
//			js.executeScript("scroll(0,250);");
//
//			//dr.findElement(By.xpath("//div[@data-placeholder = 'Description']")).sendKeys(Keys.ENTER);
//			//webdriver.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
//			Thread.sleep(1000);
//			Select dropdown_gender = new Select(dr.findElement(By.xpath("//select[@name = 'select']")));
//			dropdown_gender.selectByVisibleText("Generic");
//			Thread.sleep(3000);
//			
//			
//			
//			dr.findElement(By.xpath("//div[@data-placeholder = 'Provenance']")).sendKeys(getData("CreateObject", i , 10));
//			dr.findElement(By.xpath("//div[@data-placeholder = 'Provenance']")).sendKeys(Keys.ENTER);
//			Thread.sleep(1000);
//			
//			dr.findElement(By.xpath("//div[@data-placeholder = 'Exhibition']")).sendKeys(getData("CreateObject", i , 9));
//			//dr.findElement(By.xpath("//div[@data-placeholder = 'Exhibition']")).sendKeys(Keys.ENTER);
//			Thread.sleep(1000);
//			dr.findElement(By.xpath("//div[@data-placeholder = 'Literature']")).sendKeys(getData("CreateObject", i , 7));
//			//dr.findElement(By.xpath("//div[@data-placeholder = 'Literature']")).sendKeys(Keys.ENTER);
//			Thread.sleep(1000);
//			
//			dr.findElement(By.xpath("//input[@placeholder = 'Executed In']")).sendKeys(getData("CreateObject", i , 8));
//			//dr.findElement(By.xpath("//input[@placeholder = 'Executed In']")).sendKeys(Keys.ENTER);
//			
//			Thread.sleep(1000);
//			dr.findElement(By.xpath("//button[contains(text(), 'Create')]")).click();
//
//			if(dr.findElements(By.xpath("//button[contains(text(), 'Edit')]")).size() > 0){
//				writeData("CreateObject", i, 11, "//Users//priya.ganesan//Documents//ExcelSheet//Workbook3.xlsx");
//			}else{
//				System.out.println("Fails at creator : " + data);
//			}
//
//			System.out.println(data);
//			Thread.sleep(3000);
//			dr.findElement(By.xpath("//img[@class = 'logo']")).click();
//			Thread.sleep(2000);
//			waitforElement(dr,dr.findElement(By.xpath("//button[@class = 'sc-gPzReC kbNpvG']")));
//			dr.findElement(By.xpath("//button[@class = 'sc-gPzReC kbNpvG']")).click();
//			waitforElement(dr, dr.findElement(By.xpath("//ul/li/a[contains(@href, 'creators/new')]")));
//			dr.findElement(By.xpath("//ul/li/a[contains(@href, '/objects/new')]")).click();
//			Thread.sleep(2000);
//
//		}
	

}
