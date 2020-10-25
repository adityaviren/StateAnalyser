package com.cg.stateanalyser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class StateCensusAnalyser {

    public static ArrayList<StateCensus> stateCensusList = new ArrayList<>();

    public ArrayList<StateCensus> loadStateCensus() throws IOException, CsvValidationException, StateCensusException {
        String CSV_read_file = "F:\\Directory\\State Census.txt";

        Reader reader = Files.newBufferedReader(Paths.get(CSV_read_file), Charset.forName("ISO-8859-1"));

        CSVReader csvReader = new CSVReader(reader);

        /*Iterator<String[]> iterator = csvReader.iterator();

        while(iterator.hasNext()){
            try {
                iterator.next();
                StateCensus stateCensus = new StateCensus();
                stateCensus.setState(iterator.toString());
                stateCensus.setPopulation(iterator[1]);
                stateCensus.setArea(iterator.next()[2]);
                stateCensus.setDensity(iterator.next()[3]);
                stateCensusList.add(stateCensus);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("State census incomplete");
            }
        }*/
        String[] nextRecord;
        nextRecord = csvReader.readNext();
        while((nextRecord = csvReader.readNext())!=null) {
            try {
                StateCensus stateCensus = new StateCensus();
                stateCensus.setState(nextRecord[0]);
                stateCensus.setPopulation(nextRecord[1]);
                stateCensus.setArea(nextRecord[2]);
                stateCensus.setDensity(nextRecord[3]);
                stateCensusList.add(stateCensus);
            }catch (ArrayIndexOutOfBoundsException e){
                throw new StateCensusException("StateCensusException", StateCensusException.Exception_type.Census_file_problem);
            }
        }
        return stateCensusList;
    }

    /*public static void main(String[] args) {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadStateCensus(stateCensusList);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }*/
}
