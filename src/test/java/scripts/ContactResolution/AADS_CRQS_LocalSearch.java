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

public class AADS_CRQS_LocalSearch {

	/*########################################################################################################
 	Verify that Equinox search Contact local
 	
	*Configurations:
		1. Add 3 contact user login equinox window client E, F, G
		 
	*Procedures:
		1. Using phone search contact E, F, G
		2. Checking information display name E, F, G on tab contacts
		 
	*Expected result:
		1. information display name exactly E, F, G on tab contacts
	
	*Note:Notes:
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
	
	int numberOfContact = 3;
	
	String sheet = "Local_Search";
	String Winium_URL = aadsData.WiniumURL(1);
	String WinApp_URL = aadsData.WinAppURL(1);
	ExcelData excel = new ExcelData();
	
	final static Logger logger = LogManager.getLogger("AADS_CRQS_LocalSearch");

	@Before
	public void beforetestAADS_CRQS_LocalSearch() throws Exception {
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
	public void AADS_CRQS_LocalSearch() throws Exception {

		try {
		
			for (int i=1;i<=numberOfContact;i++) {
			String DN= excel.searchResult(i, sheet);	
			String mail= excel.searchString(i, sheet);
			String DN1= excel.searchResultAndroid(i, sheet);
			String mail1= excel.searchStringAndroid(i, sheet);
			String DN2= excel.searchResultIos(i, sheet);
			String mail2= excel.searchStringIos(i, sheet);
			
			boolean n=winClient.verifyLocalContactSearch(windowsDriverRoot, mail,DN);
			if(n) System.out.println("Searching " +DN+ "- PASSED...");
			else System.out.println("Searching " +DN+ "- FAILED...");
			assertTrue(n);
//			
			n=androidClient.verifyLocalContactSearchOnACA(androidClientDriver, mail1,DN1);
			if(n) System.out.println("Searching " +DN1+ "- PASSED...");
			else System.out.println("Searching " +DN1+ "- FAILED...");
			assertTrue(n);
			
			n=iosClient.verifyLocalContactSearch(iOSClientDriver, DN2,mail2);
			if(n) System.out.println("Searching " +DN2+ "- PASSED...");
			else System.out.println("Searching " +DN2+ "- FAILED...");
			assertTrue(n);
			}

			
		} catch (Exception exception) {
		
			logger.error("AADS_CRQS_LocalSearch - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_CRQS_LocalSearch - Failed - Exception occurs: "
					+ exception.toString());
			
			assertTrue(false);
		}
		logger.info("AADS_CRQS_LocalSearch - completed...\n");
	}

	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
	
		logger.info("tearDown completed...\n");
	}
}
