package com.catalog.loader;

/**
 * Class for generation object of concrete class based on given information.
 * @author lidia
 * @version 1.0
 */
public class LoaderFactory {

    public enum FileType {
        CSV,
        EXCEL
    }

    public AutomobileLoader createLoader(FileType fileType, String path) {
        if (FileType.CSV == fileType) {
            return new CSVAutomobileLoader(path);
        } else if (FileType.EXCEL == fileType) {
            return new ExcelAutomobileLoader(path);
        } else {
            throw new IllegalArgumentException("File type '" + fileType + "' is not supported");
        }
    }
}
