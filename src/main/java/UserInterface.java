import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private Database db;

    //Benyttet til UserInterface
    public UserInterface() {
        scan = new Scanner(System.in);
        db = new Database();
    }

    /*
    Notat:
    - fiks boolean, den skal kunne registrer både upper samt lowercases NO WORKING ;(
    - måske skal jeg tilføje kræfter
    */

    //Void da den ikke skal returnere noget værdi, den er koblet til Main klasse --> ui.startProgram();

    public void startProgram() {
        System.out.println("----------Velkommen til den ultimative Superhelt program 7000!!!!!----------");

        int NumberOfSuperheroes = 0;


        System.out.println(" ");

        System.out.println(">>>>>Denne program opretter den ønskede Superhelt som du laver!<<<<<");

        System.out.println(" ");

        System.out.println("Vil du fortsætte programmet? Tryk 1 og klik enter, hvis ikke tryk 2:");

        System.out.println(" ");

        int svar = scan.nextInt();
        scan.nextLine(); //den er med sådan at nextLine scans er registreret, hvis den ikke er der bugger min scanner.

        while (svar == 1 && NumberOfSuperheroes < 3) {

            System.out.println("programmet fortsætter");

            System.out.println(" ");

            System.out.println("Indtast superheltens navn:");

            String name = scan.nextLine();
            String scannerbug = scan.nextLine();

            System.out.println("Indtast superheltens Rigtige navn:");

            String realname = scan.nextLine();

            System.out.println("Indtast superheltens alder:");
            //Det her er praktisk nemmere end try catch da brugeren undgår at taste superheltens atributter ind igen.
            while (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("Alder skal være et tal: ");
            }

            int age = scan.nextInt();
            scan.nextLine();

            System.out.println("Er superhelten et menneske? (Y/N):");
            char isHuman = scan.next().charAt(0);

            if (isHuman == 'y' || isHuman == 'Y') {

                System.out.println("Superhelten er et menneske :D");

            } else if (isHuman == 'n' || isHuman == 'N') {

                System.out.println("Superhelten er ikke et menneske :O");
            }
            System.out.println(" ");

            System.out.println("Indtast superheltens styrke niveau:");
            while (!scan.hasNextDouble()) {
                scan.nextLine();
                System.out.println("Alder skal være et tal: ");
            }
            double powerlevel = scan.nextDouble();


            System.out.println(" ");
            Superhero superhero = new Superhero(name, realname, age, isHuman == 'y' || isHuman == 'n', powerlevel);
            db.addSuperhero(superhero);

            System.out.println(superhero);

            NumberOfSuperheroes++;

            if (NumberOfSuperheroes >= 3) {
                System.out.println("Du har oprettet 3 superhelte. Du kan ikke oprette flere.");
                System.out.println(db.getSuperHeroes());
                break;
            }

        }

        //DENNE HER DEL ER MIN SØGNINGSKRITERIUM SOM FINDER EN SUPERHELT UD FRA BRUGERENS SØGNING
        System.out.println("----------------Indtast superheltens navn du vil finde----------------");
        String søgning = scan.next();

        Superhero result = db.searchSuperhero(søgning); //metoden fra Database implementeret.

        //if samt else for at færdiggøre søgningen hvis en oprettet superhelt findes eller ej
        if (result == null) {
            System.out.println("Søgemaskinen kunne ikke finde den søgte superhelt ;( : " + søgning);
            System.out.println(" ");
        } else {
            System.out.println("YAAAAAAAY din superhelt blev fundet :D :");
            System.out.println(result);
            System.out.println(" ");
        }


        System.out.println("Indtast superhelten, du vil redigere:");
        String editSuperhero = scan.next();

        Superhero nuværendeSuperhero = db.searchSuperhero(editSuperhero);
        if (nuværendeSuperhero != null) {
            // brugeren får mulighed for at ændre på adskillige atributter på den givende superhelt
            System.out.println("Hvilken af de oplysninger vil du ændre?");
            System.out.println("1. Navn?");
            System.out.println("2. Rigtige navn?");
            System.out.println("3. Alder?");
            System.out.println("4. Er superhelten et menneske?");
            System.out.println("5. Superheltens styrkeniveau?");
            int valg = scan.nextInt();

            switch (valg) {
                case 1:
                    System.out.println("Indtast superheltens nye navn:");
                    String newName = scan.next();
                    nuværendeSuperhero.setName(newName);
                    break;
                case 2:
                    System.out.println("Indtast det nye rigtige navn:");
                    String newRealName = scan.next();
                    nuværendeSuperhero.setRealname(newRealName);
                    break;
                case 3:
                    System.out.println("Indtast den nye alder:");
                    int newAge = scan.nextInt();
                    nuværendeSuperhero.setAge(newAge);
                    break;
                case 4:
                    System.out.println("Er superhelten et menneske? (y/n):");
                    char newIsHuman = scan.next().toUpperCase().charAt(0);
                    nuværendeSuperhero.setIsHuman(newIsHuman == 'y' || newIsHuman == 'Y');
                    break;
                case 5:
                    System.out.println("Indtast det nye styrkeniveau:");
                    double newPowerLevel = scan.nextDouble();
                    nuværendeSuperhero.setPowerlevel(newPowerLevel);
                    break;
                case 6:
                    System.out.println("Afsut redigering.");
                    break;
                default:
                    System.out.println("UGYLDIGT VALG MY FRIEND ;P ");
                    break;
            }
            System.out.println("Din superhelt er blevet opdateret til følgende: ");
            System.out.println(nuværendeSuperhero);


            System.out.println("Liste over superhelte:");

            ArrayList<Superhero> superheroes = db.getSuperHeroes();

            for (int i = 0; i < superheroes.size(); i++) {
                System.out.println((i + 1) + ". " + superheroes.get(i).getName());
            }

            System.out.println("Vælg en superhelt at slette (indtast nummer):");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= superheroes.size()) {
                Superhero superheroToDelete = superheroes.get(choice - 1);
                boolean isDeleted = db.deleteSuperhero(superheroToDelete.getName());

                if (isDeleted) {
                    System.out.println(superheroToDelete.getName() + " blev slettet.");
                } else {
                    System.out.println("Sletning mislykkedes.");
                }
            } else {
                System.out.println("Ugyldigt valg.");
            }

        }

    }
}





