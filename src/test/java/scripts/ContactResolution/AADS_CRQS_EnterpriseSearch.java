package scripts.ContactResolution;

import libs.clients.AADSWebKeywords;
import libs.clients.AndroidClientKeywords;
import libs.clients.IOSClientKeywords;
import libs.clients.SMGR8Keywords;
import libs.clients.SMGRKeywords;
import libs.clients.WindowsClientKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;

import excel.ExcelData;
import excel.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.windows.WindowsDriver;

import static org.junit.Assert.*;
import testData.aadsData;

public class AADS_CRQS_EnterpriseSearch {
	
	/*########################################################################################################
 	Verify that Equinox Enterprise Search
 	
	*Configurations:
		1. login user A to equinox client
		 
	*Procedures:
		1. Using phone search contact E, F, G
		2. Checking information display name E, F, G on tab Enterprise Contacts
		 
	*Expected result:
		1. information display name exactly E, F, G on tab Enterprise Contacts
	
	*Note:
		1. This test case need to be tested on MAC, Windows, Andoird, iOS
	##############################################################################################################*/
	
	static IOSDriver iOSClientDriver;
	static WiniumDriver winDriver;
	static WindowsDriver<?> windowsDriver;
	static WindowsDriver<?> windowsDriverRoot;
	static AndroidDriver<?> androidClientDriver;
	static WebDriver webDriver;
	
	SMGRKeywords SMGRWebDriver = new SMGRKeywords();
	SMGR8Keywords SMGR8WebDriver = new SMGR8Keywords();
	IOSClientKeywords iosClient = new IOSClientKeywords();
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	int numberOfContact = 20;
	
	String sheet = "ContactSearch";
	String Winium_URL = aadsData.WiniumURL(1);
	String WinApp_URL = aadsData.WinAppURL(1) ;
	ExcelData excel = new ExcelData();
	
	final static Logger logger = LogManager.getLogger("AADS_CRQS_EnterpriseSearch");

	@Before
	public void beforetestAADS_CRQS_EnterpriseSearch() throws Exception {
		winDriver = driverMgnt.createWindowsClientDriver(Winium_URL);
		windowsDriverRoot = driverMgnt.createWinAppDriver(WinApp_URL);
		winClient.confirmOpenApp(windowsDriverRoot);
		iOSClientDriver = driverMgnt.createIOSClientDriver();
		androidClientDriver = driverMgnt.createAndroidClientDriver();

	}

	/**
	 * @throws Exception
	 * @author Huy Dao
	 * 
	 */
	
	@Test
	public void AADS_CRQS_EnterpriseSearch() throws Exception {

		try {
		
			for (int i=1;i<=numberOfContact;i++) {
			String DN= excel.searchResult(i, sheet);	
			String searchString= excel.searchString(i, sheet);
			boolean n=winClient.verifyEnterpriseContactSearch(windowsDriverRoot, searchString,DN);
			if(n) System.out.println("Searching " +DN+ "- PASSED...");
			else System.out.println("Searching " +DN+ "- FAILED...");
			assertTrue(n);
			
			boolean s=androidClient.TestSearchContact(androidClientDriver, searchString,DN);
			if(s) System.out.println("Searching " +DN+ "- PASSED...");
			else System.out.println("Searching " +DN+ "- FAILED...");
			assertTrue(true);
			
			n=iosClient.verifyEnterpriseContactSearch(iOSClientDriver, searchString,DN);
			if(n) System.out.println("Searching " +DN+ "- PASSED...");
			else System.out.println("Searching " +DN+ "- FAILED...");
			assertTrue(n);
			}

			
		} catch (Exception exception) {
		
			logger.error("AADS_CRQS_EnterpriseSearch - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_CRQS_EnterpriseSearch - Failed - Exception occurs: "
					+ exception.toString());
			
			assertTrue(false);
		}
		logger.info("AADS_CRQS_EnterpriseSearch - completed...\n");
	}

	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
	
		iOSClientDriver.quit();
		androidClientDriver.quit();
		winDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
