package com.catalog;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven {

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;



    public static String getCelldata(int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\training\\PolimorfismAutoIO\\src\\main\\resources\\Automobiles.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("Car");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);

        return cell.getStringCellValue();
    }

    public static String setCelldata(String text, int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\training\\PolimorfismAutoIO\\src\\main\\resources\\Automobiles.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("screen");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);
        cell.setCellValue(text);

        return cell.getStringCellValue();
    }
}
