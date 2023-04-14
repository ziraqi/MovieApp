/*
 * Zakaria Iraqi
 * Mohammad AlSaffar
 * Computer Science 1
 * December 12 2022
 */

import java.util.*;

public class MovieStore {

    ArrayList<Movie> films = null;
    String activeUser = "";
    Scanner s;

    public MovieStore() {
        s = new Scanner(System.in);
        films = new ArrayList<Movie>();
    }

    public String login() {
        User user = new User();
        Manager manager = new Manager();

        System.out.println("Input username: ");
        String admin = s.next();

        System.out.println("Input password: ");
        String pass = s.next();

        if (user.getUsername().equals(admin) && user.getPassword().equals(pass)) {
            System.out.println("Hello User..");
            return "User";
        } else if (manager.getUsername().equals(admin) && manager.getPassword().equals(pass)) {
            System.out.println("Hello Manager..");
            return "Manager";
        } else {
            System.out.println("Wrong username and password, you are now a User.");
            return "User";
        }
    }



    private void fillMoviesArrayList(ArrayList<Movie> films) {
        films.add(new Movie("Inception", 2010, "Leonardo DiCaprio", "Action"));
        films.add(new Movie("Interstellar", 2014, "Matthew McConaughey", "Sci-Fi"));
        films.add(new Movie("The Dark Knight", 2008, "Christian Bale", "Action"));
        films.add(new Movie("The Matrix", 1999, "Keanu Reeves", "Sci-Fi"));
        films.add(new Movie("The Dark Knight Rises", 2012, "Chrisitian Bale", "Action"));
        films.add(new Movie("Goodfellas", 1990, "Ray Liotta", "Crime"));
        films.add(new Movie("The Irishman", 2019, "Robert De Niro", "Crime"));
        films.add(new Movie("Meet the Parents", 2000, "Robert De Niro", "Comedy"));
        films.add(new Movie("The King's Speech", 2011, "Colin Firth", "Drama"));
        films.add(new Movie("Charlie and the Chocolate Factory", 2005, "Johnny Depp", "Fantasy"));
        films.add(new Movie("Alice In Wonderland", 2009, "Johnny Depp", "Fantasy"));
        

    }

    public void sortByTitle() {
        System.out.println("Sorting Based on Movie Title:");
        Collections.sort(films, Movie.titleComparator);


    }

    public void sortByYear() {
        System.out.println("Sorting Based on Movie Year:");
        Collections.sort(films, Movie.yearComparator);


    }

    public void sortByActor() {
        System.out.println("Sorting Based on Movie Actor:");
        Collections.sort(films, Movie.actorComparator);


    }

    public void sortByGenre() {
        System.out.println("Sorting Based on Movie Genre:");
        Collections.sort(films, Movie.genreComparator);


    }

    public void sortMenu() {
        System.out.println("Hello to the SORT Menu");
        System.out.println("How would you like to sort the Movie List?");
        System.out.println("1] Sort by Title");
        System.out.println("2] Sort by Year");
        System.out.println("3] Sort by Actor");
        System.out.println("4] Sort by Genre");
        System.out.println("5] Go to MAIN Menu");
        System.out.println("6] Exit");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                sortByTitle();
                printMoviesArrayList(films);
                break;
            case 2:
                sortByYear();
                printMoviesArrayList(films);
                break;
            case 3:
                sortByActor();
                printMoviesArrayList(films);
                break;
            case 4:
                sortByGenre();
                printMoviesArrayList(films);
                break;
            case 5:
                start();
                break;
            case 6:
                Bye();
                break;
            default:
                System.out.println("Wrong option: ");
                sortMenu();
        }

    }
    public void Bye()
    {
        System.out.println("Thank you for using my program!");
        System.out.println("Good bye!");
        System.exit(0);
    }
    public void searchAMovieTitle() {
        System.out.println("Input the Movie Title you want to search: ");
        String title = s.nextLine();

        boolean result = false;

        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().contains(title)) {
                System.out.println("Movie Found: ");
                System.out.println(films.get(i));
                result = true;
                break;
            }
        }

        if (!result) {
            System.out.println(title + " cannot find");
        }

    }

    private void printMoviesArrayList(ArrayList<Movie> films) {
        System.out.println("Movie Collection");
        System.out.println("================");
        for (Movie film : films) {
            System.out.println(film);
        }

    }

    public void displayMenuForUser() {
        System.out.println("Hello USER!");

        System.out.println("Choose an option: ");
        System.out.println("1] Search a Movie Title");
        System.out.println("2] Sort a Movie");
        System.out.println("3] Display All Movies");
        System.out.println("4] Go back to the Main Menu");
        System.out.println("5] Exit");
        System.out.println("Input your choice: ");
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {
            case 1:
                searchAMovieTitle();
                break;
            case 2:
                sortMenu();
                break;
            case 3:
                printMoviesArrayList(films);
                break;
            case 4:
                start();
                break;
            case 5:
                Bye();
                break;
            default:
                System.out.println("Invalid choice..");

        }
        displayMenuForUser();
    }

    public void addAMovie()
    {
        System.out.println("Add a Movie Menu: ");
        System.out.println("Please Input the Movie Title: ");
        String title = s.nextLine();
        System.out.println("Input the year it was released: ");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Input the Actors in the Movie " + title + ": ");
        String actor = s.nextLine();
        System.out.println("What is the Genre? ");
        String genre = s.nextLine();

        films.add(new Movie(title, year, actor, genre));
        System.out.println("Movie successfully added..");
        return;
    }

    public void removeAMovie()
    {
        System.out.println("Remove a Movie Menu: ");
        System.out.println("Please Input the Movie Title you want to be removed: ");
        String title = s.nextLine();

        boolean result = false;

        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().contains(title)) {
                System.out.println("Movie Removed: ");
                System.out.println(films.remove(i));
                result = true;
                break;
            }
        }

        if (!result) {
            System.out.println(title + " cannot find");
        }
        return;
    }

    public void displayMenuForManager() {
        System.out.println("Hello MANAGER!");

        System.out.println("Choose an option: ");
        System.out.println("1] Search a Movie Title");
        System.out.println("2] Sort a Movie");
        System.out.println("3] Display All Movies");
        System.out.println("4] Add A Movie");       
        System.out.println("5] Remove A Movie");    
        System.out.println("6] Go back to the Main Menu");
        System.out.println("7] Exit");
        System.out.println("Input your choice: ");
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {
            case 1:
                searchAMovieTitle();
                break;
            case 2:
                sortMenu();
                break;
            case 3:
                printMoviesArrayList(films);
                break;
            case 4:
                addAMovie();
                break;
            case 5: 
                removeAMovie();
                break;
            case 6:
                start();
                break;
            case 7:
                Bye();
                break;
            default:
                System.out.println("Invalid choice..");

        }
        displayMenuForManager();

    }

    public void start() {
        System.out.println("--== Hello to the MAIN MENU ==--");
        
        activeUser = login();
        fillMoviesArrayList(films);

        if (activeUser.equalsIgnoreCase("USER")) {
            displayMenuForUser();
        } else if (activeUser.equalsIgnoreCase("MANAGER")) {
            displayMenuForManager();
        }

    }

    public static void main(String[] args) {
        new MovieStore().start();
    }

}
