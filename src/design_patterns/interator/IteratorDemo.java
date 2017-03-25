package design_patterns.interator;

import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {
        BikeRepository repo = new BikeRepository();

        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");

        Iterator<String> bikeIt = repo.iterator();

        while(bikeIt.hasNext()) {
            System.out.println(bikeIt.next());
        }

        for(String bike : repo) {
            System.out.println(bike);
        }
    }
}
