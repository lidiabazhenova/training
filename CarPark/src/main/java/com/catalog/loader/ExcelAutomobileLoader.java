package com.catalog.loader;

import com.catalog.exception.LoaderException;
import com.catalog.model.Automobile;
import com.catalog.model.Car;
import com.catalog.model.Truck;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelAutomobileLoader implements AutomobileLoader {

    private static final String CAR_SHEET_PREFIX = "car";
    private static final String TRUCK_SHEET_PREFIX = "truck";

    private String path;

    /**
     * /**
     * Create new object with parameters
     *
     * @param path xlsx-file path
     */
    public ExcelAutomobileLoader(String path) {
        this.path = path;
    }

    public List<Automobile> load() throws LoaderException {
        List<Automobile> automobiles = new ArrayList<Automobile>();
        File file = new File(path);
        Workbook workbook = null;

        try {
            workbook = WorkbookFactory.create(file);
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet sheet = sheetIterator.next();

                if (sheet.getSheetName().startsWith(CAR_SHEET_PREFIX)) {
                    automobiles.addAll(loadCarsFromSheet(sheet));
                } else if (sheet.getSheetName().startsWith(TRUCK_SHEET_PREFIX)) {
                    automobiles.addAll(loadTrucksFromSheet(sheet));
                }
            }
        } catch (IOException | InvalidFormatException ex) {
            throw new LoaderException(ex.getMessage(), ex);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException ex) {
                    throw new LoaderException(ex.getMessage(), ex);
                }
            }
        }

        return automobiles;
    }

    private List<Automobile> loadCarsFromSheet(Sheet sheet) {
        List<Automobile> automobiles = new ArrayList<Automobile>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            long id = (long) (cellIterator.next().getNumericCellValue());

            if (id == 0) {
                break;
            }

            String brand = cellIterator.next().getStringCellValue();
            String model = cellIterator.next().getStringCellValue();
            int velocity = (int) (cellIterator.next().getNumericCellValue());
            double price = cellIterator.next().getNumericCellValue();
            int bootVolume = (int) (cellIterator.next().getNumericCellValue());
            Car.Bodywork bodywork = Enum.valueOf(Car.Bodywork.class,
                    cellIterator.next().getStringCellValue());
            automobiles.add(new Car.CarBuilder().setId(id).setBrand(brand)
                    .setModel(model).setVelocity(velocity).setPrice(price)
                    .setBootVolume(bootVolume).setBodywork(bodywork)
                    .build());
        }

        return automobiles;
    }

    private List<Automobile> loadTrucksFromSheet(Sheet sheet) {
        List<Automobile> automobiles = new ArrayList<Automobile>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            long id = (long) (cellIterator.next().getNumericCellValue());

            if (id == 0) {
                break;
            }

            String brand = cellIterator.next().getStringCellValue();
            String model = cellIterator.next().getStringCellValue();
            int velocity = (int) (cellIterator.next().getNumericCellValue());
            double price = cellIterator.next().getNumericCellValue();
            String trailerBrand = cellIterator.next().getStringCellValue();
            String trailerModel = cellIterator.next().getStringCellValue();
            int carrying = (int) cellIterator.next().getNumericCellValue();
            int volumeOfCargo = (int) (cellIterator.next()
                    .getNumericCellValue());
            Truck.TrailerType trailerType = Enum
                    .valueOf(Truck.TrailerType.class,
                            cellIterator.next().getStringCellValue());
            Truck.Loading loading = Enum
                    .valueOf(Truck.Loading.class,
                            cellIterator.next().getStringCellValue());

            automobiles.add(new Truck.TruckBuilder()
                    .setId(id).setBrand(brand).setModel(model)
                    .setVelocity(velocity).setPrice(price)
                    .setTrailerBrand(trailerBrand)
                    .setTrailerModel(trailerModel)
                    .setCarrying(carrying).setVolumeOfCargo(volumeOfCargo)
                    .setTrailerType(trailerType)
                    .setLoading(loading)
                    .build());
        }
        return automobiles;
    }
}
