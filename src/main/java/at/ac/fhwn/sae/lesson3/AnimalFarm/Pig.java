package at.ac.fhwn.sae.lesson3.AnimalFarm;

public class Pig extends Animal{
    static int count = 0;

    public Pig(String name){
        this.name = name;
        if (count < 10){
            this.id = "S00" + ++count;
        }else if (count < 100){
            this.id = "S0" + ++count;
        }else{
            this.id = "S" + ++count;
        }
    }

}
