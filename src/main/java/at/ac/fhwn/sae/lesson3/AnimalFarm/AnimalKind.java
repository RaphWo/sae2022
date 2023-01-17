package at.ac.fhwn.sae.lesson3.AnimalFarm;

public enum AnimalKind {
    HORSE(Horse.class),
    COW(Cow.class),
    PIG(Pig.class),
    CHICKEN(Chicken.class);

    private final Class<? extends Animal> animalClass;

    AnimalKind(Class<? extends Animal> animalClass) {
        this.animalClass = animalClass;
    }

    public Class<? extends Animal> getAnimalClass(){
        return animalClass;
    }
}
