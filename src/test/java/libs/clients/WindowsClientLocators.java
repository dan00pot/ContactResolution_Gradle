package libs.clients;

import org.openqa.selenium.By;

public class WindowsClientLocators {

	//##########################################################################################################################################
	// Edit locator Duy
	//##########################################################################################################################################

	

	public By PICK_UP_THE_PHONE = By.xpath("//*[@AutomationId='ButtonAnswer']");


	public By SEARCH_TEXT_BOX = By.xpath("//Edit[@AutomationId='SearchTextBoxMain']");
	
	
	//##########################################################################################################################################
	// Edit locator Duy
	//##########################################################################################################################################
	
	public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By.xpath("//*[contains(@Name,'ENTERPRISE')]");
	public By search_contact_enterprise_result (String name) {
		return By.xpath("//*[contains(@Name,'ENTERPRISE')]//following-sibling::*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]");
	}
	
	public By WAITING_CREEN_WHEN_LAUNCH_APP							=	By.id("SplashScreen");
	public By FIRST_WINDOWS											=	By.xpath("//*[@AutomationId='SettingsAutoConfigWindow']");
	public By FIRST_WINDOWS_SETTING_BTN								=	By.xpath("//*[@AutomationId='AutoConfigOpenSettingsButton']");
	
	public By FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN				=	By.name("MANUALLY CONFIGURE");
	public By FIRST_WINDOWS_SETTING_USE_WEB_BTN						=	By.name("Use web address");
	public By FIRST_WINDOWS_SETTING_MANUALLY_CONFIGURE_BTN			=	By.name("Manually configure (Expert mode)");
	
	public By FIRST_WINDOWS_SETTING_USE_WEB_TXT						=	By.xpath("//*[@AutomationId='LoginUsernameFieldText']");
	public By FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT				=	By.xpath("//*[@AutomationId='LoginUsernameFieldText']");
	public By FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT					=	By.xpath("//*[@AutomationId='PasswordBox']");  
	public By FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN				=	By.name("NEXT");
	
	public By FIRST_WINDOWS_SIGN_IN_BTN								= 	By.name("SIGN IN");
	
	public By WELCOME_SKIP_TUTORIAL_BTN								= 	By.name("SKIP TUTORIAL");
	
	public By FIRST_SCREEN_SETTING_BTN							=	By.name("Configure my account");
	
