package dataProviderFactorry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider(){//we create constructor to access the class
		try{// for in case we get any error to get the dir
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx")));
		}catch(IOException e){
			System.out.println("Unable to read Excel Data"+e.getMessage());
			
		}
	}
	//read from excel
	public String getCellData(String sheetName, int row,int col)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);// go to my excel file go to cell get the sheet name go to column get the value
		
		String data =null;// if any empty cell I dont want he value  of that cell telling to skip
		
		if(cell.getCellTypeEnum()==CellType.STRING)//it is getting the cell type if string get it 
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)// get the numeric vlaue
		{
			data = String.valueOf((int)cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)//if empty do not get anything
		{
			data="";
		}
		return data;
				
	}
	public int getRows(String sheetName)//for increasing cell , it will go to te sheet
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();//ut will pick up physical num lof rows like how many rows
	}
	public int getColumns(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();//its going to the 0th row and get the value from that row
	}

}
