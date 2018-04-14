package com.catalog.loader;

import com.catalog.model.Automobile;

import java.util.ArrayList;
import java.util.List;

public class ExcelAutomobileLoader  implements AutomobileLoader {

    private static final String CSV_FILE_PATH = "C:\\projects\\training" +
            "\\PolimorfismAutoIO\\src\\main\\resources\\Automobiles.xlsx";

    public List<Automobile> load() {
        List<Automobile> automobilesFromFile = new ArrayList<Automobile>();


        return automobilesFromFile;
    }

}
