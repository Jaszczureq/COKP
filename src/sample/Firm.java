package sample;

public class Firm {
    private String name_of_firm;

    public Firm(String name_of_firm) {
        this.name_of_firm = name_of_firm;
    }

    String getName_of_firm() {
        return name_of_firm;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "name_of_firm='" + name_of_firm + '\'' +
                '}';
    }
}
