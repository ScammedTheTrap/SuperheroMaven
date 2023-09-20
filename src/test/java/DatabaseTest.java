import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;

    @BeforeEach
    void setup() {
        db = new Database();
        Superhero superhero1 = new Superhero("Son", "Goku", 50, false, 9000.0);
        Superhero superhero2 = new Superhero("Prince", "Vegeta", 70, false, 15000.0);
        Superhero superhero3 = new Superhero("Skaldet", "Krillin", 20, true, 1500.0);
    }

    // Test at søge efter en superhelt der ikke findes
    @Test
    void testSearchNoSuperheroes() {

        String searchName = "???";
        Superhero result = db.searchSuperhero(searchName);
        assertNull(result); // Forvent at resultatet er null
    }


    //testen for 1 superhelt
    @Test
    void getSuperHeroes() {
        int expectedValue = db.superHeroes.size() + 1;
        Superhero superhero = new Superhero("Son", "Goku", 50, false, 9000.0);
        db.addSuperhero(superhero);
        int actualValue = db.getSuperHeroes().size();
        System.out.println("Expected: " + expectedValue);
        System.out.println("Actual: " + actualValue);
        assertEquals(expectedValue, actualValue);

    }

    //her tester vi, hvis flere superhelte er involveret.
    @Test
    void moreSuperheroes() {
        int initialSize = db.getSuperHeroes().size();

        Superhero superhero1 = new Superhero("Son", "Goku", 50, false, 9000.0);
        db.addSuperhero(superhero1);
        Superhero superhero2 = new Superhero("Prince", "Vegeta", 70, false, 15000.0);
        db.addSuperhero(superhero2);
        Superhero superhero3 = new Superhero("Skaldet", "Krillin", 20, true, 1500.0);
        db.addSuperhero(superhero3);

//hvis denne bliver 2 opstår der fejl da expected samt actual ikke er ens
        int expectedSize = initialSize + 3;
        int actualSize = db.getSuperHeroes().size();

        System.out.println("Expected: " + expectedSize);
        System.out.println("Actual: " + actualSize);
        assertEquals(expectedSize, actualSize);
    }

   @Test
    void testDeleteSuperhero() {

        String superheroNameToDelete = "superhero1";

        boolean isDeleted = db.deleteSuperhero(superheroNameToDelete);

        assertTrue(isDeleted);
        assertNull(db.searchSuperhero(superheroNameToDelete));

    }
}

