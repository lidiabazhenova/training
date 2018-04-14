package com.catalog.loader;

public class LoaderFactory {

    public enum FileType {
        CSV,
        EXCEL
    }

    public AutomobileLoader createLoader(FileType fileType, String path) {
        if (FileType.CSV == fileType) {
            return new CSVAutomobileLoader(path);
        } else if (FileType.EXCEL == fileType) {
            throw new UnsupportedOperationException("Load from Excel file is not implemented yet.");
        } else {
            throw new IllegalArgumentException("File type '" + fileType + "' is not supported");
        }
    }
}
