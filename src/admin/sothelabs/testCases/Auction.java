package admin.sothelabs.testCases;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;

import admin.sothelabs.pageObjectFactory.Pages;
import admin.sothelabs.testUtils.SetupUtils;

public class Auction extends SetupUtils{
	
	protected String auction_title = "Auto Auction +"+RandomStringUtils.randomAlphanumeric(8);
	
	@Test(priority = 1, enabled = false)
	public void createNewAuction() throws InterruptedException, IOException, ParseException {
		System.out.println("Test");
		Assert.assertEquals(Pages.consignmentPage().newButton.getText(), "NEW");
		Pages.consignmentPage().newButton.click();
		waitforElement(dr, Pages.auctionPage().sidebarMenuTimedAuction);
		Pages.auctionPage().sidebarMenuTimedAuction.click();
		waitforElement(dr, Pages.auctionPage().titleTextEdit);
		Pages.auctionPage().titleTextEdit.sendKeys(auction_title);
		Pages.auctionPage().locationListBox.sendKeys("New York"+Keys.ENTER);
		//-----------Dates-------------
		 Date curDate = new Date();
	     SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	     String start_date = format.format(curDate);
	     format = new SimpleDateFormat("hh");
	      String hour = format.format(curDate);
	      format = new SimpleDateFormat("mm");
	      String min = format.format(curDate);
	      format = new SimpleDateFormat("a");
	      String picker = format.format(curDate);
	      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 2); // Adding 1 days
			String end_date = sdf.format(c.getTime());
			System.out.println("Date is  - " +end_date);
	     dr.findElement(By.xpath("//input[@id = 'start']")).sendKeys(start_date+Keys.ENTER);
		Thread.sleep(500);
		dr.findElement(By.xpath("//span[@class = 'rc-time-picker datetime']")).click();
		Thread.sleep(1000);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li")), hour);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li")), min);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li")), picker);
		//end date----------
		//dr.findElement(By.xpath("//input[@id = 'end']")).click();
		Thread.sleep(1000);
		dr.findElement(By.xpath("//input[@id = 'end']")).sendKeys(end_date+Keys.ENTER);
		Thread.sleep(1000);
		dr.findElement(By.xpath("//input[@id= 'end']/ancestor::div[@class = 'sc-hEsumM fMhkjF']/following-sibling::span/div/span/input")).click();
		Thread.sleep(1000);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li")), hour);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[2]/ul/li")), min);
		selectElementFromList(dr.findElements(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[3]/ul/li")), picker);
		Thread.sleep(1000);
		Pages.auctionPage().SaleNumTextEdit.sendKeys("AU"+RandomStringUtils.randomAlphanumeric(4));
		Pages.auctionPage().departmentListBox.sendKeys("Contemporary Art ECTP"+Keys.ENTER);
		Pages.auctionPage().overviewTextEdit.sendKeys("test"+Keys.ENTER);
		Thread.sleep(1000);
		Pages.auctionPage().conditionTextEdit.sendKeys("Good Condition"+Keys.ENTER);
		Thread.sleep(2000);
//		WebElement element =dr.findElement(By.xpath("//div[@class = 'sc-cSHVUG dQvtQT']"));
		Pages.auctionPage().bidIncrementListBox.click();
		Thread.sleep(1000);
		Pages.auctionPage().bidIncrementItem.click();
		Pages.objectPage().uploadImage.sendKeys("//Users//priya.ganesan//Documents//Browsers//abstract-art.jpg");
		Thread.sleep(1000);
		Pages.consignmentPage().createButton.click();	
		Assert.assertTrue(dr.findElement(By.xpath("//a[contains(text(), 'Details')]")).isDisplayed());
		Assert.assertEquals(dr.findElement(By.xpath("//div[contains(text( ),'Title')]/parent::div[@class = 'col-xs-3']/following-sibling::div")).getText(), auction_title);
	}
	
	@Test(priority = 1, enabled = true)
	public void addLotsToAuction() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		dr.navigate().refresh();
		Pages.consignmentPage().sothebysLogo.click();
		waitforElement(dr, Pages.auctionPage().navItemAuction);
		Pages.auctionPage().navItemAuction.click();
		Pages.consignmentPage().searchField.sendKeys("Auto Auction");
		Pages.consignmentPage().searchSubmitButton.click();
		Pages.consignmentPage().searchResultItem.click();
		dr.findElement(By.xpath("//a[contains(text(), 'Lots')]")).click();
		dr.findElement(By.xpath("//button[@data-test-id = 'add-to-auction-button']/parent::div/div/form/div/input[@type = 'search']")).sendKeys("property"+Keys.ENTER);
		Actions action = new Actions(dr);
		WebElement we = dr.findElement(By.xpath("//div[@class = 'sc-eIHaNI fNxtV']"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		//Assert.assertTrue(dr.findElement(By.xpath("//button[@id = 'add-to-auction-button']")).isEnabled());
		action.moveToElement(dr.findElement(By.xpath("//label[@class = 'css-1u3v222']"))).click().build().perform();
		Assert.assertTrue(dr.findElement(By.xpath("//button[@id = 'add-to-auction-button']")).isEnabled());
		dr.findElement(By.xpath("//button[@id = 'add-to-auction-button']")).click();
		
		
	}
	
	public void selectElementFromList(List<WebElement> list, String item){
		//List<WebElement> hour_list = dr.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li"));
		for(WebElement li: list){
			if(li.getText().contains(item)){
				li.click();
			}
		}
	}

}
