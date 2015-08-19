package ne4y_dev.de.mensatuebingen;


public class Menue {
    private String name, food, studentPrice, pupilPrice, guestPrice;

    public Menue(String name, String food, String studentPrice, String pupilPrice, String guestPrice) {
        this.name = name;
        this.food = food;
        this.studentPrice = studentPrice;
        this.pupilPrice = pupilPrice;
        this.guestPrice = guestPrice;
    }

    public String getName() {
        return this.name;
    }

    public String getFood() {
        return this.food;
    }

    public String getStudentPrice() {
        return this.studentPrice;
    }

    public String getPupilPrice() {
        return this.pupilPrice;
    }

    public String getGuestPrice() {
        return this.guestPrice;
    }

    public String toString() {
        return this.name + " " + this.food + " " + this.studentPrice + " " + this.pupilPrice + " " + this.guestPrice;
    }
}
