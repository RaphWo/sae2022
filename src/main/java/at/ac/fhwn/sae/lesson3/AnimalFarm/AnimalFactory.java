package at.ac.fhwn.sae.lesson3.AnimalFarm;

public class AnimalFactory {
    public Animal getAnimal(AnimalKind animalKind, String name){
        switch (animalKind){
            case COW -> {
                return new Cow(name);
            }
            case PIG -> {
                return new Pig(name);
            }
            case CHICKEN -> {
                return new Chicken(name);
            }
            case HORSE -> {
                return new Horse(name);
            }
            default -> throw new RuntimeException("unknown animal kind");
        }
    }
}
