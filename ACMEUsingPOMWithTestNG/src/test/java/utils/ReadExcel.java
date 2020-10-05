package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String [][] sendData(String filename) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		short cellcount = ws.getRow(0).getLastCellNum();
		String [][] data = new String [rowcount][cellcount];
		for (int i=1; i<=rowcount; i++) {
			for (int j=0; j<cellcount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
	}
}
