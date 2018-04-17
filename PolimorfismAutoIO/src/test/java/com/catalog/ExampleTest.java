package com.catalog;

import com.catalog.exception.LoaderException;
import com.catalog.loader.LoaderFactory;
import com.catalog.model.Car;
import com.catalog.model.Truck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleTest {

    private static final String CSV_FILE_PATH_1 = "src\\test\\resources\\cars-with-header.csv";
    private static final String CSV_FILE_PATH_2 = "src\\test\\resources\\trucks-with-header.csv";
    private static final String EXCEL_FILE_PATH_1 = "src\\test\\resources\\Automobiles.xlsx";

    @Test
    public void carParkList() {
        CarPark carPark = new CarPark();

        carPark.printList();

        carPark.add(new Car.CarBuilder()
                .setId(45364454L).setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(15346.5)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build());

        carPark.add(new Car.CarBuilder()
                .setId(43354454L).setBrand("Audi")
                .setModel("A4")
                .setVelocity(280)
                .setPrice(12346.5)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.COUPE)
                .build());

        carPark.add(new Truck.TruckBuilder()
                .setId(123214L)
                .setBrand("Volvo")
                .setModel("FH-16")
                .setVelocity(330)
                .setPrice(50344.4)
                .setTrailerBrand("Smitz")
                .setTrailerModel("1997")
                .setCarrying(20)
                .setVolumeOfCargo(86)
                .setLoading(Truck.Loading.BACK)
                .setTrailerType(Truck.TrailerType.REFRIGARATOR)
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

        System.out.println("My cars:");

        carPark.printList();
        Car carForSale = new Car.CarBuilder()
                .setId(45354454L)
                .setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(12346.5)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build();
        carPark.sell(carForSale);

        System.out.println("After sale:");
        carPark.printList();

        System.out.println("The most expensive automobile:");
        System.out.println(carPark.getTheMostExpensiveAutomobile().getDescription());

        System.out.println("The most high-speed automobile:");
        System.out.println(carPark.getTheMostHighSpeedAutomobile().getDescription());
    }


    @Test
    public void CSVDrivenTest() throws LoaderException {
        CarPark carPark = new CarPark();

        List<String> paths = new ArrayList<String>();
        paths.add(CSV_FILE_PATH_1);
        paths.add(CSV_FILE_PATH_2);

        carPark.loadAutomobilesFromFile(LoaderFactory.FileType.CSV, paths);

        carPark.printList();
    }

    @Test
    public void ExcelDrivenTest() throws LoaderException {
        CarPark carPark = new CarPark();

        List<String> paths = new ArrayList<String>();
        paths.add(EXCEL_FILE_PATH_1);

        carPark.loadAutomobilesFromFile(LoaderFactory.FileType.EXCEL, paths);

        carPark.printList();
    }


}