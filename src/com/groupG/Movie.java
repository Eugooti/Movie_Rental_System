package com.groupG;

public class Movie {
    private String title;
    private String director;
    private int ageLimit;
    private int year;
    private int numberOfCopies;

    // Creates a new Movie ... Constructor
    public Movie(String title, String director, int ageLimit, int year, int numberOfCopies) {
        this.title = title;
        this.director = director;
        this.ageLimit = ageLimit;
        this.year = year;
        this.numberOfCopies = numberOfCopies;
    }

    //Returns title of a movie
    public String getTitle() {
        return title;
    }

    //Returns the director of a movie
    public String getDirector() {
        return director;
    }

    //Returns the age limit of a movie
    public int getAgeLimit() {
        return ageLimit;
    }

    //Returns the year of a movie
    public int getYear() {
        return year;
    }

    // Returns true or false to indicate whether all copies of the movie are rented or not
    public boolean isBorrowed() {
        return numberOfCopies == 0;
    }

    //Adds new copy(ies) of a movie ... Increments number of copies
    public void addCopies(int copies) {
        numberOfCopies += copies;
    }

    public void addCopies() {
        numberOfCopies++;
    }

    //Removes a copy of a movie ... Decrements number of copies
    public void removeCopy() {
        numberOfCopies--;
    }

    //Return movie details
    public String toString() {
        return title + " - " + director + "(" + year + ") - " + numberOfCopies + " copy(ies) in stock";
    }
}
