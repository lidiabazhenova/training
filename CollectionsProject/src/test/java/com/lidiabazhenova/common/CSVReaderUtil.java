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

    /**
     * Method for accessing values by the names assigned to each column
     *
     * @param path
     * @return
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
                    person.put("first name", csvRecord.get("first name"));
                    person.put("last name", csvRecord.get("last name"));
                    person.put("age", csvRecord.get("age"));
                    person.put("sex", csvRecord.get("sex"));
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





