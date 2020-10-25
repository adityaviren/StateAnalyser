package com.cg.stateanalyser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StateNumberAnalyser {

    public static ArrayList<StateNumber> stateNumberList = new ArrayList<>();

    public ArrayList<StateNumber> loadStateCensus() throws IOException, CsvValidationException, StateCensusException {
        try {
            String CSV_read_file = "F:\\Directory\\State Number.txt";
            Reader reader = Files.newBufferedReader(Paths.get(CSV_read_file), Charset.forName("ISO-8859-1"));
        } catch (IOException e) {
            throw new StateCensusException("Census file error", StateCensusException.Exception_type.Census_file_problem);
        } finally {
            String CSV_read_file = "F:\\Directory\\State Number.txt";
            Reader reader = Files.newBufferedReader(Paths.get(CSV_read_file), Charset.forName("ISO-8859-1"));
            CSVReader csvReader = new CSVReader(reader);

            String[] nextRecord;
            nextRecord = csvReader.readNext();
            int TIN, srno=1,Srno;
            List<Integer> TINarray = new ArrayList<>();
            for(int i =1; i<38;i++){
                TINarray.add(i);
            }

            while ((nextRecord = csvReader.readNext()) != null) {
                try {
                    StateNumber stateNumber = new StateNumber();
                    stateNumber.setSrno(nextRecord[0]);
                    stateNumber.setName(nextRecord[1]);
                    stateNumber.setTIN(nextRecord[2]);
                    stateNumber.setStatecode(nextRecord[3]);
                    TIN = Integer.parseInt(nextRecord[2].trim());
                    Srno = Integer.parseInt(nextRecord[0].trim());
                    if (Pattern.matches("[0-9]*", nextRecord[0]) || Pattern.matches("[0-9]*", nextRecord[2])) {

                    }
                    else{
                        throw new NumberFormatException();
                    }

                    if(srno!=Srno || !TINarray.contains((Object)TIN)){
                        throw new StateCensusException("Incorrect header",StateCensusException.Exception_type.Header_incorrect);
                    }
                    srno++;
                    TINarray.remove((Object)TIN);
                    stateNumberList.add(stateNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new StateCensusException("StateCensusException", StateCensusException.Exception_type.Delimiter_incorrect);
                } catch (NumberFormatException e) {
                    throw new StateCensusException("Incorrect type", StateCensusException.Exception_type.Type_incorrect);
                }
            }
            return stateNumberList;
        }
    }
}

