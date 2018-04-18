package com.catalog;

import com.catalog.comparator.AutomobilePriceComparator;
import com.catalog.exception.LoaderException;
import com.catalog.loader.LoaderFactory;
import com.catalog.model.Car;
import com.catalog.model.Truck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarParkTest {

    private static final String CSV_FILE_PATH_1
            = "src/test/resources/cars-with-header.csv";
    private static final String CSV_FILE_PATH_2
            = "src/test/resources/trucks-with-header.csv";
    private static final String EXCEL_FILE_PATH_1
            = "src/test/resources/Automobiles.xlsx";

    @Test
    public void testAddAutomobiles() {
        CarPark carPark = new CarPark();
        carPark.add(new Car.CarBuilder()
                .setId(45364454L).setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(15346.5)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build());
        carPark.add(new Truck.TruckBuilder()
                .setId(123214L)
                .setBrand("Volvo")
                .setModel("FH")
                .setVelocity(290)
                .setPrice(40344.4)
                .setTrailerBrand("Smitz")
                .setTrailerModel("SKO 24/L")
                .setCarrying(20)
                .setVolumeOfCargo(92)
                .setLoading(Truck.Loading.BACK)
                .setTrailerType(Truck.TrailerType.TILTCOVEREDTRUCK)
                .build());

        assertEquals(2, carPark.getAutomobiles().size());
    }

    @Test
    public void testSellAutomobiles() {
        CarPark carPark = new CarPark();
        carPark.add(new Car.CarBuilder()
                .setId(45364454L).setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(15346.5)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build());
        carPark.add(new Truck.TruckBuilder()
                .setId(123214L)
                .setBrand("Volvo")
                .setModel("FH")
                .setVelocity(290)
                .setPrice(40344.4)
                .setTrailerBrand("Smitz")
                .setTrailerModel("SKO 24/L")
                .setCarrying(20)
                .setVolumeOfCargo(92)
                .setLoading(Truck.Loading.BACK)
                .setTrailerType(Truck.TrailerType.TILTCOVEREDTRUCK)
                .build());

        carPark.sell(new Truck.TruckBuilder()
                .setId(123214L)
                .setBrand("Volvo")
                .setModel("FH")
                .setVelocity(290)
                .setPrice(40344.4)
                .setTrailerBrand("Smitz")
                .setTrailerModel("SKO 24/L")
                .setCarrying(20)
                .setVolumeOfCargo(92)
                .setLoading(Truck.Loading.BACK)
                .setTrailerType(Truck.TrailerType.TILTCOVEREDTRUCK)
                .build());

        assertEquals(1, carPark.getAutomobiles().size());
    }

    @Test
    public void testLoadAutomobilesFromCSVFiles() throws LoaderException {
        CarPark carPark = new CarPark();
        List<String> paths = new ArrayList<>();
        paths.add(CSV_FILE_PATH_1);
        paths.add(CSV_FILE_PATH_2);

        carPark.loadAutomobilesFromFile(LoaderFactory.FileType.CSV, paths);

        assertEquals(3,carPark.getAutomobiles().size());
    }

    @Test
    public void testLoadAutomobilesFromExcelFiles() throws LoaderException {
        CarPark carPark = new CarPark();
        List<String> paths = new ArrayList<>();
        paths.add(EXCEL_FILE_PATH_1);

        carPark.loadAutomobilesFromFile(LoaderFactory.FileType.EXCEL, paths);

        assertEquals(5, carPark.getAutomobiles().size());
    }

    @Test
    public void testMostHighSpeedAutomobile() {
        CarPark carPark = new CarPark();
        carPark.add(new Car.CarBuilder()
                .setId(123123L)
                .setBrand("Toyota")
                .setModel("Venza")
                .setPrice(34000.0)
                .setVelocity(230)
                .build());
        carPark.add(new Truck.TruckBuilder()
                .setId(123123L)
                .setBrand("Volvo")
                .setModel("FH-16")
                .setPrice(44000.0)
                .setVelocity(290)
                .build());

        assertEquals(290, carPark.getTheMostExpensiveAutomobile().getVelocity());
    }

    @Test
    public void testMostExpensiveAutomobile() {
        CarPark carPark = new CarPark();
        carPark.add(new Car.CarBuilder()
                .setId(123123L)
                .setBrand("Toyota")
                .setModel("Venza")
                .setPrice(34000.0)
                .setVelocity(230)
                .build());
        carPark.add(new Truck.TruckBuilder()
                .setId(123123L)
                .setBrand("Volvo")
                .setModel("FH-16")
                .setPrice(44000.0)
                .setVelocity(230)
                .build());

        assertEquals(44000.0, carPark.getTheMostExpensiveAutomobile().getPrice(), 0.01);
    }

}
