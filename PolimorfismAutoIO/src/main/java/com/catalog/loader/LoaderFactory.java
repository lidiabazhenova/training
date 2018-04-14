package com.catalog.loader;

public class LoaderFactory {

    public enum FileType {
        CSV,
        EXCEL
    }

    public AutomobileLoader createLoader(FileType fileType, String directory) {
        if (FileType.CSV == fileType) {
            return new CSVAutomobileLoader();
        } else if (FileType.EXCEL == fileType) {
            return new ExcelAutomobileLoader();
        } else {
            throw new IllegalArgumentException("File type '" + fileType + "' is not supported");
        }
    }
}
