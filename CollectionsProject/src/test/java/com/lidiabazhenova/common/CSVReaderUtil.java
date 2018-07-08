package com.lidiabazhenova.common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for loading users from csv-file
 */
public class CSVReaderUtil {

    public static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";
    public static final String FIRST_NAME = "first name";
    public static final String LAST_NAME = "last name";
    public static final String AGE = "age";
    public static final String SEX = "sex";

    /**
     * Method for accessing values by the names assigned to each column
     *
     * @param path
     * @throws IOException
     */
    public static List<Map<String, String>> loadAllPersonsFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat('|')
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase());

        return loadAll(csvParser);
    }

    public static List<Map<String, String>> loadCustomPersonsFromFile(String path, List<String> keys) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat('|')
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase());

        return loadCustomPersons(csvParser, keys);
    }

    private static List<Map<String, String>> loadAll(CSVParser csvParser) {
        List<Map<String, String>> people = new ArrayList<>();
        csvParser.forEach((csvRecord) -> {
                    Map<String, String> person = new HashMap<>();
                    person.put(FIRST_NAME, csvRecord.get(FIRST_NAME));
                    person.put(LAST_NAME, csvRecord.get(LAST_NAME));
                    person.put(AGE, csvRecord.get(AGE));
                    person.put(SEX, csvRecord.get(SEX));
                    people.add(person);
                }
        );

        return people;
    }

    private static List<Map<String, String>> loadCustomPersons(CSVParser csvParser, List<String> keys) {
        List<Map<String, String>> people = new ArrayList<>();
        csvParser.forEach((csvRecord) -> {
            Map<String, String> person = new HashMap<>();
            keys.forEach((key) -> {
                person.put(key, csvRecord.get(key));
            });
            people.add(person);
        });

        return people;
    }

}