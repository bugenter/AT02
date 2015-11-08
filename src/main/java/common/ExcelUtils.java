package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private HSSFRow Row;

	/**
	 * set the File path and to open the Excel file
	 * @param Path
	 * @param SheetName
	 * @throws Exception
	 */
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}

	/**
	 * Read the test data from the Excel cell
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @throws Exception
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			System.out.print(CellData+"\n");
			return CellData;
		}catch (Exception e){
			return"";
		}

	}

	/**
	 * write in the Excel cell
	 * @param Result
	 * @param RowNum
	 * @param ColNum
	 * @throws Exception
	 */
	public void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
		try{
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}

}