package com.cg.stateanalyser;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class StateAnalyserTest {

    /*@Test
    public void givenStateAnalyser_shouldReturnCount() throws IOException, CsvValidationException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        long noOfEntries = stateCensusAnalyser.loadStateCensus().stream().count();
        Assert.assertEquals(28,noOfEntries);

    }*/

    /*@Test
    public void givenStateAnalyser_shouldReturnException() throws CsvValidationException, IOException {
        boolean check=false;
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadStateCensus();
        }catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.Exception_type.Census_file_problem, e.type);
            check = true;
        }finally {
            Assert.assertTrue(check);
        }
    }*/

    /*@Test
    public void givenStateAnalyser_shouldReturnException() throws CsvValidationException, IOException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadStateCensus();
        }catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.Exception_type.Header_incorrect, e.type);
        }
    }*/

    /*@Test
    public void givenStateNumber_shouldReturnException() throws CsvValidationException, IOException, StateCensusException {
            StateNumberAnalyser stateNumberAnalyser = new StateNumberAnalyser();
            long noOfEntries = stateNumberAnalyser.loadStateCensus().stream().count();
            Assert.assertEquals(37,noOfEntries);

    }*/

    @Test
    public void givenStateAnalyser_shouldReturnException() throws CsvValidationException, IOException {
        try {
            StateNumberAnalyser stateNumberAnalyser = new StateNumberAnalyser();
            stateNumberAnalyser.loadStateCensus();
        }catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.Exception_type.Census_file_problem, e.type);
        }
    }


}
