package at.ac.fhwn.sae.lesson3;

public class Cat extends Animal{

    private static final String DEFAULT_CAT_NAME = "default cat name";

    public Cat(){
        this.name = DEFAULT_CAT_NAME;
    }

    public String getId() {
        return DEFAULT_ID;
    }
}
