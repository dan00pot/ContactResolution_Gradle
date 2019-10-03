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


public class AADS_CRQS001 {
	
	/*########################################################################################################
 	Verify that Equinox contact matching with incomming calls on phone numbers via device clients
	
	*Configurations:
		1. On SMGR have more than 10 users
		2. Add more than 15 contacts for some users A, B and C via clients being logged in via AADS dynamic configuration
		3. E, F, G are NOT contacts for users: A, B, C
		4. E, F, G have NOT been not stored with the call log records.
		5. All contacts of A, B, C is Equinox Contact. That means they don't have any contact from SMGR or LDAP
		 
	*Procedures:
		1. Using E, F, G calls A, B, C
		2. Checking information E, F, G on A, B, C clients while having incomming calls
		 
	*Expected result:
		1. information E, F, G show exactly on A, B, C clients while having incomming calls
	
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

	final static Logger logger = LogManager.getLogger("AADS_CRQS001");
	String configurationName = "configuration1";
	int numberOfContact = 3;
	String sheet = "Users";
	ExcelData excel = new ExcelData();
	String phonepass = "123456";
	String Winium_URL = aadsData.WiniumURL(1);
	String WinApp_URL = aadsData.WinAppURL(1);
	
	@Before
	public void beforetestAADS_CRQS001() throws Exception {
		logger.info("Before test - AADS_CRQS001 - starting...\n");
		winDriver = driverMgnt.createWindowsClientDriver(Winium_URL);
		winDriver = driverMgnt.createWindowsClientDriverOptional(Winium_URL, "onex", "64");
		windowsDriverRoot = driverMgnt.createWinAppDriver(WinApp_URL);
		winClient.confirmOpenApp(windowsDriverRoot);
//		iOSClientDriver = driverMgnt.createIOSClientDriver();
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("Before test - AADS_CRQS001 - completed...\n");
	}

	/**
	 * @throws Exception
	 * @author Huy Dao
	 * 
	 */
	
	@Test
	public void AADS_CRQS001() throws Exception {
		logger.info("AADS_CRQS001 - starting...\n");
		try {	
			
			for(int i=0; i<3; i++){
				
			//range 73950 -> 73952: only have on CM,  using for WMware and AWS
					
				int number = Integer.parseInt(aadsData.AADS_USER_NAME_H323_PHONE_CRQS)+i;
				
				String phoneNumber = String.valueOf(number);
				String expected	="EXT, "+phoneNumber;
//				
				winClient.oneX_login(windowsDriverRoot, phoneNumber, phonepass);
				Thread.sleep(3000);
				
				// on iOs can't get locator for this test case
				
				winClient.oneX_makeCall(windowsDriverRoot, aadsData.AADS_USER_1_NAME_SIP_PHONE_CRQS);
				Thread.sleep(3000);
				winClient.verifyCalleeName(windowsDriverRoot, expected);
				winClient.oneX_dropcall(windowsDriverRoot);
				
				winClient.oneX_makeCall(windowsDriverRoot, aadsData.AADS_USER_0_NAME_SIP_PHONE_CRQS);
				Thread.sleep(3000);
				androidClient.verifyContactNameCommingCallBeforeAccept(androidClientDriver, expected);
				winClient.oneX_dropcall(windowsDriverRoot);

				winClient.oneX_logout(windowsDriverRoot);
			
			}
		
			assertTrue(true);
		} catch (Exception exception) {
			winClient.oneX_logout(windowsDriverRoot);
			logger.error("AADS_CRQS001 - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_CRQS001 - Failed - Exception occurs: "
					+ exception.toString());
			assertTrue(false);
		}
		logger.info("AADS_CRQS001 - completed...\n");
	}
	
	public void tearDown(){
		logger.info("tearDown starting...\n");
		try {
			winClient.deleteAllHistory(windowsDriverRoot);
			androidClient.deleteAllHistory(androidClientDriver);
//			iosClient.deleteAllHistory(iOSClientDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		logger.info("tearDown completed...\n");
	}
}
