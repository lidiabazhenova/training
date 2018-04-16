package com.catalog.loader;

import com.catalog.model.Automobile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AutomobileLoader {

    List<Automobile> load() throws IOException, InvalidFormatException;

}
