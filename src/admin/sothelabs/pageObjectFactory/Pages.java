package admin.sothelabs.pageObjectFactory;

import java.util.function.Supplier;


import org.openqa.selenium.support.PageFactory;

import admin.sothelabs.testUtils.SetupUtils;


public class Pages{
	
	
	private static <T> T getPage(Supplier<? extends T> supp) {
	    T page = supp.get();
	    PageFactory.initElements(SetupUtils.dr, page);
	    return page;
	}
	
	public static ConsignmentPageElements consignmentPage() {
	    return getPage(ConsignmentPageElements::new); // Passing the default constructor
	}
	
	public static ObjectPageElements objectPage() {
	    return getPage(ObjectPageElements::new); // Passing the default constructor
	}
	
	public static AuctionPageElements auctionPage() {
	    return getPage(AuctionPageElements::new); // Passing the default constructor
	}
//	
//	public static BiddingPageElements biddingPage() {
//	    return getPage(BiddingPageElements::new); // Passing the default constructor
//	}
//	
//	public static HomePageElements homePage() {
//	    return getPage(HomePageElements::new); // Passing the default constructor
//	}
//	
//	public static HomePageElements homePage() {
//	    return getPage(HomePageElements::new); // Passing the default constructor
//	}
	
}
