package admin.sothelabs.testCases;

import java.io.IOException;
import java.text.ParseException;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;

import admin.sothelabs.pageObjectFactory.Pages;
import admin.sothelabs.testUtils.SetupUtils;
import admin.sothelabs.testUtils.TestData;

public class Auction extends SetupUtils{
	
	protected String auction_title = "Auto Auction +"+RandomStringUtils.randomAlphanumeric(12);
	
	@Test(priority = 1, enabled = true)
	public void createAndPublishAuction() throws InterruptedException, IOException, ParseException {
		Assert.assertEquals(Pages.consignmentPage().newButton.getText(), "NEW");
		Pages.consignmentPage().newButton.click();
		waitforElement(dr, Pages.auctionPage().sidebarMenuTimedAuction);
		Pages.auctionPage().sidebarMenuTimedAuction.click();
		waitforElement(dr, Pages.auctionPage().titleTextEdit);
		Pages.auctionPage().titleTextEdit.sendKeys(auction_title);
		Pages.auctionPage().locationListBox.sendKeys("New York"+Keys.ENTER);
		//-----------Dates-------------
		Pages.auctionPage().enterStartAndEndTime();
		Pages.auctionPage().SaleNumTextEdit.sendKeys("AU"+generateRandomNumber());
		Pages.auctionPage().departmentListBox.sendKeys("Contemporary Art ECTP"+Keys.ENTER);
		Pages.auctionPage().overviewTextEdit.sendKeys("test"+Keys.ENTER);
		Thread.sleep(1000);
		Pages.auctionPage().conditionTextEdit.sendKeys("Good Condition"+Keys.ENTER);
		Thread.sleep(2000);
		Pages.auctionPage().bidIncrementListBox.click();
		Thread.sleep(2000);
		Pages.auctionPage().bidIncrementItem.click();
		Pages.objectPage().uploadImage.sendKeys(imagePathBasedOnEnvt());
		Thread.sleep(1000);
		Pages.objectPage().createButton.click();
		Thread.sleep(6000);
		Assert.assertEquals(Pages.auctionPage().detailsLink.getAttribute("class"), "isActive");
		Assert.assertEquals(Pages.auctionPage().auctionTitleLabel.getText(), auction_title);
		System.out.println("Auction Created Successfully : " + auction_title);
		Pages.auctionPage().publishButton.click();
		Pages.auctionPage().confirmPublishButton.click();
		Thread.sleep(1000);
		Assert.assertEquals(Pages.auctionPage().publishStatus.getText(), "PUBLISHED");
		System.out.println("Auction Published Successfully : " + auction_title);
	}
	
	@Test(priority = 2, enabled = true)
	public void editAuction() throws InterruptedException{
//		Thread.sleep(2000);
//		String owner_type_edit = "Owner";
//		String consignment_title_edit = Pages.consignmentPage().consignmentTitleValue.getText()+" edit";
//		String consignment_notes_edit = Pages.consignmentPage().consignmentNotesValue.getText()+" edit";
//		Assert.assertEquals(Pages.consignmentPage().consignment_header.getText(), TestData.CONSIGNOR_NAME);
//		Pages.consignmentPage().editButton.click();
//		Pages.consignmentPage().consignorName.clear();
//		Pages.consignmentPage().consignorName.sendKeys(consignor_name_edit);
//		Pages.consignmentPage().accountID.clear();
//		Pages.consignmentPage().accountID.sendKeys(account_id_edit);
		
	}
	
	
	
