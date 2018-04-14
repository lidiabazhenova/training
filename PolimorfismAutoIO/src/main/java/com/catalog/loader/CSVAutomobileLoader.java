package com.catalog.loader;

import com.catalog.model.Automobile;
import com.catalog.model.Car;
import com.catalog.model.Truck;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVAutomobileLoader implements AutomobileLoader {

    private static final String CSV_FILE_PATH_1 = "C:\\projects\\training" +
            "\\PolimorfismAutoIO\\src\\main\\resources\\cars-with-header.csv";
    private static final String CSV_FILE_PATH_2 = "C:\\projects\\training" +
            "\\PolimorfismAutoIO\\src\\main\\resources\\trucks-with-header.csv";


    public List<Automobile> load() {

        List<Automobile> automobilesFromFile = new ArrayList<Automobile>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(CSV_FILE_PATH_1));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withTrim());
            addCarsFromFile(csvParser, automobilesFromFile);
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
        } finally {
            IOUtils.closeQuietly(reader);
        }

        try {
            reader = new BufferedReader(new FileReader(CSV_FILE_PATH_2));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withTrim());
            addTrucksFromFile(csvParser, automobilesFromFile);
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
        } finally {
            IOUtils.closeQuietly(reader);
        }
        return automobilesFromFile;
    }

    private void addCarsFromFile(CSVParser csvParser,
                                 List<Automobile> automobiles) {

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
    }

    private void addTrucksFromFile(CSVParser csvParser,
                                   List<Automobile> automobiles) {

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
    }
}
