package excel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExcelData {
	final static Logger logger = LogManager.getLogger("Excel");

	public String getNetworkData(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_NETWORKDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getLabInfo(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_LABDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getConfigurationSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_CONFIGSETTING, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getTestSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_TEST, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}
	}
	
	public String getCellFromFreeExcel(String linktoexcelfile,String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(linktoexcelfile, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	public String searchString(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,0);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public String searchStringAndroid(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,2);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public String searchStringIos(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,4);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String searchResult(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,1);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public String searchResultAndroid(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,3);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public String searchResultIos(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,5);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String User_Switch_MAIL(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,2);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String User_Switch_DN(int row, String sheet){try {
		String ID=getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheet,row,3);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	

}
