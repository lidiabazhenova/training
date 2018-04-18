package com.catalog.loader;

import com.catalog.exception.LoaderException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CSVAutomobileLoaderTest {

    private static final String CSV_FILE_PATH
            = "src/test/resources/cars-with-header.csv";

    @Test
    public void testNumberOfAutomobilesInCSV() throws LoaderException {
        CSVAutomobileLoader csvAutomobileLoader
                = new CSVAutomobileLoader(CSV_FILE_PATH);

        assertEquals(2, (csvAutomobileLoader.load()).size());
    }
}
