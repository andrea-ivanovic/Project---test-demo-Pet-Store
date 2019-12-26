package excelU;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	private static HSSFWorkbook wb = null;
	private static HSSFSheet sheet = null;
	private static String excellPath;

	
	//path to Excell
	public static boolean setExcell(String path) {
		if (wb != null) {
			try {
				wb.close();
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
		}
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);

			wb = new HSSFWorkbook(fis);
			excellPath = path;
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("File can't be opened.");
			return false;
		}
	}

	//choose a sheet index 
	public static boolean setWorkSheet(int index) {
		try {
			sheet = wb.getSheetAt(index);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Worksheet can't be opened.");
			return false;
		}
	}

	//choose a sheet by name
	public static boolean setWorkSheet(String name) {
		try {
			sheet = wb.getSheet(name);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Worksheet can't be opened.");
			return false;
		}
	}

	//get cell String data
	public static String getDataStr(int row, int column) {
		try {
			HSSFRow r = sheet.getRow(row);
			HSSFCell cell = r.getCell(column);
			return cell.toString();
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			System.out.println("Null");
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error");
		}
		return "";
	}

	//get cell integer data
	public static int getDataNum(int row, int column) {
		try {
			HSSFRow r = sheet.getRow(row);
			HSSFCell cell = r.getCell(column);
			return (int) cell.getNumericCellValue();
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			System.out.println("Null");
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error");
		}
		return 0;
	}

	//add data to a cell
	public static boolean setDataAt(int row, int column, String data) {
		try {
			HSSFRow r = sheet.getRow(row);
			if (r == null) {
				r = sheet.createRow(row);
			}
			HSSFCell cell = r.getCell(column);
			if (cell == null) {
				cell = r.createCell(column);
			}
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excellPath);
			wb.write(fos);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error");
			return false;
		}
	}

	//get total number of rows in the sheet
	public static int getRowNumber() {
		try {
			return sheet.getLastRowNum() + 1;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error");
			return -1;
		}
	}

	
	//get total number of columns in the sheet
	public static int getColumnNumber() {
		try {
			return sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error");
			return -1;
		}

	}

	//close Excell file
	public static boolean closeExcell() {
		if (wb != null) {
			try {
				wb.close();
				wb = null;
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				wb = null;
				return false;
			}

		}
		return true;
	}

}
