package com.catalog.loader;

import com.catalog.model.Automobile;
import com.catalog.model.Car;
import com.catalog.model.Truck;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVAutomobileLoader implements AutomobileLoader {

    private static final String CAR_FILE_PREFIX = "car";
    private static final String TRUCK_FILE_PREFIX = "truck";

    private String path;

    public CSVAutomobileLoader(String path) {
        this.path = path;
    }

    public List<Automobile> load() throws IOException {
        File file = new File(path);
        String fileName = file.getName();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withTrim());

            if (fileName.startsWith(CAR_FILE_PREFIX)) {
                return loadCarsFromFile(csvParser);
            } else if (fileName.startsWith(TRUCK_FILE_PREFIX)) {
                return loadTrucksFromFile(csvParser);
            }

            throw new IllegalArgumentException("File has invalid prefix");

        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    private List<Automobile> loadCarsFromFile(CSVParser csvParser) {
        List<Automobile> automobiles = new ArrayList<Automobile>();

        for (CSVRecord csvRecord : csvParser) {
            automobiles.add(new Car.CarBuilder()
                    .setId(Long.valueOf(csvRecord.get("id")))
                    .setBrand(csvRecord.get("brand"))
                    .setModel(csvRecord.get("model"))
                    .setVelocity(Integer.valueOf(csvRecord.get("velocity")))
                    .setPrice(Double.valueOf(csvRecord.get("price")))
                    .setBootVolume(Integer.valueOf(csvRecord.get("bootVolume")))
                    .setBodywork(Enum.valueOf(Car.Bodywork.class,
                            csvRecord.get("bodywork")))
                    .build());
        }

        return automobiles;
    }

    private List<Automobile> loadTrucksFromFile(CSVParser csvParser) {
        List<Automobile> automobiles = new ArrayList<Automobile>();

        for (CSVRecord csvRecord : csvParser) {
            automobiles.add(new Truck.TruckBuilder()
                    .setId(Long.valueOf(csvRecord.get("id")))
                    .setBrand(csvRecord.get("brand"))
                    .setModel(csvRecord.get("model"))
                    .setVelocity(Integer.valueOf(csvRecord.get("velocity")))
                    .setPrice(Double.valueOf(csvRecord.get("price")))
                    .setTrailerBrand(csvRecord.get("trailerBrand"))
                    .setTrailerModel(csvRecord.get("trailerModel"))
                    .setCarrying(Integer.valueOf(csvRecord.get("carrying")))
                    .setVolumeOfCargo(Integer.valueOf(csvRecord
                            .get("volumeOfCargo")))
                    .setTrailerType(Enum.valueOf(Truck.TrailerType.class,
                            csvRecord.get("trailerType")))
                    .setLoading(Enum.valueOf(Truck.Loading.class,
                            csvRecord.get("loading")))
                    .build());
        }

        return automobiles;
    }
}
