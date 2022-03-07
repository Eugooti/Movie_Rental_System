package com.groupG;

import javax.crypto.spec.PSource;

public class Main {

    public static void main(String[] args) {
        MovieStore QuickMartStore = new MovieStore("Movie Madness (U) Ltd", "QuickMart, Kisii", "Monday - Saturday 10AM – 11PM");

        //Adding sample movies
        QuickMartStore.addMovie(new Movie("Sound City", "Dave Grohl", 17, 2013, 2));
        QuickMartStore.addMovie(new Movie("The Invisible War", "Kirby Dick", 21, 2012, 4));
        QuickMartStore.addMovie(new Movie("Man on Wire", "James Marsh", 18, 2008 , 1));
        QuickMartStore.addMovie(new Movie("The Interrupters", "Steve James", 14, 2011, 1));
        QuickMartStore.addMovie(new Movie("Waste Land", "Lucy Walker", 20, 2012, 1));
        QuickMartStore.addMovie(new Movie("Deliver Us From Evil", " Amy J. Berg", 10, 2006, 8));
        QuickMartStore.addMovie(new Movie("Taxi to the Dark Side", "Alex Gibney", 14, 2007, 1));
        QuickMartStore.addMovie(new Movie("My Voyage to Italy", "Martin Scorsese", 12, 2001, 2));
        QuickMartStore.addMovie(new Movie("Last Train Home", "Lixin Fan", 14, 2009, 2));

        //Adding sample customers
        QuickMartStore.addCustomer(new Customer("Grace", 16, " 07577009", "Kisii"));
        QuickMartStore.addCustomer(new Customer("James", 20, " 0789193", " Rongo "));
        QuickMartStore.addCustomer(new Customer("Sarah", 27, " 0716367", " Kisumu"));
        QuickMartStore.addCustomer(new Customer("Ruth", 19, " 0718384", " Nairobi"));
        QuickMartStore.addCustomer(new Customer("Brian", 29, " 0718288", " Mombasa"));
        QuickMartStore.addCustomer(new Customer("Robert", 26, "0771833", " Kisii"));
        QuickMartStore.addCustomer(new Customer("Joseph", 19, "0708817", " Oyugis"));
        QuickMartStore.addCustomer(new Customer("Lisa", 21, " 0798182", " Kisii"));

        //Printing store details
        QuickMartStore.printStoreDetails();

        //Try to print the list of all registered customers
        QuickMartStore.printRegisteredCustomers();

        //Try to print the list of all movies in the collection
        QuickMartStore.printAvailableMovies();

        //Try to borrow a movie
        QuickMartStore.rentMovie("Last Train Home", "James");
        QuickMartStore.rentMovie("The Interrupters", "James");
        QuickMartStore.rentMovie("Taxi to the Dark Side", "Joseph");

        //Try print the list of all movies currently rented
        QuickMartStore.printRentedMovies();

        //Try to borrow a movie that is out of stock
        QuickMartStore.rentMovie("Taxi to the Dark Side", "Grace");

        //Try to borrow a movie that is out of your age range
        QuickMartStore.rentMovie("Waste Land", "Joseph");

        //Try to return a movie
        QuickMartStore.returnMovie("The Interrupters", "James");
        QuickMartStore.returnMovie("Taxi to the Dark Side", "Joseph");

        QuickMartStore.printReturnedMovies();
        //after returning movies print rented movies again
        QuickMartStore.printRentedMovies();

        //Try to print the list of all movies in the collection
        QuickMartStore.printAvailableMovies();

        //Try to print the list of movies currently rented to a certain customer
        QuickMartStore.printMoviesRentedToCustomer("James");
        //QuickMartStore.printMoviesRentedToCustomer("Joseph");


    }


}
