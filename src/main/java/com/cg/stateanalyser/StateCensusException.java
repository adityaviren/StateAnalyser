package com.cg.stateanalyser;

public class StateCensusException extends Exception{

    enum Exception_type{
        Census_file_problem,
        Type_incorrect,
        Delimiter_incorrect;
    }

    Exception_type type;

    public StateCensusException(String message,Exception_type type){
        super(message);
        this.type = type;
    }
}