	public By CONTACT_TAB_SCREEN_ADD_CONTACT_BTN				=	By.name("Create New Contact");
	public By ADD_CONTACT_SCREEN_FISRT_NAME_TXT					=	By.xpath("//*[@AutomationId = 'FirstNameTextBox']");
	//public By ADD_CONTACT_SCREEN_LAST_NAME_TXT					=	By.name("Last Name");
	public By ADD_CONTACT_SCREEN_LAST_NAME_TXT					=	By.xpath("//*[@Name='Last Name']/..");
	//public By ADD_CONTACT_SCREEN_COMPANY_TXT					=	By.name("Company");
	public By ADD_CONTACT_SCREEN_COMPANY_TXT					=	By.xpath("//*[@Name='Company']/..");
	public By ADD_CONTACT_SCREEN_DONE_BTN						=	By.name("DONE");
	//public By ADD_CONTACT_SCREEN_EDIT_BTN						=	By.name("Edit");
	public By ADD_CONTACT_SCREEN_EDIT_BTN						=	By.xpath("//*[@Name='Edit']//*[@Name='Edit']");
	public By ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT				=	By.xpath("//*[@AutomationId = 'PhoneNumberPlaceholder']/..");
	//public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.id("PART_TextBoxEx");
//	public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'PART_TextBoxEx'][2]");
	public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'PART_TextBoxEx']");
	public By ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'EmailPlaceholder']/..");

	public By ADD_CONTACT_SCREEN_ADD_CONTACT_BTN				=	By.name("Add Contact");
	public By ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN				=	By.id("CancelAddContactButton");
	public By ADD_CONTACT_SCREEN_ADD_CONTACT_PLUS_BTN			=	By.name("Add New Contact");
	public By ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN	=	By.xpath("//*[@AutomationId='VerticalSmallIncrease']");	

	public By CONTACT_TAB_SCREEN_SEARCH_CONTACT_TXT				=	By.className("TextBlock");
	
	public By CONTACT_BUBBLE									=	By.id("ContactsStatusChatButton");
	public By CONTACT_BUBBLE_IN_CONTACT_DETAILS
	= 	By.xpath("//*[@Name = 'Send a Message' and @LocalizedControlType = 'group']//*[@ClassName = 'Button' and @LocalizedControlType = 'button'][3]");
	public By CONTACT_DETAIL_BTN (String user)					{ return By.id("ContactDetailsButton(" + user + ")");}
	public By CONTACT_OPEN_CONTACT_DETAILS						=	By.name("Open Contact Details");
	
	public By CONTACT_IN_CONTACT_LIST(String user) {
		return By.xpath("//*[@AutomationId='ContactsListBox']//*[@Name='"+user+"']");
	}
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@Name='Start New Conversation']/..");
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@ClassName='Button']/*[@Name='Start New Conversation']");
	//public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION 	= 	By.name("Continue Existing Conversation");
	public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION(String convName) 	{ return 	By.name(convName);}
//	public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION(String convName) 	{ return 	By.xpath("//*[@Name='" + convName + "']");}
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.name("Start New Conversation");
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.id("StartNewConversationTextBlock");/*[contains(@Name,'Start New Conversation')]
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@ClassName='Popup']/*[@ClassName='Button'][2]");
	public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.name("WORK");
	//===============================================================NEW KEYWORDS=================================================
	//Huy Dao
	public By SETTING_WINDOWS_ACCOUNT_SETTING_TOGGLE_SWITCH 		=	By.id("OnOffSettingToggleSwitchButton");
	public By SETTING_WINDOWS_LDAP_SERVER = By.id("LdapServerAddressAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_LDAP_PORT = By.id("LdapPortAutomationIdNumericSettingTextBox");
/*	public By SETTING_WINDOWS_SERVER_ADDRESS (String server)
	{return By.xpath("//*[@Previous='Server Address']");}
	
	public By SETTING_WINDOWS_SERVER_PORT (String port)
	{return By.xpath("//*[contains(@Name,'"+port+"')]/[contains(@Previous,'Server Port')]");}
	*/
	
	
	public By SETTING_WINDOWS_CLOSE_BTN = By.xpath("//*[contains(@Name,'Avaya Engage Settings')]/*[contains(@Name,'Close Window')]");
	
	
	public By SEARCH_ENTERPRISE_DIRECTORY_RESULT (String name){
	return By.xpath("//*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]")
			;}
	
	
	public By CONTACT_LIST_CONTACT_NAME (String name){
		return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+name+"')]");
	}
	
	public By FAVORITE_LIST_CONTACT_NAME (String name){
		return By.xpath("//*[contains(@Name,'Favorites list')]//*[contains(@Name,'"+name+"')]");
	}
	
	public By CONTACT_LIST_CONTACT_STATUS (String name){
		return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+name+"')]/*[@AutomationId = 'ContactsStatusTextBlock']");
	}
	
	public By CONTACT_LIST_CONTACT_DETAIL (String name){
		return By.id("ContactDetailsButton("+name+")");
		//return By.xpath("//*[contains(@Name,'"+name+"')]//*[contains(@Name,'Details')]");
		
	}
	
	public By CONTACT_LIST_REMOVE_CONTACT = By.name("Remove contact");
	public By CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES = By.name("Yes");
//	public By CONTACT_LIST_CANCLE_SEARCH_BTN	=	By.id("UnifiedSearchCancelButton");
	public By CONTACT_LIST_CANCLE_SEARCH_BTN = By.name("Cancel");
//	public By CONTACT_LIST_CANCLE_SEARCH_BTN = By.xpath("//*[@Name='Cancel']");
	
	public By CALL_HISTORY_CONTACT_NAME = By.name("name");
	
	
	
