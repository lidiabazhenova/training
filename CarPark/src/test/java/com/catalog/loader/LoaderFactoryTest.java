package com.catalog.loader;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoaderFactoryTest {

    @Test
    public void testCSVLoader() {
        LoaderFactory loaderFactory = new LoaderFactory();
        AutomobileLoader automobileLoader = loaderFactory.createLoader(
                LoaderFactory.FileType.CSV);
        assertTrue((automobileLoader instanceof CSVAutomobileLoader));
    }

    @Test
    public void testExcelLoader() {
        LoaderFactory loaderFactory = new LoaderFactory();
        AutomobileLoader automobileLoader = loaderFactory.createLoader(
                LoaderFactory.FileType.EXCEL);
        assertTrue((automobileLoader instanceof ExcelAutomobileLoader));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLoader() {
        LoaderFactory loaderFactory = new LoaderFactory();
        loaderFactory.createLoader(null);
    }
}
