package admin.sothelabs.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import admin.sothelabs.pageObjectFactory.Pages;
import admin.sothelabs.testUtils.SetupUtils;
import admin.sothelabs.testUtils.TestData;

public class Consignment extends SetupUtils {
	
	protected String consignment_title = "QA Automation+"+RandomStringUtils.randomAlphanumeric(8);

	@Test(priority = 1, enabled = true)
	public void createNewConsignment() throws InterruptedException, IOException {
		Assert.assertEquals(Pages.consignmentPage().newButton.getText(), "NEW");
		Pages.consignmentPage().newButton.click();
		waitforElement(dr, Pages.consignmentPage().sidebarMenuConsignment);
		Pages.consignmentPage().sidebarMenuConsignment.click();
		Assert.assertTrue(dr.findElement(By.xpath("//h1[contains(text(), 'New Consignment')]")).isDisplayed());
		Pages.consignmentPage().consignorName.sendKeys(TestData.CONSIGNOR_NAME);
		Pages.consignmentPage().accountID.sendKeys(TestData.ACCOUNTID);
		Select title_dropdown = new Select(Pages.consignmentPage().ownerTypeDropdown);
		title_dropdown.selectByVisibleText("Executor");
		Actions actions = new Actions(dr);
		actions.moveToElement(Pages.consignmentPage().sourceOfficeDropdown).click();
		Thread.sleep(1000);
		actions.sendKeys(TestData.SOURCE_OFFICE);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		Pages.consignmentPage().consignmentTitle.sendKeys(consignment_title);
		Pages.consignmentPage().consignmentNotes.sendKeys(TestData.NOTES);	
		System.out.println("Consignment is successfully created : " + consignment_title);
		Thread.sleep(5000);

		((JavascriptExecutor)dr).executeScript("window.scrollTo(0,"+Pages.objectPage().createButton.getLocation().x+")");
		Pages.objectPage().createButton.click();
		//System.out.println(Pages.objectPage().createButton.getAttribute("class"));
		//Pages.objectPage().createButton.click();
		//dr.findElement(By.xpath("//button[@class = 'css-pl457e css-1bljni8 css-z2namt']")).click();
		//actions.moveToElement(Pages.objectPage().createButton).click().build().perform();
		//dr.findElement(By.xpath("//div[@class = 'css-1gfzdq7']")).click();
		Thread.sleep(5000);
		//Pages.consignmentPage().createButton.click();
		//------------Verify newly created consignment data values-------------
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME);
		Assert.assertEquals(Pages.consignmentPage().consignorNameValue.getText(), TestData.CONSIGNOR_NAME);
		Assert.assertEquals(Pages.consignmentPage().accountIDValue.getText(), TestData.ACCOUNTID);
		Assert.assertEquals(Pages.consignmentPage().ownerTypeValue.getText(), TestData.OWNDERTYPE);
		Assert.assertTrue(Pages.consignmentPage().sourceOfficeValue.getText().contains(TestData.SOURCE_OFFICE));
		Assert.assertEquals(Pages.consignmentPage().consignmentTitleValue.getText(), consignment_title);
		Assert.assertEquals(Pages.consignmentPage().consignmentNotesValue.getText(), TestData.NOTES);
		System.out.println("Consignment is successfully created : " + consignment_title);
	}
	
	@Test(priority = 2, enabled = true)
	public void editConsignment() throws InterruptedException, IOException {
		Thread.sleep(2000);
		/*dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.consignmentPage().navItemConsignment);
		Pages.consignmentPage().navItemConsignment.click();
		Pages.consignmentPage().searchField.sendKeys(consignment_title);
		Pages.consignmentPage().searchSubmitButton.click();
		Pages.consignmentPage().searchResultItem.click();*/
		String consignor_name_edit = Pages.consignmentPage().consignorNameValue.getText()+" edit";
		String account_id_edit = Pages.consignmentPage().accountIDValue.getText()+" edit";
		String owner_type_edit = "Owner";
		String consignment_title_edit = Pages.consignmentPage().consignmentTitleValue.getText()+" edit";
		String consignment_notes_edit = Pages.consignmentPage().consignmentNotesValue.getText()+" edit";
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME);
		Pages.consignmentPage().editButton.click();
		Pages.consignmentPage().consignorName.clear();
		Pages.consignmentPage().consignorName.sendKeys(consignor_name_edit);
		Pages.consignmentPage().accountID.clear();
		Pages.consignmentPage().accountID.sendKeys(account_id_edit);
		Select title_dropdown = new Select(Pages.consignmentPage().ownerTypeDropdown);
		title_dropdown.selectByVisibleText(owner_type_edit);
		Actions actions = new Actions(dr);		
		actions.moveToElement(dr.findElement(By.xpath("//div[@class = 'sc-kGXeez gddReB']"))).click();
		Thread.sleep(2000);
		actions.sendKeys("Abu");
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		Pages.consignmentPage().consignmentTitle.clear();
		Pages.consignmentPage().consignmentTitle.sendKeys(consignment_title_edit);
		Pages.consignmentPage().consignmentNotes.clear();
		Pages.consignmentPage().consignmentNotes.sendKeys(consignment_notes_edit);
		Pages.consignmentPage().saveButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), consignor_name_edit);
		Assert.assertEquals(Pages.consignmentPage().consignorNameValue.getText(), consignor_name_edit);
		Assert.assertEquals(Pages.consignmentPage().accountIDValue.getText(), account_id_edit);
		Assert.assertEquals(Pages.consignmentPage().ownerTypeValue.getText(), owner_type_edit);
		Assert.assertTrue(Pages.consignmentPage().sourceOfficeValue.getText().contains(TestData.SOURCE_OFFICE));
		Assert.assertEquals(Pages.consignmentPage().consignmentTitleValue.getText(), consignment_title_edit);
		Assert.assertEquals(Pages.consignmentPage().consignmentNotesValue.getText(), consignment_notes_edit);
		System.out.println("Successfully saved the edited consignemnt fields");
	}
	
	
	@Test(priority = 3, enabled = true)
	public void addObjectsToConsignment() throws InterruptedException, IOException {
		Thread.sleep(1000);
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.consignmentPage().navItemConsignment);
		Pages.consignmentPage().navItemConsignment.click();
		Pages.consignmentPage().searchField.sendKeys(consignment_title);
		Pages.consignmentPage().searchSubmitButton.click();
		Thread.sleep(2000);
		Pages.consignmentPage().searchResultItem.click();
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME+" edit");
		dr.findElement(By.xpath("//a[contains(text(), 'Properties')]")).click();
		dr.findElement(By.xpath("//a[contains(text(), 'New Property')]")).click();
		Assert.assertEquals(dr.findElement(By.xpath("//h1[@class = 'css-1cbuwhv']")).getText(), "Add Property");
		dr.findElement(By.xpath("//input[@placeholder = 'Search']")).sendKeys("QA Test Object");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//div[@class = 'css-17pn9uc']/h4[contains(text(),'Test Object')]")).click();
		dr.findElement(By.xpath("//input[@placeholder = 'Object type']/ancestor::div[@class = 'sc-cSHVUG sc-dxgOiQ cFmSFh']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//span[contains(text(), 'Fine Art')]")).click();
		Pages.auctionPage().departmentListBox.sendKeys("Contemporary Art"+Keys.ENTER);
		Thread.sleep(1000);
		dr.findElement(By.xpath("//input[@placeholder = 'Sale location']")).sendKeys("New York"+Keys.ENTER);
		Thread.sleep(2000);
		Select currency_dropdown = new Select(dr.findElement(By.xpath("//select[@name = 'currency']")));
		currency_dropdown.selectByVisibleText("USD");
		Assert.assertTrue(dr.findElement(By.xpath("//label[@for = 'estimate']/parent::div/following-sibling::div/div/div[contains(text(),'USD')]")).isDisplayed());
		dr.findElement(By.xpath("//input[@label = 'Estimatelow']")).sendKeys("200");
		dr.findElement(By.xpath("//input[@label = 'Estimatehigh']")).sendKeys("1000");
		dr.findElement(By.xpath("//input[@label = 'reserve']")).sendKeys("200");
		Pages.consignmentPage().createButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(dr.findElement(By.xpath("//div[contains(text(), 'QA Automation')]/ancestor::a[contains(@href, '/properties')]")).isDisplayed());
		//Assert.assertEquals(dr.findElement(By.xpath("//div[contains(text(), 'Total Properties')]/following-sibling::div/h1")).getText(), "1");	
	}
	@Test(priority = 4, enabled = true)
	public void removeObjectsFromConsignment() throws InterruptedException, IOException {
		Thread.sleep(1000);
		Pages.consignmentPage().sothebysLogo.click();
		Pages.consignmentPage().navItemConsignment.click();
		Pages.consignmentPage().searchField.sendKeys(consignment_title);
		Pages.consignmentPage().searchSubmitButton.click();
		Thread.sleep(2000);
		Pages.consignmentPage().searchResultItem.click();
		dr.findElement(By.xpath("//a[contains(text(), 'Properties')]")).click();
		Assert.assertEquals(dr.findElement(By.xpath("//div[contains(text(), 'Total Properties')]/following-sibling::div/h1")).getText(), "1");
		dr.findElement(By.xpath("//tbody/tr/th")).click();
		dr.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		//Thread.sleep(2000);
		waitforElement(dr, dr.findElement(By.xpath("//h3[contains(text(), 'No Properties have been added to this Consignment')]")));
		Assert.assertTrue(dr.findElement(By.xpath("//h3[contains(text(), 'No Properties have been added to this Consignment')]")).isDisplayed());
	}	
	
}
