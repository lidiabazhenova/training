package com.catalog.loader;

/**
 * Class for generation object of concrete class based on given information.
 *
 * @author lidia
 * @version 1.0
 */
public class LoaderFactory {

    public enum FileType {
        CSV,
        EXCEL
    }

    /**
     * Method for creating loader in depending on the type of file
     * @param fileType file type
     * @return loader
     */
    public AutomobileLoader createLoader(FileType fileType) {
        if (FileType.CSV == fileType) {
            return new CSVAutomobileLoader();
        } else if (FileType.EXCEL == fileType) {
            return new ExcelAutomobileLoader();
        } else {
            throw new IllegalArgumentException("File type '"
                    + fileType + "' is not supported");
        }
    }
}
