package com.groupG;

import java.util.ArrayList;

public class MovieStore {
    private String storeName;
    private String address;
    private String openingHours;
    private ArrayList<Movie> movieCollection = new ArrayList<>();
    private ArrayList<Movie> rentedMovies = new ArrayList<>();
    private ArrayList<Movie> returnedMovies = new ArrayList<>();
    private ArrayList<Customer> listOfCustomers = new ArrayList<>();
    private final int RENTLIMIT = 5;

    //Creates a new MovieStore
    public MovieStore(String storeName, String address, String openingHours){
        this.storeName = storeName;
        this.address = address;
        this.openingHours = openingHours;
    }

    //Prints the details of the movie store (name, address, and opening hours)
    public void printStoreDetails() {

        //System.out.println(this);
        System.out.println("\n***********************************************************************" + "\n" +
                "* Movie Store: " +storeName + "\n" +
                "* Address: " + address + "\n" +
                "* Opening Hours: " +openingHours + "\n" +
                "***********************************************************************\n");
    }

    //Adds a new a customer to the list of customers
    public void addCustomer(Customer newCustomer) {
        listOfCustomers.add(newCustomer);
    }

    //Adds a new movie to the movie collection
    public void addMovie(Movie newMovie) {
        movieCollection.add(newMovie);
    }

    //prints a list of available movies
    public void printAvailableMovies() {
        System.out.println(" The following movies are available in the movie collection:\n***********************************************************************"); //text block

        for (int i = 0; i < movieCollection.size(); i++)
            System.out.println(i + 1 + ". " + movieCollection.get(i) + " ");
    }

    //prints a list of rented movies
    public void printRentedMovies(){
        System.out.println("The following movies have been rented: \n***********************************************************************");//text block
        for (int i = 0; i < rentedMovies.size(); i++)
            System.out.println(i + 1 + ". " + rentedMovies.get(i) + " ");
    }

    //prints a list of registered customers
    public void printRegisteredCustomers(){
        System.out.println("Registered customers: \n***********************************************************************");

        for (int i = 0; i < listOfCustomers.size(); i++)
            System.out.println(i+1 + ". " + listOfCustomers.get(i) + " ");
    }

    //prints a list of movies currently rented to a certain customer
    public void printMoviesRentedToCustomer(String customerName) {
        var customer = getCustomerName(customerName);
        var borrowedMoviesCount = customer.getNumberOfMoviesBorrowed();

        if (borrowedMoviesCount == 0) //it's like an else statement so if the condition is true it returns meaning it breaks
            return;

        System.out.println("\n" + customerName + " has borrowed the following movies:" + "\n" +
                "***********************************************************************");
        for (int i = 0; i < borrowedMoviesCount; i++)
            System.out.println(i + 1 + ". " + customer.getBorrowedMovies().get(i));
    }

    //Rents a movie to a customer if a movie is available and the customer has not rented more than 5 movies already
    //Also, a customer must not be allowed to rent a movie that is outside his/her age range
    public void rentMovie(String movieTitle, String customerName) {
        var customer = getCustomerName(customerName);
        var movie = getMovieWithTitle(movieTitle);

        if (movie.isBorrowed()) { //this if acts like an else statement
            //movieCollection.remove(movie);
            System.out.println("\n**!!"+ customerName + " cannot borrow \"" + movieTitle + "\" because the movie is out of stock!!**");
            return;
        }

        if (customer.getNumberOfMoviesBorrowed() >= RENTLIMIT) { //this if acts like an else statement
            System.out.println("\n**!!"+ customerName + " cannot borrow\"" + movieTitle + "\" since the rent limit is reached!!**");
            return;
        }

        if (customer.getAge() < movie.getAgeLimit()) { //this if acts like an else statement
            System.out.println("\n**!!Customer out of age limit for this movie!!**" +
                    "\nCustomer is " + customer.getAge() + " years old and minimum age limit for this movie is " + movie.getAgeLimit());
            return;
        }

        rentedMovies.add(movie);
        customer.addBorrowedMovie(movie);
        movie.removeCopy();

    }

    //user defined method for getting movie title from class Movie ... not from template codes
    public Movie getMovieWithTitle(String title){
        for(Movie movie : movieCollection)
            if (movie.getTitle().equals(title))
                return  movie;

        return null;
    }

    public Customer getCustomerName(String name){
        for(Customer customer : listOfCustomers)
            if (customer.getName().equals(name))
                return  customer;

        return null;
    }

    //Returns a rented movie to collection
    public void returnMovie(String movieTitle, String customerName){
        var customer = getCustomerName(customerName);
        var movie = getMovieWithTitle(movieTitle);

        rentedMovies.remove(movie);
        customer.removeReturnedMovie(movie);

        returnedMovies.add(movie);
        movie.addCopies();
    }

    public void printReturnedMovies() {
        System.out.println("The following movies have been returned:\n ***********************************************************************");//text block
        for(int i = 0; i < returnedMovies.size(); i++)
            System.out.println(i + 1 + ". " +returnedMovies.get(i));
    }


}
