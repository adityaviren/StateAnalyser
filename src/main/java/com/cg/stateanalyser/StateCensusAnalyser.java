package com.cg.stateanalyser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class StateCensusAnalyser {

    public static ArrayList<StateCensus> stateCensusList = new ArrayList<>();

    public ArrayList<StateCensus> loadStateCensus() throws IOException, CsvValidationException, StateCensusException {
        try {
            String CSV_read_file = "F:\\Directory\\State Census.txt";
            Reader reader = Files.newBufferedReader(Paths.get(CSV_read_file), Charset.forName("ISO-8859-1"));
        } catch (IOException e) {
            throw new StateCensusException("Census file error", StateCensusException.Exception_type.Census_file_problem);
        } finally {
            String CSV_read_file = "F:\\Directory\\State Census.txt";
            Reader reader = Files.newBufferedReader(Paths.get(CSV_read_file), Charset.forName("ISO-8859-1"));
            CSVReader csvReader = new CSVReader(reader);

            String[] nextRecord;
            nextRecord = csvReader.readNext();
            int population, area, density;

            while ((nextRecord = csvReader.readNext()) != null) {
                try {
                    StateCensus stateCensus = new StateCensus();
                    stateCensus.setState(nextRecord[0]);
                    stateCensus.setPopulation(nextRecord[1]);
                    stateCensus.setArea(nextRecord[2]);
                    stateCensus.setDensity(nextRecord[3]);
                    if (!Pattern.matches("[0-9]", stateCensus.getPopulation()) || !Pattern.matches("[0-9]", stateCensus.getArea()) ||
                            !Pattern.matches("[0-9]", stateCensus.getDensity())) {
                        throw new NumberFormatException();
                    }
                    population = Integer.parseInt(nextRecord[1].trim());

                    area = Integer.parseInt(nextRecord[2].trim());
                    density = Integer.parseInt(nextRecord[3].trim());
                    if(population/area!=density){
                        throw new StateCensusException("Incorrect header",StateCensusException.Exception_type.Header_incorrect);
                    }
                    stateCensusList.add(stateCensus);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new StateCensusException("StateCensusException", StateCensusException.Exception_type.Delimiter_incorrect);
                } catch (NumberFormatException e) {
                    throw new StateCensusException("Incorrect type", StateCensusException.Exception_type.Type_incorrect);
                }
            }
            return stateCensusList;
        }
    }
}
