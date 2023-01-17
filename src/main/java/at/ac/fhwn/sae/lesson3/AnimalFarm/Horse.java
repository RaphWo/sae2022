package at.ac.fhwn.sae.lesson3.AnimalFarm;

public class Horse extends Animal{
    static int count = 0;

    public Horse(String name){
        this.name = name;
        if (count < 10){
            this.id = "P00" + ++count;
        }else if (count < 100){
            this.id = "P0" + ++count;
        }else{
            this.id = "P" + ++count;
        }
    }

}
