package com.catalog;

import com.catalog.exception.LoaderException;
import com.catalog.loader.AutomobileLoader;
import com.catalog.loader.LoaderFactory;
import com.catalog.model.Automobile;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class contains methods for use automobiles in car park
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
        automobiles = new ArrayList<>();
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
     * @param paths    list of paths
     * @throws LoaderException exceptions during load the car park from the file
     */
    public void loadAutomobilesFromFile(LoaderFactory.FileType fileType, List<String> paths) throws LoaderException {
        LoaderFactory loaderFactory = new LoaderFactory();

        for (String path : paths) {
            AutomobileLoader loader = loaderFactory.createLoader(fileType);
            automobiles.addAll(loader.load(path));
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
        if (CollectionUtils.isEmpty(automobiles))
            System.out.println("Empty list of automobiles");
        else {
            automobiles.forEach((car) -> {
                System.out.print(car.getDescription());
                System.out.println("***");
            });
        }
    }

    /**
     * Method for getting the most expensive automobile
     *
     * @return the most expensive automobile
     */
    public Automobile getTheMostExpensiveAutomobile() {
        return Collections.max(automobiles, (automobile1, automobile2) -> ((Double) automobile1.getPrice())
                .compareTo(automobile2.getPrice()));
    }

    /**
     * Method for getting the most high-speed automobile
     *
     * @return the most high-speed automobile
     */
    public Automobile getTheMostHighSpeedAutomobile() {
        return Collections.max(automobiles, (automobile1, automobile2) -> ((Integer) automobile1.getVelocity())
                .compareTo(automobile2.getVelocity()));
    }
}
