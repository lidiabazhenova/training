package com.catalog.loader;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoaderFactoryTest {

    private static final String CSV_FILE_PATH
            = "src/test/resources/cars-with-header.csv";
    private static final String EXCEL_FILE_PATH
            = "src/test/resources/Automobiles.xlsx";

    @Test
    public void testCSVLoader() {
        LoaderFactory loaderFactory = new LoaderFactory();
        AutomobileLoader automobileLoader = loaderFactory.createLoader(
                LoaderFactory.FileType.CSV, CSV_FILE_PATH);
        assertTrue((automobileLoader instanceof CSVAutomobileLoader));
    }

    @Test
    public void testExcelLoader() {
        LoaderFactory loaderFactory = new LoaderFactory();
        AutomobileLoader automobileLoader = loaderFactory.createLoader(
                LoaderFactory.FileType.EXCEL, EXCEL_FILE_PATH);
        assertTrue((automobileLoader instanceof ExcelAutomobileLoader));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLoader() throws IllegalArgumentException {
        LoaderFactory loaderFactory = new LoaderFactory();
        AutomobileLoader automobileLoader = loaderFactory.createLoader(
                null, EXCEL_FILE_PATH);
        assertTrue((automobileLoader instanceof ExcelAutomobileLoader));
    }
}
