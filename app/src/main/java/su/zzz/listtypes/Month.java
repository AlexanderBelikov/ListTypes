package su.zzz.listtypes;

public class Month {
    private String name;
    private String season;

    public static final Month[] months = {
        new Month("January", "Winter"),
        new Month("February", "Winter"),
        new Month("March", "Spring"),
        new Month("April", "Spring"),
        new Month("May", "Spring"),
        new Month("June", "Summer"),
        new Month("July", "Summer"),
        new Month("August", "Summer"),
        new Month("September", "Autumn"),
        new Month("October", "Autumn"),
        new Month("November", "Autumn"),
        new Month("December", "Winter"),
    };

    public Month(String name, String season){
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
