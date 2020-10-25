package com.cg.stateanalyser;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateAnalyserTest {

    @Test
    public void givenStateAnalyser_shouldReturnCount() throws IOException, CsvValidationException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        long noOfEntries = stateCensusAnalyser.loadStateCensus().stream().count();
        Assert.assertEquals(28,noOfEntries);

    }

    /*@Test
    public void givenStateAnalyser_shouldReturnException() throws CsvValidationException, IOException, StateCensusException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadStateCensus();
        }catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.Exception_type.Census_file_problem, e.type);
        }
    }*/
}
