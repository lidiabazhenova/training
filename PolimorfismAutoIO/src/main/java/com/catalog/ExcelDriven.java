package com.catalog;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;



    public static String getCelldata(int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\training\\PolimorfismAutoIO\\src\\main\\resources\\Automobiles.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Car");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);

        return cell.getStringCellValue();
    }

    public static String setCelldata(String text, int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\training\\PolimorfismAutoIO\\src\\main\\resources\\Automobiles.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("screen");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);
        cell.setCellValue(text);

        return cell.getStringCellValue();
    }

    //TODO:
    // } finally {
    //try{inFile.close();}catch(IOException e){};
    //}
}
