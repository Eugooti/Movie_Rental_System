package com.groupG;

import java.util.ArrayList;

public class Customer {
    private String name;
    private int age;
    private String phone;
    private String address;
    private ArrayList<Movie> borrowedMovies = new ArrayList<>();
    private int numberOfMoviesBorrowed;

    //Creates a new Customer
    public Customer(String name, int age, String phone, String address){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    //Returns the name of a customer
    public String getName() {
        return name;
    }

    //Returns the age of a customer
    public int getAge() {
        return age;
    }

    //Returns the phone number of a customer
    public String getPhone() {
        return phone;
    }

    //Returns the address of a customer
    public String getAddress(){
        return address;
    }

    //Returns a list of borrowed movies
    public ArrayList<Movie> getBorrowedMovies() {
        return borrowedMovies;
    }

    //Returns number of movies borrowed
    public int getNumberOfMoviesBorrowed(){
        return borrowedMovies.size();
    }

    //Adds borrowed movie
    public void addBorrowedMovie(Movie movie) {
        borrowedMovies.add(movie);
    }

    //Remove returned from a collection of borrowed movies
    public void removeReturnedMovie(Movie movie) {
        borrowedMovies.remove(movie);
    }

    //Return customer details
    public String toString() {
        return name + " - " + address + " (Phone: " + phone + ")";
    }

}
