package other;

import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class MovieRec
{ 
    class Movie {
        int movieId;
        float rating;
        ArrayList<Movie> similarMovies;
        
        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
        }
        
        public ArrayList<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN AN EMPTY SET IF NO SIMILAR MOVIE TO THE GIVEN MOVIE IS FOUND
        PriorityQueue<Movie> q ;
        Movie original;
    
    public Set<Movie> getMovieRecommendations (Movie movie, int N) 
    {
        original = movie;
        
        q = new PriorityQueue<Movie>(1000, new Comparator<Movie>() {

            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.rating < o2.rating) return 1;
                if(o1.rating > o2.rating) return -1;
                return 0;
            }
            
        });
        
        
        if(N < 1) {
            return new HashSet<Movie>();
        }
        
        getAllMovies(movie);
        
        HashSet<Movie> result = new HashSet<Movie>();
        
        while(N > 0 && q.size() > 0) {
            result.add(q.poll());
            N--;
        }
        
        return result;
        
    }
    // METHOD SIGNATURE ENDS
    
    public void getAllMovies(Movie movie) {
        if(q.contains(movie)  ) {
            return;
        }
        
        q.add(movie);
        
        ArrayList<Movie> similar = movie.getSimilarMovies();
        
        for(Movie m : similar) {
            if(m.movieId != original.movieId) {
                getAllMovies(m);
            }
        }
    }
}