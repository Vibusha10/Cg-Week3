class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    Movie head, tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = current.next;
        newMovie.prev = current;
        current.next.prev = newMovie;
        current.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie \"" + title + "\" not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Movie \"" + title + "\" removed.");
    }

    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displaySingle(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No movies found by Director \"" + director + "\".");
    }

    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                displaySingle(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No movies found with Rating " + rating);
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie current = head;
        while (current != null) {
            displaySingle(current);
            current = current.next;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie current = tail;
        while (current != null) {
            displaySingle(current);
            current = current.prev;
        }
    }

    private void displaySingle(Movie movie) {
        System.out.println("Title   : " + movie.title);
        System.out.println("Director: " + movie.director);
        System.out.println("Year    : " + movie.year);
        System.out.println("Rating  : " + movie.rating);
        System.out.println("--------------------------");
    }
}

public class Program2 {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtBeginning("The Matrix", "The Wachowskis", 1999, 8.7);
        list.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        list.displayForward();
        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.7);
        list.updateRating("Inception", 9.0);
        list.removeByTitle("The Matrix");
        list.displayBackward();
    }
}
