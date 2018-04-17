package com.catalog.loader;

import com.catalog.exception.LoaderException;
import com.catalog.model.Automobile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Interface
 * @author lidia
 * @version 1.0
 */
public interface AutomobileLoader {

    /**
     * Method for loading automobiles from file
     * @return list of automobiles
     * @throws LoaderException exceptions during load from the file
     */
    List<Automobile> load() throws LoaderException;

}
