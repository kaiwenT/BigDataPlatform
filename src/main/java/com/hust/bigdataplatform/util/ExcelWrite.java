package com.hust.bigdataplatform.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelWrite {

	/**
	 * 只有一个sheet
	 * @param lists
	 * @return
	 */
	public static HSSFWorkbook exportToExcel(@SuppressWarnings("unchecked") List<List<String>> lists) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet" + 1);
		for (int i = 0; i < lists.size(); i++) {
			List<String> rowList = lists.get(i);
			Row row = sheet.createRow(i);
			for (int j = 0; j < rowList.size(); j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(rowList.get(j));
			}
		}
		
		return workbook;
	}
}