	@Test(priority = 3, enabled = true)
	public void addAndRemoveLots() throws InterruptedException, IOException, ParseException {
		dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.auctionPage().navItemAuction);
		Pages.auctionPage().navItemAuction.click();
		Pages.consignmentPage().searchField.sendKeys("Auto Auction +TeB7GnTqjYoi");
		Pages.consignmentPage().searchSubmitButton.click();
		Thread.sleep(2000);
		Pages.consignmentPage().searchResultItem.click();
		Pages.auctionPage().lotsLink.click();
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']/parent::div/div/form/div/input[@type = 'search']")).sendKeys("QA Auto Script"+Keys.ENTER);
		Actions action = new Actions(dr);
		//WebElement add_lot = dr.findElement(By.xpath("//div[@class = 'sc-eIHaNI fNxtV']"));
		//WebElement add_lot = dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"));
		action.moveToElement(dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"))).build().perform();
		//button[@contains(text(),'VIEW DETAILS')]/parent::div/parent::div/div/label
		action.moveToElement(dr.findElement(By.xpath("//*/span/div/div/div[1]/div[1]/div[1]/div/label"))).click().build().perform();
		Thread.sleep(2000);
		//action.moveToElement(dr.findElement(By.xpath("//label[@class = 'css-1u3v222']"))).click().build().perform();
		Assert.assertTrue(dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']")).isEnabled());
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']")).click();
		Thread.sleep(2000);
		action.moveToElement(dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(dr.findElement(By.xpath("//label[@class = 'css-1u3v222']"))).click().build().perform();
		dr.findElement(By.xpath("//button[@data-test-id = 'dropdown-button']")).click();
		Thread.sleep(3000);
		//dr.findElement(By.xpath("//a[@class = 'sc-ccSCjj iQBvLS']")).click();
		dr.findElement(By.xpath("//a[contains(text(),'Remove')]")).click();
		Pages.auctionPage().confirmPublishButton.click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']/parent::div/div/form/div/input[@type = 'search']")).sendKeys("QA Auto Script"+Keys.ENTER);
		action.moveToElement(dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"))).build().perform();
		action.moveToElement(dr.findElement(By.xpath("//button[contains(text(), 'VIEW DETAILS')]"))).click().build().perform();
		Assert.assertTrue(dr.findElement(By.xpath("//div[contains(text(), 'Title')]")).isDisplayed());
		dr.findElement(By.xpath("//button[@data-test-id = 'close-modal']")).click();
		System.out.println("Lots were added and removed form auction successfully " + auction_title);	
	}
	
	
	@Test(priority = 4, enabled = true)
	public void addAndPublishLots() throws InterruptedException, IOException, ParseException {
		dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.auctionPage().navItemAuction);
		Pages.auctionPage().navItemAuction.click();
		Pages.consignmentPage().searchField.sendKeys("Auto Auction +TeB7GnTqjYoi");
		Pages.consignmentPage().searchSubmitButton.click();
		Thread.sleep(2000);
		Pages.consignmentPage().searchResultItem.click();
		Pages.auctionPage().lotsLink.click();
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']/parent::div/div/form/div/input[@type = 'search']")).sendKeys("QA Auto Script"+Keys.ENTER);
		Actions action = new Actions(dr);
		//WebElement add_lot = dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"));
		action.moveToElement(dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"))).build().perform();
		//button[@contains(text(),'VIEW DETAILS')]/parent::div/parent::div/div/label
		action.moveToElement(dr.findElements(By.xpath("//*/span/div/div/div[1]/div[1]/div[1]/div/label")).get(1)).click().build().perform();
		//action.moveToElement(dr.findElement(By.xpath("//label[@class = 'css-1u3v222']"))).click().build().perform();
		Assert.assertTrue(dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']")).isEnabled());
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']")).click();
		Thread.sleep(2000);
		WebElement card = dr.findElement(By.xpath("//div[@data-test-id = 'card']"));
		action.moveToElement(card).build().perform();
		Thread.sleep(2000);
		action.moveToElement(dr.findElement(By.xpath("//button[@data-test-id = 'Lot Object']"))).click().build().perform();
		dr.findElement(By.xpath("//input[@placeholder = 'Lot Number']")).sendKeys("1");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//div[contains(text(), 'Starting Bid')]/parent::div/following-sibling::div/div/div/div/div/input[@type = 'number']")).sendKeys("50");
		Pages.objectPage().uploadImage.sendKeys(imagePathBasedOnEnvt());
		Pages.consignmentPage().saveButton.click();
		dr.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();
		//select lot and publish-------------
		WebElement select_lot = dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"));
		action.moveToElement(select_lot).build().perform();
		action.moveToElement(dr.findElement(By.xpath("//label[@class = 'css-1u3v222']"))).click().build().perform();
		dr.findElement(By.xpath("//button[@data-test-id = 'dropdown-button']")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("//a[@data-test-id = 'publish-lots']")).click();
		//Pages.auctionPage().publishButton.click();
		Pages.auctionPage().confirmPublishButton.click();
		Thread.sleep(3000);
		dr.navigate().refresh();
		WebElement select_lot1 = dr.findElement(By.xpath("//p[@data-test-id = 'artist-name'][contains(text(), 'QA Auto script object')]"));
		action.moveToElement(select_lot1).build().perform();
		action.moveToElement(dr.findElement(By.xpath("//button[@data-test-id = 'View Lot']"))).click().build().perform();
		Assert.assertEquals(dr.findElement(By.xpath("//div[contains(text(), 'Property Group')]/parent::div/following-sibling::div/a")).getText(), "QA Auto script object");
		Assert.assertEquals(dr.findElement(By.xpath("//div/p[contains(text(), 'Published')]")).getText(), "PUBLISHED");
		dr.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();	
		System.out.println("Lots were added and published the auction successfully " + auction_title);
	}
	

}
