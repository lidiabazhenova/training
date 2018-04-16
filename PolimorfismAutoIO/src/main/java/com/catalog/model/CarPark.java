package com.catalog.model;

import com.catalog.comparator.AutomobilePriceComparator;
import com.catalog.comparator.AutomobileVelocityComparator;
import com.catalog.loader.AutomobileLoader;
import com.catalog.loader.CSVAutomobileLoader;
import com.catalog.loader.LoaderFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class for objects with property automobiles
 *
 * @author lidia
 * @version 1.0
 */
public class CarPark {
    private List<Automobile> automobiles;

    /**
     * Create new empty object
     */
    public CarPark() {
        automobiles = new ArrayList<Automobile>();
    }

    /**
     * Method for getting car park
     *
     * @return collection of  automobiles
     */
    public List<Automobile> getAutomobiles() {
        return Collections.unmodifiableList(automobiles);
    }

    /**
     * Method for addition automobiles into car park
     *
     * @param automobile collection of automobiles
     */
    public void add(Automobile automobile) {
        automobiles.add(automobile);
    }

    /**
     * Method for loading automobiles into car park from csv-file
     *
     * @param fileType file type
     * @param paths list of paths
     * @throws IOException
     */
    public void loadAutomobilesFromFile(LoaderFactory.FileType fileType, List<String> paths) throws IOException, InvalidFormatException {
        LoaderFactory loaderFactory = new LoaderFactory();

        for (String path: paths) {
            AutomobileLoader loader = loaderFactory.createLoader(fileType, path);
            automobiles.addAll(loader.load());
        }
    }

    /**
     * * Method for selling automobiles from car park
     *
     * @param automobile collection of automobiles
     */
    public void sell(Automobile automobile) {
        automobiles.remove(automobile);
    }

    /**
     * * Method for printing automobiles from car park
     */
    public void printList() {
        if (automobiles.isEmpty())
            System.out.println("Empty list of automobiles");
        else {

            for (Automobile car : automobiles) {
                System.out.print(car.getDescription());
                System.out.println("***");
            }
        }
    }

    /**
     * Method for getting the most expensive automobile
     *
     * @return the most expensive automobile
     */
    public Automobile getTheMostExpensiveAutomobile() {
        return Collections.max(automobiles, new AutomobilePriceComparator());
    }

    /**
     * Method for getting the most high-speed automobile
     *
     * @return the most high-speed automobile
     */
    public Automobile getTheMostHighSpeedAutomobile() {
        return Collections.max(automobiles, new AutomobileVelocityComparator());
    }
}
