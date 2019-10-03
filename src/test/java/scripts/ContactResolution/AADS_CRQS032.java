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

public class AADS_CRQS032 {

	/*########################################################################################################
 	Verify all contacts which matched with search string are displayed completely in case using last name for searching
 
	*Configurations:
		1. On SMGR have more than 10 users
		2. Add more than 15 contacts for some users A, B and C via clients being logged in via AADS dynamic configuration
		3. E, F, G are NOT contacts for users: A, B, C
		4. E, F, G have NOT been not stored with the call log records.
		5. E, F, G are Enterprise Contact. That means all contacts are from SMGR or LDAP
		 
	*Procedures:
		1. Search contact E by first name
		2. Search contact F by first name
		3. Search contact G by first name
		4. Search contact E by first name
		
	*Expected result:
		1. The number of result is matched with searching string and the expected contact (E,F,G) are displayed 
	
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
	final static Logger logger = LogManager.getLogger("AADS_CRQS032");
	int numberOfContact = 3;
	
	String sheet = "ContactSearch";
	ExcelData excel = new ExcelData();
	String Winium_URL = aadsData.WiniumURL(1);
	String WinApp_URL = aadsData.WinAppURL(1);

	@Before
	public void beforetestAADS_CRQS032() throws Exception {
		logger.info("Before test - AADS_CRQS024 - starting...\n");
		winDriver = driverMgnt.createWindowsClientDriver(Winium_URL);
		winDriver = driverMgnt.createWindowsClientDriverOptional(Winium_URL, "onex", "64");
		windowsDriverRoot = driverMgnt.createWinAppDriver(WinApp_URL);
		winClient.confirmOpenApp(windowsDriverRoot);
		iOSClientDriver = driverMgnt.createIOSClientDriver();
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("Before test - AADS_CRQS032 - completed...\n");
	}

	/**
	 * @throws Exception
	 * @author Huy Dao
	 * 
	 */
	
	@Test
	public void AADS_CRQS032() throws Exception {
		logger.info("AADS_CRQS032 - starting...\n");
		
		try {
			//iOSClient.navigateToContactsScreen(iOSClientDriver);

			iosClient.verifyEnterpriseNumberOfResult(iOSClientDriver, "Frush", "1");
			iosClient.verifyEnterpriseNumberOfResult(iOSClientDriver, "Rush", "1");
			iosClient.verifyEnterpriseNumberOfResult(iOSClientDriver, "Wagner", "1");
			iosClient.verifyEnterpriseNumberOfResult(iOSClientDriver, "Artour", "1");
			
			Thread.sleep(10000);
			androidClient.verifyEnterpriseNumberOfResult(androidClientDriver, "Frush", "1");
			androidClient.verifyEnterpriseNumberOfResult(androidClientDriver, "Rush", "1");	
			androidClient.verifyEnterpriseNumberOfResult(androidClientDriver, "Wagner", "1");
			androidClient.verifyEnterpriseNumberOfResult(androidClientDriver, "Artour", "1");
		
			/*Thread.sleep(10000);
			winClient.verifyEnterpriseNumberOfResult(winClient2Driver, aadsData.AADS_USER_4_NAME_SIP_PHONE_CRQS, "2");
			winClient.verifyEnterpriseNumberOfResult(winClient2Driver, aadsData.AADS_USER_5_NAME_SIP_PHONE_CRQS, "2");
			winClient.verifyEnterpriseNumberOfResult(winClient2Driver, aadsData.AADS_USER_6_NAME_SIP_PHONE_CRQS, "2");
			winClient.verifyEnterpriseNumberOfResult(winClient2Driver, aadsData.AADS_USER_7_NAME_SIP_PHONE_CRQS, "1");*/
			
		} catch (Exception exception) {
			logger.error("AADS_CRQS032 - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_CRQS032 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_CRQS032 - completed...\n");
	}

	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		//iOSClientDriver.quit();
		androidClientDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
