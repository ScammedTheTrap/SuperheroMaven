import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> superHeroes = new ArrayList<>();


    public void addSuperhero(Superhero superhero) {
        superHeroes.add(superhero);
    }

    public ArrayList<Superhero> getSuperHeroes() {
        return superHeroes;
    }

    public Superhero searchSuperhero(String søgning) {
        String lowercaseSøgning = søgning.toLowerCase(); // Konverterer søgning til lowercase

        for (Superhero superhero : superHeroes) {
            String lowercaseName = superhero.getName().toLowerCase(); // Konverterer superheltnavnet til lowercase

            if (lowercaseName.contains(lowercaseSøgning)) {
                return superhero;
            }
        }
        return null;
    }


    public void editSuperhero(String currentName, Superhero newSuperhero) {
        Superhero SuperheroEdit = searchSuperhero(currentName);
        if (SuperheroEdit != null) {
            // Opdaterer superhelten nye oplysninger
            SuperheroEdit.setName(newSuperhero.getName());
            SuperheroEdit.setRealname(newSuperhero.getRealname());
            SuperheroEdit.setAge(newSuperhero.getAge());
            SuperheroEdit.setIsHuman(newSuperhero.getIsHuman());
            SuperheroEdit.setPowerlevel(newSuperhero.getPowerlevel());
        }

    }
    public boolean deleteSuperhero(String name) {

        for (Superhero superhero : superHeroes) {
            if (superhero.getName().equals(name)) {
                superHeroes.remove(superhero);
                System.out.println("Superhelten som blev slettet: " + name);
                return true;
            }
        }
        System.out.println("superhelten blev ikke slettet" + name + " mission failed!");
        return false;
    }



}


