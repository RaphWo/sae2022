package at.ac.fhwn.sae.lesson3.AnimalFarm;

public class Cow extends Animal{
    static int count = 0;

    public Cow(String name){
        this.name = name;
        if (count < 9){
            this.id = "K00" + ++count;
        }else if (count < 99){
            this.id = "K0" + ++count;
        }else{
            this.id = "K" + ++count;
        }
    }

}
