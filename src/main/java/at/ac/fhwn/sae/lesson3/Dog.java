package at.ac.fhwn.sae.lesson3;

public class Dog extends Animal{
    private static final String CLASS_DESCRIPTION = "This is a dog class";
    private static final String DEFAULT_DOG_NAME = "default dog name";
    private static int count = 0;
    private String id;

    /**
     * Parameterless Ctor.
     */
    public Dog(){
        this.name = DEFAULT_DOG_NAME;
        this.id = "D" + ++count;
    }

    /**
     * Ctor with name parameter
     * @param name the name of the dog
     */
    public Dog(String name){
        this.name = name;
        this.id = "D" + ++count;
    }

    public void bark(){
        System.out.println("Wuff");
    }

    public String getId() {
        return id;
    }

    /**
     * return the number of dogs
     * @return
     */
    public static int getCount(){
        return count;
    }
}
