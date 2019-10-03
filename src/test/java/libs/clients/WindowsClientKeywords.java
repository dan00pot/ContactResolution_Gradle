package libs.clients;


import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.windows.WindowsDriver;
import libs.common.Selenium;


public class WindowsClientKeywords {

	Selenium selenium = new Selenium();
	WindowsClientLocators windowsClient = new WindowsClientLocators();
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	WindowsDriver winClientDriver;
	
	public boolean verifyLocalContactSearch (WindowsDriver winRootDriver, String name, String expected) throws Exception 
	{
		logger.info("verifylocalContactSearch - starting...\n");
		try {
			name = "'"+name;
			logger.info(name);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			boolean flag = false;
			logger.info("**** verifylocalContactSearch - Get number of result ****");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, name);
			Thread.sleep(10000);
			logger.info("**** verifyLocalContactSearch - Get number of result ****");
			
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_LOCAL_CONTACT_TITLE_BAR, 
					"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyLocalContactSearch - Number of result: " + num);
			logger.info("**** verifyLocalContactSearch - Verify search ****");
			logger.info("verifyLocalContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_local_result(expected), 
						"AutomationId");
				logger.info("verifyLocalContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyLocalContactSearch - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				logger.error("verifyLocalContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyLocalContactSearch - Expected result didn't exist");
			}
			logger.info("verifyLocalContactSearch - PASSED");
			
