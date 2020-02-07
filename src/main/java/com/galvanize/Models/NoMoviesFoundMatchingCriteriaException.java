package com.galvanize.Models;

public class NoMoviesFoundMatchingCriteriaException extends Exception{
    public NoMoviesFoundMatchingCriteriaException(String message) {
        super(message);
    }
}
