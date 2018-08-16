package reportsTestday6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class HSSFSheetCraeteLead {

	
	private HSSFSheet sheetname;
	private int lastRowNum;
	private short lastCellNum;
	private HSSFRow row;
	private HSSFCell cell;
	private HSSFWorkbook HWB;

	
	//Create one object for the workbook
	public Object[][] OpenHSSFSheet(String FileName )  {
		
		
		try {
			//open the workbook from the file path
			HWB = new HSSFWorkbook(new FileInputStream(new File("./WorkBook/"+FileName+"./xls")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//go to the sheet
		sheetname = HWB.getSheetAt(0);
		//initiate row
		lastRowNum = sheetname.getLastRowNum();
		//initiate column
		lastCellNum = sheetname.getRow(0).getLastCellNum();
		//create the object for row and column
		Object[][] data=new Object[lastRowNum][lastCellNum];
		//Read the data from row and column
		for(int i=0;i<=lastRowNum;i++) {
			row = sheetname.getRow(i);
			for(int j=1;j<=lastCellNum;j++) {
				
				cell = row.getCell(j);
				
				data[i-1][j] = cell.getStringCellValue();
				
			}
			try {
				HWB.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return data;		
	}
}