			return flag;
		} catch (Exception e) {
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
	
	}
	
	public boolean verifyEnterpriseContactSearch (WindowsDriver winRootDriver, String name, String expected) throws Exception 
	{

		logger.info("verifyEnterpriseContactSearchOn - starting...\n");
		try {
			boolean flag = false;
			String checkNum = name.replaceAll("[0-9]", "");
			
			if (checkNum.equals("")) {
				name = "'"+name;
			}
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			logger.info("**** verifyEnterprieseContactSearchOnACA - Get number of result ****");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, name);	
			Thread.sleep(5000);
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_enterprise_result(expected), "Name");
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
					return true;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
			}
			logger.info("verifyEnterprieseContactSearch - PASSED");
			
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
		return false;
	}
	
	
	public boolean autoConfigLogin(WindowsDriver winRootDriver, String address,  String user, String pwd) throws Exception{
		logger.info("autoConfigLogin - starting...\n");
		try {
			
			Thread.sleep(2000);
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN)) {
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN);
			}
			
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_BTN);
			Thread.sleep(1000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_TXT,address);
			Thread.sleep(1000);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(3000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)) {
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			}
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(9000);
			
		//	winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			selenium.clickElement(winRootDriver, windowsClient.WELCOME_SKIP_TUTORIAL_BTN);
			Thread.sleep(9000);
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)==true)
			{
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			}
		} catch (Exception exception) {
			logger.error("autoConfigLogin - Failed with Exception: " + exception + "...\n");
			return false;
		}
		logger.info("autoConfigLogin - completed...\n");	
		return true;
    }
	
	
	public void resetApplication(WindowsDriver winRootDriver) throws Exception{
		logger.info("resetApplication - starting...\n");
		int i=0;
		//Screen sikuli = new Screen();
		
		while (true) {
			if(i==3) break;
		
		try {
			//if(sikuli.exists("imgs//ACW_Configure.png")!=null) {
			//	break;
			//	}
			
			
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");

			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
			Thread.sleep(3000);

			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
			
			
			
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators("Support"));
		//	selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Reset Application"));
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Clear"));
			Thread.sleep(2000);
//			Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ALT);
//		    robot.keyPress(KeyEvent.VK_F4);
//		    robot.delay(100);
//		    robot.keyRelease(KeyEvent.VK_ALT);
//		    robot.keyRelease(KeyEvent.VK_F4);
		    break;
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("resetApplication - Failed with Exception: " + exception + "...\n");
//			throw new Exception("resetApplication - Failed - Exception occurs: " + exception);
			i++;
			selenium.clickElement(winClientDriver,windowsClient.SETTING_WINDOWS_CLOSE_BTN);
			
		}}
		logger.info("resetApplication - completed...\n");		
    }
	
	
	public WindowsDriver createWinHandleDriver(WindowsDriver windowDriver, String window) throws Exception{	
		WindowsDriver windowsClientDriver = null;
		String currentURL = windowDriver.getRemoteAddress().toString();
			try {
				WebElement handle = windowDriver.findElementByName(window);
				String st = handle.getAttribute("NativeWindowHandle");
				logger.info(st);
				
				String s2 = Integer.toHexString(Integer.parseInt(st));
				System.out.println(s2);
				String equinox = "0x"+s2;
				logger.info("Hex: " + equinox);
				
				
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("appTopLevelWindow", equinox);
	            
	            windowsClientDriver = new WindowsDriver(new URL(currentURL), capabilities);
	            windowsClientDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				logger.info("createWindowsClientDriver - Failed...\n + E: " + e);
				// TODO: handle exception
			}
			logger.info("createWindowsClientDriver - completed...\n");
	
		return windowsClientDriver;
    }
	
	
	public String getWinHandle(WindowsDriver windowDriver, String windowName) {
		try {
			WebElement handle = windowDriver.findElementByName("Avaya Equinox");
			String st = handle.getAttribute("NativeWindowHandle");
			String s2 = Integer.toHexString(Integer.parseInt(st));
			System.out.println(s2);
			String equinox = "0x"+s2;
			return equinox;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void confirmOpenApp(WindowsDriver winRootDriver) throws Exception{
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Other Avaya Equinox instances are detected");
	
            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_LOGIN_DIALOG_TXT_OPEN_CONFIRM_QUESTION)){
            	selenium.clickElement(winClientDriver,windowsClient.ACW_LOGIN_DIALOG_BTN_NO);
            }

		} catch (Exception exception) {
			logger.error("confirmOpenApp - Failed with Exception: " + exception + "...\n");
			throw new Exception("confirmOpenApp - Failed - Exception occurs: " + exception);
		}
		logger.info("confirmOpenApp - completed...\n");		
    }
	
	
	
	public void mainWindowsNavigateToContactTab (WindowsDriver winRootDriver) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(!selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);
				Thread.sleep(1000);		
			}
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsNavigateToContactTab - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public void resetcontactTab (WindowsDriver winRootDriver) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(!selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);}
			Thread.sleep(1000);	
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public void settingWindowsMainClickBackButton(WindowsDriver winRootDriver) throws Exception{
		logger.info("settingWindowsMainClickBackButton - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN);
	
		} catch (Exception exception) {
			logger.error("settingWindowsMainClickBackButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainClickBackButton - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainClickBackButton - completed...\n");		
    }
	
	public void clickCancelSearch (WindowsDriver windowClientDriver) throws Exception{
		logger.info("clickCancelSearch - starting...\n");
		try {
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);
			Thread.sleep(3000);	
		} catch (Exception exception) {
			logger.error("clickCancelSearch - Failed with Exception: " + exception + "...\n");
		}
		logger.info("clickCancelSearch - completed...\n");		
    }
	
	
	
	public boolean verifyUserisExistedContactTab(WebDriver winClientDriver, String user) throws Exception{
		logger.info("verifyUserisExistedContactTab - starting...\n");
		logger.info("user is: " + user + "\n");
		boolean s= false;
		try {
			Thread.sleep(2000);
			s = selenium.isElementExisted(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(2000);	
			
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("verifyUserisExistedContactTab - Failed with Exception: " + exception + "...\n");
//			throw new Exception("verifyUserisExistedContactTab - Failed - Exception occurs: " + exception);
			s=false;
		}
		logger.info("verifyUserisExistedContactTab - completed...\n");		
		return s;
    }
	
	/**
	 * @param winClientDriver
	 * @param status
	 * @throws Exception
	 * @author HuyD
	 */
	public void setStatus(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.mainwindowsstatus(status));
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CLOSE_AVATAR_BTN);
		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");
			throw new Exception("setStatus - Failed - Exception occurs: " + e);
		}
	}
	
	public void setStatus_T(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.mainwindowsstatus(status));
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CLOSE_AVATAR_BTN);
		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");}
	}
	/**
	 * @param winClientDriver
	 * @param status
	 * @throws Exception
	 * @author HoanNguyen
	 */

	public void getStatus(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			//selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX, 5);
			//selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			
			String n = selenium.getAttribute(winClientDriver, windowsClient.mainwindowsstatusSelected(status), "IsSelected");
			System.out.println("Selected combo value: " + n);
			//String n = selenium.getAttribute(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN, "Selection");
			System.out.println("Selected combo value: " + n);
			Select comboBox = new Select(winClientDriver.findElement(windowsClient.MAIN_WINDOWS_AVATAR_BTN));
			Point location = comboBox.getFirstSelectedOption().getLocation();
			String selectedComboValue = comboBox.getFirstSelectedOption().getCssValue("id");
			
	
			System.out.println("Selected combo value: " + selectedComboValue);
			System.out.println("Selected combo value: " + location);
			

		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");
			throw new Exception("setStatus - Failed - Exception occurs: " + e);
		}
	}
	
	public void verifyContactStatus(WebDriver winClientDriver,String user, String status) throws Exception{
		logger.info("verifyContactStatus - starting...\n");
		try {
			Thread.sleep(7000);
			String s = selenium.getAttribute(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_STATUS(user), "Name");
			if(s.contains(status)){
				logger.info("PASSED");
			}else{
			logger.info("FAILED");
			throw new Exception("verifyContactStatus - Failed - Exception occurs: ");
			}
		} catch (Exception exception) {
		
			logger.error("verifyContactStatus - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactStatus - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactStatus - completed...\n");		
    }
	
	public void conversationWindowsEditSubject_T (WebDriver winClientDriver, String subject) throws Exception{
		logger.info("conversationWindowsEditSubject - starting...\n");
		logger.info("subject is: " + subject + "\n");
		try {
			Thread.sleep(1000);
			
			WebElement element = winClientDriver.findElement(windowsClient.CONVERSATION_WINDOWS_MENU_BTN);
			Actions build = new Actions(winClientDriver);
			build.moveToElement(element, 5, 5).click().build().perform();
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_BTN);
			
		
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_TXT, subject);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_DONE_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			logger.error("conversationWindowsEditSubject - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsEditSubject - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsEditSubject - completed...\n");		
    }
	
	
	public void moveConversationWindow(WebDriver winClientDriver) throws Exception{
		logger.info("mainElementToPosition - starting...\n");
		try {
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			logger.info("screen x is: " + screen.getWidth() + "\n");
			logger.info("screen y is: " + screen.getHeight() + "\n");
			selenium.dragAndDropFromElementToPosion(winClientDriver, windowsClient.MAIN_WINDOWS_TITLE, (int) screen.getWidth()-900, 100);
		} catch (Exception exception) {
			logger.error("mainElementToPosition - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainElementToPosition - Failed - Exception occurs: " + exception);
		}
		logger.info("mainElementToPosition - completed...\n");		
    }
	
	/**
	 * Leave the current conversation
	 * @param winClientDriver testing Client on Windows
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsLeaveConversation(WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsLeaveConversation - starting...\n");
		try {
			WebElement element = winClientDriver.findElement(windowsClient.CONVERSATION_WINDOWS_MENU_BTN);
			Actions build = new Actions(winClientDriver);
			build.moveToElement(element, 5, 5).click().build().perform();
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_LEAVE_CONVERSATION_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			
			logger.error("conversationWindowsLeaveConversation - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsLeaveConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsLeaveConversation - completed...\n");		
    }
	
	/**
	 * Send the composed message
	 * @param winClientDriver testing Client on Windows
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsSendMsg (WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(3000);
		} catch (Exception exception) {
			logger.error("conversationWindowsSendMsg - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsSendMsg - completed -- PASSED...\n");		
    }
	
	
	public void conversationWindowsSendMsg_T (WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(3000);
		    
		} catch (Exception exception) {
			logger.error("conversationWindowsSendMsg - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsSendMsg - completed -- PASSED...\n");		
    }
	/**
	 * Input text message into message text box in Conversation Windows
	 * @param winClientDriver testing Client on Windows
	 * @param message Text Message to input into Text Msg box
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsInputTextMsg (WebDriver winClientDriver, String message) throws Exception{
		logger.info("conversationWindowsInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT, message);
			
		} catch (Exception exception) {
			logger.error("conversationWindowsInputTextMsg - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsInputTextMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsInputTextMsg - completed -- ...\n");		
    }
	
	
	public void conversationWindowsInputTextMsg_T (WebDriver winClientDriver, String message) throws Exception{
		logger.info("conversationWindowsInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT, message);
		} catch (Exception exception) {
			logger.error("conversationWindowsInputTextMsg - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsInputTextMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsInputTextMsg - completed -- ...\n");		
    }
	
	public void mainWindowsContactsTabOpenNewConversationWithUser_T(WebDriver winClientDriver, String user) throws Exception{
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
		
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Chat",user));
			Thread.sleep(4000);
//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN, timeout);
//			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN);
//			Thread.sleep(2000);
		    Robot r =  new Robot();
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (Exception exception) {
	
			logger.error("mainWindowsContactsTabOpenNewConversationWithUser - Failed with Exception: " + exception + "...\n");

			//throw new Exception("mainWindowsContactsTabOpenNewConversationWithUser - Failed - Exception occurs: " + exception);
		}	
    }
	
	public void addUserToConversationOnConversationTab_T(WebDriver winClientDriver, String user, String subject) throws Exception{
		logger.info("addUserToConversationOnConversationTab - starting...\n");
		logger.info("user: " + user + "\n");
		logger.info("subject: " + subject + "\n");
		try {
			selenium.rightClickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_USER_BTN);
			//selenium.rightClickElement(winClientDriver, windowsClient.conversationWindowsSubjectTabLeftBtn(subject));
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_TXT);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT);
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT, user);
			Thread.sleep(2000);
			selenium.mouseHover(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			//selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			Thread.sleep(1000);
			//selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_ITEM_BTN);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_USER_CONFIRM_ADD_BTN);
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);	
		} catch (Exception exception) {

			logger.error("addUserToConversation - Failed with Exception: " + exception + "...\n");
			//throw new Exception("addUserToConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("addUserToConversation - completed...\n");			
    }
	
	public void conversationWindowsVerifyConversationShouldContainMessage_T (WebDriver winClientDriver, String text) throws Exception{
		logger.info("conversationWindowsVerifyConversationShouldContainMessage - starting...\n");	
		logger.info("Message is: " + text + "\n");
		try {
			Thread.sleep(4000);
			selenium.elementShouldExisted(winClientDriver, windowsClient.conversationWindowsFileNameLocator(text));
			logger.info("*** conversationWindowsVerifyConversationShouldContainMessage - PASSED ***");
			
		} catch (Exception exception) {
			logger.error("conversationWindowsVerifyConversationShouldContainMessage - Failed with Exception: " + exception + "...\n");
//			/throw new Exception("conversationWindowsVerifyConversationShouldContainMessage - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsVerifyConversationShouldContainMessage - completed -- ...\n");			
    }
	
	public void mainWindowsContactsTabCallUser_T(WebDriver winClientDriver, String user) throws Exception{
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			winClientDriver.getWindowHandle();
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Call",user));

//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN, timeout);
//			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN);
//			Thread.sleep(2000);
		    Robot r =  new Robot();
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (Exception exception) {

			logger.error("mainWindowsContactsTabOpenNewConversationWithUser - Failed with Exception: " + exception + "...\n");
			//throw new Exception("mainWindowsContactsTabOpenNewConversationWithUser - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - completed...\n");		
    }
	
	
	public boolean verifyContactIsExistedInContactList(WebDriver winClientDriver, String name) throws Exception{
		try {
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name))){
				logger.info("verifyEnterpriseSearch - PASSED");
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyIfContactExisted - Failed - Exception occurs: " + e);
		}
	}
	
	public void mainWindowsNavigateToTopOfMind (WebDriver winClientDriver) throws Exception{
		logger.info("mainWindowsNavigateToTopMind - starting...\n");
		try {
	
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_TOP_OF_MIND_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			
			logger.error("mainWindowsNavigateToTopMind - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsNavigateToTopMind - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsNavigateToTopMind - completed...\n");		
    }
	
	
	public boolean addPrivateContact(WindowsDriver winRootDriver, String firstname, String lastname, String phone, String address) throws Exception{
		logger.info("addContactBySearch - starting...\n");
		boolean s= false;
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			
			selenium.clickElement(winClientDriver, windowsClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_FISRT_NAME_TXT, firstname);
	
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT,phone);
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN)) {
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			}
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT,address);
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);}
			Thread.sleep(5000);
			selenium.waitUntilElementVisible(winClientDriver, windowsClient.SEARCH_TEXT_BOX);
			String contact = firstname + " " + lastname;
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(contact))) {
				s=true;
			} else s = false;
			
		} catch (Exception exception) {
			logger.info("addContactBySearch - Failed: Exception: " + exception);
			s=false;
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN))
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN);
		}
		logger.info("addContactBySearch - completed...\n");	
		return s;
    }
	
	public boolean contactsIsContactFavorite (WindowsDriver winRootDriver, String user) throws Exception{
		logger.info("contactsIsContactFavorite - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, user);	
			
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocatorsAfterSearch(user));
			if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_ENABLED(user))) {
				logger.info(user + " is favorite");
				return true;
			} else {
				if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_DISABLED(user))) {
					logger.info(user + " is not favorite");
					return false;
				} else {
					logger.info("Favorites icon is not present");
					throw new Exception("contactsMarkContactAsFavorites - Failed - Favorites icon is not present");
				}
			}

		} catch (Exception exception) {
		
			logger.error("contactsMarkContactAsFavorites - Failed with Exception: " + exception + "...\n");
			throw new Exception("contactsMarkContactAsFavorites - Failed - Exception occurs: " + exception);
		}
	   }
	
	 public void oneX_login(WindowsDriver winRootDriver, String number, String pass) throws Exception {
	    	String message = String.format("");
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	logger.warn(message);
	    	try{
	    		selenium.inputText(winClientDriver, windowsClient.ONE_X_LOGIN_WINDOW_TXT_USER, number);
	    		selenium.inputText(winClientDriver, windowsClient.ONE_X_LOGIN_WINDOW_TXT_PWD, pass);
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_FIRST_WINDOWS_LOGIN_BTN);
	    		
	    	}catch (Exception e) {
	            message = String.format("*** oneX_login *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    	
	    }
	    
		/**
		 * 
		 * OneX answer call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_answerCall(WindowsDriver winRootDriver)throws Exception{
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_ANSWER);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
		/**
		 * 
		 * OneX transfer call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_transferCall (WindowsDriver winRootDriver, String number) throws Exception{
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_TRANSFER);
	    		Thread.sleep(3000);
	    		selenium.inputText(winClientDriver, windowsClient.ONE_X_TRANSFER_CALL_TXT_PHONE_NUMBER, number);
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_TRANSFER_CALL_BTN_OK);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
	    
		/**
		 * 
		 * OneX hold call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_holdCall(WindowsDriver winRootDriver) throws Exception {
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_HOLD);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
		
	    /**
		 * 
		 * OneX resume call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_resumeCall(WindowsDriver winRootDriver) throws Exception {
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_HOLD);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
		/**
		 * 
		 * OneX mute call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_muteCall(WindowsDriver winRootDriver) throws Exception {
	       	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_MUTE);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
		/**
		 * 
		 * OneX unmute call
		 * @author HuyD
		 * 
		 * */
	    public void oneX_unmuteCall(WindowsDriver winRootDriver) throws Exception{
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_INCOMING_CALL_BTN_MUTE);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	
	    public void oneX_dropcall(WindowsDriver winRootDriver) throws Exception {
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("1X - ");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_MAIN_WINDOW_BTN_END);
	    	}catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
		/**
		 * 
		 * ACWin verify Callee Name
		 * @author HuyD
		 * 
		 * */
		public void verifyCalleeName(WindowsDriver winRootDriver,String Expected) throws Exception{
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			try {
                if(selenium.isElementExisted(winClientDriver, windowsClient.acw_callee_info(Expected))){
                    logger.info("*** makeCallBySearching *** PASSED");
                }
                else{
                    String msg = String.format(" *** Wrong callee info displayed ***");
                    logger.error(msg);
                    throw new AssertionError(msg);
                    
                }
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
		
		
		
		/**
		 * 
		 * ACWin verify Call History Contact
		 * @author HuyD
		 * 
		 * */
		public void verifyCallHistoryContact(WindowsDriver winRootDriver,String Expected) throws Exception{
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			try {
                if(selenium.isElementExisted(winClientDriver, windowsClient.CALL_HISTORY_CONTACT_NAME(Expected))){
                    logger.info("*** makeCallBySearching *** PASSED"); 
                }
                else{
                    String msg = String.format(" *** Wrong callee info displayed ***");
                    logger.error(msg);
                    throw new AssertionError(msg);
                }
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		/****************************************************************************************************/
		/**
		 * 
		 * ACWin Call Actions
		 * @author HuyD
		 * 
		 * */
		
	    public void makeCallBySearching(WindowsDriver winRootDriver, String callee_number) throws Exception {
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
	        String message = String.format("*** makeCallBySearching - Make call by searching by phone number or name ***");
	        logger.warn(message);
	        try {
	            //WebElementActions.waitElementPresent(driver, ACWinElements.ACW_CALL_TXT_SEARCH_NAME_OR_NUMBER, 60);
	            if(selenium.isElementExisted(winClientDriver, windowsClient.SEARCH_TEXT_BOX)){
	                logger.info("*** Enter Phone number: " + callee_number + " ***");
	                selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, callee_number);
	                selenium.sendKeyEnter(winClientDriver, windowsClient.SEARCH_TEXT_BOX);
//	                selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_MAKE_VOICE_CALL);

	                logger.info("*** Verify Callee Information by SMGR name ***");
	            
	            }
	        } catch (Exception e) {
	            message = String.format("*** makeCallBySearching *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }

	    }

	    public void answerCall(WindowsDriver winRootDriver) {
	    	
	        String message = String.format("*** answerCall - Answer Call ***");
	        logger.warn(message);
	        try {
	        	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
	            //WebElementActions.isElementDisplayed(driver, ACWinElements.ACW_CALLER_INFO);
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_ANSWER_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_ANSWER_CALL);
	            }
	            
	            if(selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_HOLD_CALL)){
	            logger.info("*** answerCall *** PASSED");
	            }
	            else{
	                String msg = String.format(" *** No HOLD button ***");
	                logger.error(msg);
	                throw new AssertionError(message);
	            }
	        } catch (Exception e) {
	            message = String.format("*** answerCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }
	    }

	    public void dropCall(WindowsDriver winRootDriver) {
	        String message = String.format("*** dropCall - Drop a call. ***");
	        logger.warn(message);
	        try {
	        	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_DROP_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_DROP_CALL);
	            }
	            Thread.sleep(10000);
	            
	            if(!selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_HOLD_CALL)){
	            logger.info("*** dropCall *** PASSED");
	            }
	            else{
	                String msg = String.format(" *** No DROP button ***");
	                logger.error(msg);
	                throw new AssertionError(message);
	            }
	        } catch (Exception e) {
	            message = String.format("*** dropCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }
	    }
	    public boolean dropCall_T(WindowsDriver winRootDriver) {
	   boolean n=false;
	        try {
	        	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_DROP_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_DROP_CALL);
	            }
	            Thread.sleep(7000);
	            n=!selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_DROP_CALL);
	         
	        } catch (Exception e) {
	        }
			return n;
	    }
	    public void holdCall (WebDriver winClientDriver){
	        String message = String.format("*** holdCall - Hold a call. ***");
	        logger.warn(message);
	        try {
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_HOLD_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_HOLD_CALL);
	        } 
	        logger.info("*** holdCall *** PASSED");
	        } catch (Exception e) {

	            message = String.format("*** holdCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }
	    }
	    
	    public void resumeCall(WindowsDriver winRootDriver){
	        String message = String.format("*** resumeCall - Hold a call. ***");
	        logger.warn(message);
	        try {
	        	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_RESUME_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_RESUME_CALL);
	        } 
	            logger.info("*** resumeCall *** PASSED");
	        } catch (Exception e) {

	            message = String.format("*** resumeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }
	    }

	    public void close(WebDriver winClientDriver) {
	    	winClientDriver.quit();
	    }
	    
	    public void oneX_logout(WindowsDriver winRootDriver) throws Exception {
	    	boolean result =false;
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("1X - Log Out");
	    	logger.warn(message);
	    	try{
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_MAIN_WINDOW_BTN_MENU);
	    		Thread.sleep(3000);
	    		selenium.clickElement(winClientDriver, windowsClient.ONE_X_MENU_BTN_LOG_OUT);
	    		if (selenium.isElementExisted(winClientDriver, windowsClient.ONE_X_FIRST_WINDOWS_LOGIN_BTN)) {
	    			logger.info("*** oneX_logout *** COMPLETED");
	    		}
	    		/*
	    		if(selenium.isElementExisted(winClientDriver, windowsClient.ONE_X_MENU_BTN_YES))
	    		{
	    			selenium.clickElement(winClientDriver, windowsClient.ONE_X_MENU_BTN_YES);
	    		}
	    		*/
	    	}catch (Exception e) {
	            message = String.format("*** oneX_logout *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
	    
		public void deleteAllHistory(WindowsDriver winRootDriver) throws Exception{
			logger.info("deleteAllHistory - starting...\n");
			try {
				winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
				mainWindowsNavigateToHistoryTab(winClientDriver);
				if(!selenium.isElementExisted(winClientDriver,windowsClient.FILTER_LIST_HISTORY)) {
					mainWindowsNavigateToHistoryTab(winClientDriver);
				}
				selenium.clickElement(winClientDriver, windowsClient.TITLE_BTN("History"));
				selenium.clickElement(winClientDriver, By.name("Delete All History"));
				Thread.sleep(1000);	
			} catch (Exception exception) {
				logger.error("deleteAllHistory - Failed with Exception: " + exception + "...\n");
				throw new Exception("deleteAllHistory - Failed - Exception occurs: " + exception);
			}
			logger.info("deleteAllHistory - completed...\n");		
	    }
		
		public void mainWindowsNavigateToHistoryTab (WindowsDriver winRootDriver) throws Exception{
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			logger.info("mainWindowsNavigateToHistoryTab - starting...\n");
			try {
				selenium.clickElement(winClientDriver, windowsClient.BUTTON_TITLE_BTN("History"));
//				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_HISTORY_BTN);
				Thread.sleep(1000);	
			} catch (Exception exception) {

				logger.error("mainWindowsNavigateToHistoryTab - Failed with Exception: " + exception + "...\n");
				throw new Exception("mainWindowsNavigateToHistoryTab - Failed - Exception occurs: " + exception);
			}
			logger.info("mainWindowsNavigateToHistoryTab - completed...\n");		
	    }
		  
	    	
		public void oneX_makeCall(WindowsDriver winRootDriver, String number) throws Exception {
			
		//	selenium.waitUntilElementVisible(winRootDriver, windowsClient.ONE_X_MAIN_WINDOW_TXT_FIELD);
			
	    	winClientDriver = createWinHandleDriver(winRootDriver, "Avaya one-X® Communicator");
	    	String message = String.format("oneX_makeCall - Make call to: " +number );
	    	logger.warn(message);
	    	try {
	    		Thread.sleep(3000);
				selenium.inputText(winClientDriver, windowsClient.ONE_X_MAIN_WINDOW_TXT_FIELD, number);
				selenium.sendKeyEnter(winClientDriver, windowsClient.ONE_X_MAIN_WINDOW_TXT_FIELD);
//				selenium.clickElement(winClientDriver, windowsClient.ONE_X_MAIN_WINDOW_BTN_DIAL);
				
			} catch (Exception e) {
	            message = String.format("*** oneX_makeCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
			}
	    }
		
		public void outgoingCallDropCallButton(WindowsDriver winRootDriver) throws Exception{
			logger.info("conversationWindowsMakeACall - starting...\n");
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			try {
				selenium.clickElement(winClientDriver, windowsClient.OUTGOING_CALL_DROP_BTN);
				Thread.sleep(3000);
			} catch (Exception exception) {
			
				logger.error("outgoingCallDropCallButton - Failed with Exception: " + exception + "...\n");
				throw new Exception("outgoingCallDropCallButton - Failed - Exception occurs: " + exception);
			}
			logger.info("outgoingCallDropCallButton - completed...\n");		
	    }

		public void pickUpThePhone(WindowsDriver winRootDriver) throws Exception{
			logger.info("oneX pickUpPhone - starting...\n");
			try {
				winClientDriver = createWinHandleDriver(winRootDriver, "Incoming call...");
				Thread.sleep(1000);
				selenium.waitUntilElementVisible(winClientDriver, windowsClient.PICK_UP_THE_PHONE);
				selenium.clickElement(winClientDriver, windowsClient.PICK_UP_THE_PHONE);
				
			}catch(Exception e){
				logger.error("picUpThePhone -Failed with Exception: "+e +"...\n");
				throw new Exception("picUpThePhone -Failed with Exception: "+e);
			}
			logger.info("outgoingCallDropCallButton - completed...\n");		
		}
		
		
}
