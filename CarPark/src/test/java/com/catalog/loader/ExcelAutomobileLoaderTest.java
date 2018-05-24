package com.catalog.loader;

import com.catalog.exception.LoaderException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelAutomobileLoaderTest {

    private static final String EXCEL_FILE_PATH
            = "src/test/resources/Automobiles.xlsx";

    @Test
    public void testNumberOfRowsInExcel() throws LoaderException {
        ExcelAutomobileLoader excelAutomobileLoader
                = new ExcelAutomobileLoader();

        assertEquals(5, (excelAutomobileLoader.load(EXCEL_FILE_PATH)).size());
    }
}
