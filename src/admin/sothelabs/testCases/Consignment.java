package admin.sothelabs.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
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
		Pages.consignmentPage().createButton.click();
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
		Thread.sleep(5000);
		dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.consignmentPage().navItemConsignment);
		Pages.consignmentPage().navItemConsignment.click();
		Pages.consignmentPage().searchField.sendKeys(consignment_title);
		Pages.consignmentPage().searchSubmitButton.click();
		Pages.consignmentPage().searchResultItem.click();
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
	
	
	
}
