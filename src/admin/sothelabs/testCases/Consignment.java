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

	protected String consignment_title = "QA Automation+" + RandomStringUtils.randomAlphanumeric(15);

	@Test(priority = 1, enabled = true)
	public void createNewConsignment() throws InterruptedException, IOException {
		Assert.assertEquals(Pages.consignmentPage().newButton.getText(), "NEW");
		Pages.consignmentPage().newButton.click();
		waitforElement(dr, Pages.consignmentPage().sidebarMenuConsignment);
		Pages.consignmentPage().sidebarMenuConsignment.click();
		waitforElement(dr, Pages.consignmentPage().newConsignemntHeader);
		Assert.assertTrue(Pages.consignmentPage().newConsignemntHeader.isDisplayed());
		Pages.consignmentPage().consignorName.sendKeys(TestData.CONSIGNOR_NAME);
		Pages.consignmentPage().accountID.sendKeys(TestData.ACCOUNTID);
		Thread.sleep(2000);
		Select title_dropdown = new Select(Pages.consignmentPage().ownerTypeDropdown);
		title_dropdown.selectByVisibleText("Executor");
		Pages.consignmentPage().consignmentTitle.sendKeys(consignment_title);
		Thread.sleep(1000);
		Actions actions = new Actions(dr);
		actions.moveToElement(Pages.consignmentPage().sourceOfficeDropdown).click();
		Thread.sleep(1000);
		actions.sendKeys(TestData.SOURCE_OFFICE);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		Thread.sleep(2000);
		Pages.consignmentPage().consignmentNotes.sendKeys(TestData.NOTES);
		Thread.sleep(1000);
		Pages.objectPage().createButton.click();
		// ------------Verify newly created consignment data values-------------
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
		String consignor_name_edit = Pages.consignmentPage().consignorNameValue.getText() + " edit";
		String account_id_edit = Pages.consignmentPage().accountIDValue.getText() + " edit";
		String owner_type_edit = "Owner";
		String consignment_title_edit = Pages.consignmentPage().consignmentTitleValue.getText() + " edit";
		String consignment_notes_edit = Pages.consignmentPage().consignmentNotesValue.getText() + " edit";
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME);
		Pages.consignmentPage().editButton.click();
		Pages.consignmentPage().consignorName.clear();
		Pages.consignmentPage().consignorName.sendKeys(consignor_name_edit);
		Pages.consignmentPage().accountID.clear();
		Pages.consignmentPage().accountID.sendKeys(account_id_edit);
		Select title_dropdown = new Select(Pages.consignmentPage().ownerTypeDropdown);
		title_dropdown.selectByVisibleText(owner_type_edit);
		Pages.consignmentPage().consignmentTitle.clear();
		Pages.consignmentPage().consignmentTitle.sendKeys(consignment_title_edit);
		Actions actions = new Actions(dr);
		actions.moveToElement(dr.findElement(By.xpath("//div[@class = 'sc-kGXeez gddReB']"))).click();
		Thread.sleep(2000);
		actions.sendKeys("Abu Dhabi");
		actions.sendKeys(Keys.ENTER).build().perform();;
		Pages.consignmentPage().consignmentNotes.clear();
		Pages.consignmentPage().consignmentNotes.sendKeys(consignment_notes_edit);
		Pages.consignmentPage().saveButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), consignor_name_edit);
		Assert.assertEquals(Pages.consignmentPage().consignorNameValue.getText(), consignor_name_edit);
		Assert.assertEquals(Pages.consignmentPage().accountIDValue.getText(), account_id_edit);
		Assert.assertEquals(Pages.consignmentPage().ownerTypeValue.getText(), owner_type_edit);
		Assert.assertTrue(Pages.consignmentPage().sourceOfficeValue.getText().contains("Abu Dhabi"));
		Assert.assertEquals(Pages.consignmentPage().consignmentTitleValue.getText(), consignment_title_edit);
		Assert.assertEquals(Pages.consignmentPage().consignmentNotesValue.getText(), consignment_notes_edit);
		System.out.println("Successfully saved the edited consignemnt fields");
	}

	@Test(priority = 3, enabled = true)
	public void addObjectsToConsignment() throws InterruptedException, IOException {
		waitforElement(dr, Pages.consignmentPage().sothebysLogo);
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.consignmentPage().navItemConsignment);
		Pages.consignmentPage().navItemConsignment.click();
		Pages.consignmentPage().searchField.sendKeys(consignment_title);
		Pages.consignmentPage().searchSubmitButton.click();
		Thread.sleep(2000);
		Pages.consignmentPage().searchResultItem.click();
		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME + " edit");
		dr.findElement(By.xpath("//a[contains(text(), 'Properties')]")).click();
		dr.findElement(By.xpath("//a[contains(text(), 'New Property')]")).click();
		waitforElement(dr, Pages.consignmentPage().addPropertyHeader);
		Assert.assertEquals(Pages.consignmentPage().addPropertyHeader.getText(), "Add Property");
		Pages.consignmentPage().addObjectSearch.sendKeys("QA Test Object");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//div[@id = 'react-autowhatever-1']/ul/li/div/div/div[2]/h4[contains(text(),'Test Object')]")).click();
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", dr.findElement(By
				.xpath("//input[@placeholder = 'Object type']/ancestor::div[@class = 'sc-cSHVUG sc-dxgOiQ cFmSFh']")));
		Thread.sleep(500);
		dr.findElement(
				By.xpath("//input[@placeholder = 'Object type']/ancestor::div[@class = 'sc-cSHVUG sc-dxgOiQ cFmSFh']"))
				.click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//span[contains(text(), 'Fine Art')]")).click();
		Pages.auctionPage().departmentListBox.sendKeys("Contemporary Art" + Keys.ENTER);
		Thread.sleep(1000);
		Pages.consignmentPage().inputSaleLocation.sendKeys("New York" + Keys.ENTER);
		Thread.sleep(2000);
		Select currency_dropdown = new Select(Pages.consignmentPage().inputCurrencyDropdown);
		currency_dropdown.selectByVisibleText("USD");
		Assert.assertTrue(Pages.consignmentPage().labelEstimateCurrencyUSD
				.isDisplayed());
		Pages.consignmentPage().inputEstimateLow.sendKeys("200");
		Pages.consignmentPage().inputEstimateHigh.sendKeys("1000");
		Assert.assertTrue(Pages.consignmentPage().labelReserveCurrencyUSD
				.isDisplayed());
		Pages.consignmentPage().inputReserve.sendKeys("200");
		Pages.objectPage().createButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(dr.findElement(By.xpath("//h1[contains(text(), 'QA Test Object')]")).isDisplayed());
		System.out.println("Objects were added to Consignment");
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
		if (dr.findElement(By.xpath("//div[contains(text(), 'Total Properties')]/following-sibling::div/h1")).getText()
				.contentEquals("1")) {
			dr.findElement(By.xpath("//tbody/tr/th")).click();
			dr.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
			// Thread.sleep(2000);
			waitforElement(dr, dr.findElement(
					By.xpath("//h3[contains(text(), 'No Properties have been added to this Consignment')]")));
			Assert.assertTrue(dr
					.findElement(
							By.xpath("//h3[contains(text(), 'No Properties have been added to this Consignment')]"))
					.isDisplayed());
			System.out.println("Objects were removed from consignment");
		} else {
			System.out.println("Objects were not present to remove from consignment");
		}
	}

}
