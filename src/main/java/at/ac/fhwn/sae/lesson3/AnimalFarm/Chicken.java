package at.ac.fhwn.sae.lesson3.AnimalFarm;

public class Chicken extends Animal{
    static int count = 0;

    public Chicken(String name){
        this.name = name;
        if (count < 10){
            this.id = "H00" + ++count;
        }else if (count < 100){
            this.id = "H0" + ++count;
        }else{
            this.id = "H" + ++count;
        }
    }

}