//	public By CALL_HISTORY_CONTACT_NAME (String name){
//	return By.xpath("//*[starts-with(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.CallHistory.CallHistor')]/*Text[@Name='"+name+"')]");
//	}
	public By CALL_HISTORY_CONTACT_NAME (String name){
	return By.xpath("//*[contains(@AutomationId,'DisplayNameTextBlock("+name+")')]");
	}
	
	
	public By settingWindowsTabLocators(String tabName)									{	return By.name(tabName);}
	public By settingWindowsOptionsInsideTabLocators(String option) 					{	return By.name(option);}
	public By SETTING_WINDOWS_BACK_BTN													=	By.name("Back");
	public By SETTING_WINDOWS_DONE_BTN													=	By.name("DONE");//"Close Window"
	public By SETTING_WINDOWS_UPDATE_BTN												=	By.name("UPDATE");
	public By SETTING_WINDOWS_OK_BTN													=	By.name("OK");
	
	public By SETTING_WINDOWS_SUPPORT_TAB_CLEAR_ALL_SETTING_BTN							=	By.name("Reset Application");
	public By SETTING_WINDOWS_SUPPORT_TAB_CLEAR_ALL_SETTING_CONFIRM_BTN					=	By.name("Clear");
	
	public By SETTING_WINDOWS_SERVICES_OK_BTN											=	By.xpath("//*[@Name = 'OK' and @LocalizedControlType = 'text']");
	public By SETTING_WINDOWS_SERVICES_UPDATE_BTN										=	By.xpath("//*[@Name = 'Update' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_CANCEL_BTN										=	By.xpath("//*[@Name = 'Cancel' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_CHECK_STATUS(String num)							{	return	By.xpath("//*[@Name = '"+ num+"' and @LocalizedControlType = 'text']");}
	
	public By SETTING_WINDOWS_SERVICES_TAB_REFESH_AUTOCONFIGURE							=	By.xpath("//*[@Name = 'Refresh Auto Configuration' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_TAB_AUTO_CONFIGURE_BTN							=	By.name("Auto configure");
	public By SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN								=	By.name("Show Details");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_SV_ADDRESS_TXT				=	By.id("SipServerAddressTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_DOMAIN_TXT					=	By.id("SipDomainTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_SV_PORT_TX					=	By.id("SipServerPortNumericSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_ON_OFF_TOGGLE								=	By.id("OnOffSettingToggleSwitchButton");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_SV_ADDRESS_TXT							=	By.id("AmmServerAddressTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_SV_PORT_TXT								=	By.id("AmmPortNumericSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_COMBO_BOX_BTN		=	By.id("RefreshTimeListSettingComboBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST1				=	By.id("RefreshTimeListSettingComboBoxItem1"); //continuous
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST2				=	By.id("RefreshTimeListSettingComboBoxItem2"); //1 minute
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST3				=	By.id("RefreshTimeListSettingComboBoxItem3"); //2 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST4				=	By.id("RefreshTimeListSettingComboBoxItem4"); //5 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST5				=	By.id("RefreshTimeListSettingComboBoxItem5"); //15 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST6				=	By.id("RefreshTimeListSettingComboBoxItem6"); //60 minutes
	
	public By SETTING_WINDOWS_ACCOUNT_TAB_COMMUNICATOR_USERNAME_TXT						=	By.id("CommunicatorUsernameAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_ACCOUNT_TAB_COMMUNICATOR_PASSWORD_TXT						=	By.id("CommunicatorPasswordAutomationId");
	public By SETTING_WINDOWS_ACCOUNT_TAB_PHONE_EXTENSION_TXT							=	By.id("SipExtensionAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_ACCOUNT_TAB_PHONE_PASSWORD_TXT							=	By.id("SipPasswordAutomationId");
	public By SETTING_WINDOWS_ACCOUNT_TAB_SIGN_OUT_BTN									=	By.name("SIGN OUT");
	
	
	public By MAIN_WINDOWS_TITLE									=	By.id("DefaultWindowTitleTemplate");
	//public By MAIN_WINDOWS_OPEN_SETTING_BTN							=	By.id("DashboardOpenSettingsButton");
	public By MAIN_WINDOWS_OPEN_SETTING_BTN							=	By.name("Options and Settings");
	public By MAIN_WINDOWS_TOP_OF_MIND_BTN							=	By.id("TabBarHomeContentToggleButton");
	public By MAIN_WINDOWS_FAVORITES_BTN							=	By.id("TabBarFavoritesContentToggleButton");
	public By MAIN_WINDOWS_FAVORITES_ICON_ENABLED(String user)	
	{	return By.xpath("//*[@AutomationId='ContactFavoriteButton(" + user + ")' and @HelpText='Remove from Favorites']");}
	public By MAIN_WINDOWS_FAVORITES_ICON_DISABLED(String user)	
	{	return By.xpath("//*[@AutomationId='ContactFavoriteButton(" + user + ")' and @HelpText='Add to Favorites']");}
	//public By MAIN_WINDOWS_CONTACT_BTN								=	By.id("TabBarContactsContentToggleButton");
	public By MAIN_WINDOWS_CONTACT_BTN								=	By.name("Contacts");
	
	public By MAIN_WINDOWS_CONTACT_LIST_BOX								=	By.id("ContactsListBox");

	
	public By MAIN_WINDOWS_HISTORY_BTN								=	By.id("TabBarCallHistoryContentToggleButton");
	public By MAIN_WINDOWS_CALENDAR_BTN								=	By.id("TabBarCalendarContentToggleButton");
	public By MAIN_WINDOWS_CONVERSATIONS_BTN						=	By.id("TabBarConversationsContentToggleButton");
	public By MAIN_WINDOWS_NUMBER_OF_NEW_MSG_BADGE
	=	By.xpath("//*[@AutomationId='TabBarConversationsContentToggleButton']/..//*[@ClassName='NumberBadgeControl']//*[@ClassName='TextBlock']");
	public By MAIN_WINDOWS_AVATAR_BTN								=	By.id("UserDashboardOpenAvatarButton");
	public By MAIN_WINDOWS_CLOSE_AVATAR_BTN								=	By.id("PresencePopupCloseAvatarButton");
	public By MAIN_WINDOWS_SIGN_OUT_TEXT							= 	By.id("PresencePopupLogOutTextBlock");
	public By MAIN_WINDOWS_NEW_CONVERSATION_BTN						= 	By.name("New Conversation");
	public By MAIN_WINDOWS_NEW_CONVERSATION_BUBBLE					=	By.xpath("//*[@HelpText='Message']");
	//public By MAIN_WINDOWS_STATUS_COMBO_BOX = By.xpath("//*[@ClassName='ComboBox']");
	public By MAIN_WINDOWS_STATUS_COMBO_BOX = By.className("ComboBox");
	public By MAIN_WINDOWS_STATUS_AVAILABLE = By.name("Available");
	public By MAIN_WINDOWS_STATUS_AWAY = By.name("Away");
	public By MAIN_WINDOWS_STATUS_BUSY = By.name("Busy");
	public By MAIN_WINDOWS_STATUS_DND = By.name("Do not disturb");
	public By MAIN_WINDOWS_STATUS_OFFLINE = By.name("Offline");
	public By MAIN_WINDOWS_STATUS_OUTOFFICE = By.name("Out of office");
	public By mainwindowsstatus(String status){
		return By.name(status);
	}
	public By mainwindowsstatusSelected(String status) {
		
		return By.xpath("//*[@Name='Avaya.UCC.ViewModels.Presence.PresenceItem']");//*[@Name='"+status+"']/..
	}

//	public By equinoxInTaskbar = By.xpath("//*[@Name = 'Avaya Equinox' and @LocalizedControlType = 'menu item']");
	public By equinoxInTaskbar = By.name("Avaya Equinox - 3 running windows");
	public By equinoxConversationInTaskbar(String convName)	
	{	return By.xpath("//*[@Name = '" + convName + "' and @LocalizedControlType = 'list item']");}
	public By onexInTaskbar = By.xpath("//*[@Name = 'Avaya one-X Communicator' and @LocalizedControlType = 'menu item']");
	public By onexConversationInTaskbar(String convName)	
	{	return By.xpath("//*[@Name = '" + convName + "' and @LocalizedControlType = 'button']");}
	
	public By onexWindowInTaskBar	= By.name("Avaya one-X® Communicator");
	
    public By ACW_LOGIN_DIALOG_TXT_OPEN_CONFIRM_QUESTION = By.name("Other Avaya Equinox instances are detected");
    public By ACW_LOGIN_DIALOG_BTN_YES = By.xpath("//*[@AutomationId='6']");
    public By ACW_LOGIN_DIALOG_BTN_NO = By.xpath("//*[@AutomationId='7']");
    public By mainWindowsContactsTabUserLocators(String user)	
    {	return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+user+"')]");}
    
	public By mainWindowsContactsTabUserLocatorsAfterSearch(String user)	
	{	return By.xpath("//*[@Name='Search Results']//..//*[@Name='" + user + "']");}

	public By CONTACT_LIST_CONTACT_RESULT (String name){
		return By.xpath("//*[contains(@Name,'CONTACTS')]/following-sibling::*[contains(@Name,'Search Results')]//*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]");
	}
	
	public By conversationWindowsFileNameLocator(String fileName)			
	{	return By.name(fileName);}
	
	
	public By CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM (String user) { return By.xpath("//*[@AutomationId='ContactDisplayName' and @Name='"+user+"']");}
	
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_TXT				=	By.id("TextBoxEx");
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_DONE_BTN			=	By.name("Done");
	public By CONVERSATION_WINDOWS_TITLE								=	By.id("DefaultWindowTitleTemplate"); // get Name to have displayed title
	public By CONVERSATION_WINDOWS_TEXT_MSG_TXT							=	By.id("MessageRichTextBox");
	public By CONVERSATION_WINDOWS_MSG_BOX								=	By.id("MessagesListBox");
	public By CONVERSATION_WINDOWS_ATTACHMENT_BTN						=	By.id("AddMessageAttachmentDataTemplateContentButton");
	public By CONVERSATION_WINDOWS_ADD_PARTICIPANTS_TXT					=	By.name("Add Participant(s)...");
	public By CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT					=	By.id("SearchTextBox");
	public By CONVERSATION_WINDOWS_ADD_ITEM_BTN							= 	By.id("ItemButton");
	public By CONVERSATION_WINDOWS_ADD_USER_BTN							=	By.className("ListBoxItem");
	
	public By CONVERSATION_WINDOWS_MENU_BTN								=	By.id("ConversationsWindowMenu");
	public By CONVERSATION_WINDOWS_MENU_LEAVE_CONVERSATION_BTN			=	By.id("ConversationsMenuItemLeaveConversation");
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_BTN				=	By.id("ConversationsMenuItemEditSubject");
	public By CONVERSATION_WINDOWS_MENU_PHONE_CALL_MENU_BTN				=	By.id("PhoneCallButton");
	public By CONVERSATION_WINDOWS_MENU_VIDEO_CALL_MENU_BTN				=	By.id("VideoCallButton");
	public By CONVERSATION_WINDOWS_MENU_PHONE_NUMBER_TEXT_BLOCK_BTN		=	By.id("ItemButton");
	public By CONVERSATION_WINDOWS_MENU_PHONE_START_VOICE_CONFERENCE_BTN = By.xpath("//*[@Name='Start a Voice Conference']");
	public By mainWindowsContactsTabUserActionLocators(String action, String user)					{	return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+user+"')]//*[contains(@Name,'"+action+"')]");}

	
	public By CONVERSATION_WINDOWS_ADD_USER_CONFIRM_ADD_BTN						=	By.name("Add");
	public By CONVERSATION_WINDOWS_ADD_USER_CONFIRM_CANCEL_BTN					=	By.name("Cancel");

	
	  public By ONE_X_MAIN_WINDOW_TXT_FIELD = By.xpath("//*[@AutomationId = 'TextBoxSearch']");
	    public By ONE_X_MAIN_WINDOW_BTN_DIAL = By.xpath("//*[@AutomationId = 'ButtonDia']");
	    
	    public By ONE_X_MAIN_WINDOW_BTN_END = By.xpath("//*[@AutomationId = 'ButtonEnd']");
	  //  public By ONE_X_MAIN_WINDOW_BTN_MENU = By.id("ButtonMenu");
	    public By ONE_X_MAIN_WINDOW_BTN_MENU =  By.xpath("//*[@LocalizedControlType='pane']/*[@AutomationId = 'ButtonMenu']");
	    public By ONE_X_MENU_BTN_LOG_OUT = By.name("Log Out");
	    public By ONE_X_MENU_BTN_YES = By.name("Yes");
	    public By ONE_X_MENU_BTN_EXIT = By.name("Exit");
	    
	    //
	    public By ONE_X_LOGIN_WINDOW_TXT_USER = By.xpath("//*[@AutomationId = 'TextBoxUser']");
	    public By ONE_X_LOGIN_WINDOW_TXT_PWD = By.xpath("//*[@AutomationId = 'PasswordBoxUser']");
	    //public By ONE_X_INCOMING_CALL_BTN_ANSWER = By.id("ButtonAnswer");
	    public By ONE_X_INCOMING_CALL_BTN_ANSWER = By.xpath("//*[@AutomationId = 'ButtonHold']");
	    public By ONE_X_INCOMING_CALL_BTN_HOLD = By.xpath("//*[@AutomationId = 'ButtonHold']");
	    public By ONE_X_INCOMING_CALL_BTN_MUTE = By.xpath("//*[@AutomationId = 'ButtonMute']");
	    public By ONE_X_INCOMING_CALL_BTN_TRANSFER = By.xpath("//*[@AutomationId = 'ButtonTransfer']");
	    public By ONE_X_TRANSFER_CALL_TXT_PHONE_NUMBER = By.xpath("//*[@AutomationId = 'TextBoxSearch']");
	    public By ONE_X_TRANSFER_CALL_BTN_OK = By.name("OK");
	    
	    public By ONE_X_STATUS_ICON = By.xpath("//*[@AutomationId = 'ImageStatusIcon'] ");
	    
	    public By onexContact (String contact){
	    	return By.xpath("//*[@Name = onexcui.Info.Contacts.Contact]//*[contains(@Name, '"+contact+"')]");
	    }
	    
	    public By oneXContactStatus (String contact){
	    	return By.xpath("//*[@Name = onexcui.Info.Contacts.Contact]//*[contains(@Name, '"+contact+"')]/../..//*[@AutomationId='ImageStatusIcon']");
	    }
	    
	    public By oneXContactBubbleIcon(String contact){
	    	return By.xpath("//*[@Name = onexcui.Info.Contacts.Contact]//*[contains(@Name, '"+contact+"')]/../..//*[@AutomationId='ButtonChat']");
	    }
	    
	    public By ONE_X_FIRST_WINDOWS_LOGIN_BTN							=	By.name("Log In");
	    
	    public By ACW_CALL_BTN_MAKE_VOICE_CALL = By.id("PART_MakeAVoiceCallButton");
	    public By ACW_CALL_BTN_DROP_CALL = By.name("Drop");
	    public By ACW_CALL_BTN_ANSWER_CALL = By.name("Answer");
	    public By ACW_CALL_BTN_HOLD_CALL = By.name("Pause");
	    public By ACW_CALL_BTN_RESUME_CALL = By.name("Pause");
	    public By ACW_CALLER_INFO = By.xpath("//*[AutomationId = 'CallStackListBoxItem1']/../*[contains(@AutomationId, 'CaIncomingDisplayName')]");
	    public By FILTER_LIST_HISTORY = By.xpath("//Button[@AutomationId='StateButton']");
	    public By acw_callee_info(String name) {
	        return By.name(name);
	    }
	    
	    public By TITLE_BTN(String tabName){
	    	return By.xpath("//*[@Name='"+tabName+"' and @ClassName='TextBlock']");
	    }
	    public By TEXT_TITLE_BTN(String tabName){
	    	return By.xpath("//Button[@Name='"+tabName+"']");
	    }
	    public By BUTTON_TITLE_BTN(String tabName){
	    	return By.xpath("//Button[@Name='"+tabName+"']");
	    }
	    
		public By OUTGOMING_CALL_BOX				=	By.id("CallStackListBoxItem4");
		public By OUTGOING_CALL_DROP_BTN		    =	By.name("Drop");
		
		public By SEARCH_CONTACT_LOCAL_CONTACT_TITLE_BAR = By.xpath("//*[contains(@Name,'CONTACTS')]");
		

		public By search_contact_local_result (String name) {
			return By.xpath("//*[contains(@Name,'CONTACTS')]//following-sibling::*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]");
		}
	    
}

