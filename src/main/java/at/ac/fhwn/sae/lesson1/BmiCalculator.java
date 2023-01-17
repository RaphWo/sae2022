package at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    double height;
    double weight;
    double bmi;

    public BmiCalculator(double height, double weight){
        this.height = height;
        this.weight = weight;
        this.bmi = 0;
    }

    public void calc(){this.bmi = weight / Math.pow(height,2);}

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Bitte geben Sie die Körpergröße in Metern an und verwenden Sie einen Punkt als Komma: ");
        String input = in.next();
        double height = Double.parseDouble(input);
        System.out.print("Bitte geben Sie das Körpergewicht in Kilogramm an und verwenden Sie einen Punkt als Komma: ");
        input = in.next();
        double weight = Double.parseDouble(input);
        BmiCalculator bmi = new BmiCalculator(height, weight);
        bmi.calc();
        String type;
        if(bmi.bmi < 18.5){
            type = "Untergewicht";
        }else if(bmi.bmi <25){
            type = "Normalgewicht";
        }else{
            type = "Übergewicht";
        }
        System.out.printf("Ihr BMI beträgt %.1f. Sie haben somit %s.",bmi.bmi,type);
    }
}
