public class Superhero {

    private String name;
    private String realname;
    private int age;
    private boolean isHuman;
    //private int OriginAge;
    private double Powerlevel;

    //Konstruktør
    public Superhero(String name, String realname, int age, boolean ishuman, double powerlevel) {
        this.name = name;
        this.realname = realname;
        this.age = age;
        this.isHuman = ishuman;
        //this.OriginAge = OriginAge;
        this.Powerlevel = powerlevel;

        //med this inddrager man det ovenstående, står der ikke this vil public demoting og nedenstående udelukke attributerne ovenstående

    }

    public String getName() {
        return name;


    }

    public String getRealname() {
        return realname;


    }

    public int getAge() {
        return age;


    }

    public boolean getIsHuman() { //Hvis der er fejl så ret den til IsHuman
        return isHuman;


    }

    /*public int getOriginAge() {
        return OriginAge;
    }*/

    public double getPowerlevel() {
        return Powerlevel;
    }

    //______________________________SETTERS______________________________________-


    public void setName(String name) {
        this.name = name;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsHuman(boolean human) {
        isHuman = human;
    }

    public void setPowerlevel(double powerlevel) {
        Powerlevel = powerlevel;
    }

    @Override
    public String toString() {
        String string = "";
        string += "Superheltens navn -> " + name + '\n';
        string += "RealName -> " + realname + '\n';
        string += "age -> " + age + '\n';
        string += "Er superhelten et menneske? -> " + (isHuman ? "Ja" : "Nej") + '\n';
        string += "Superheltens styrke niveau -> " + Powerlevel + '\n' + '\n';
        return string;
    }

}


