package at.ac.fhwn.sae.lesson2;

import java.util.Scanner;

public class Fibonacci {
    long sum;
    long prev;
    long next;

    public Fibonacci(){
    }
    /**
     * Gets the Fibonacci number of the position entered using a while loop.
     *
     * Faster than recusive call.
     *
     * Problem with variable overflow at position 46 with datatype int, solved by using datatype long.
     *
     * The datatype is considered to be unsigned.
     *
     * @param position the asked position of Fibonacci
     * @return the Fibonacci number of the asked position
     */
    public long wLoop(int position){

        int n = 2;
        prev = 0;
        next = 1;
        while(n <= position){
            sum = prev + next;
            prev = next;
            next = sum;
            n ++;
        }
        return sum;
    }
    /**
     * Gets the Fibonacci number of the position entered using a for loop.
     *
     * Faster than recursive call.
     *
     * Problem with variable overflow at position 46 with datatype int, solved by using datatype long.
     *
     * The datatype is considered to be unsigned.
     *
     * @param position the asked position of Fibonacci
     * @return the Fibonacci number of the asked position
     */
    public long fLoop(int position){
        int n = position - 1;
        prev = 0;
        next = 1;
        for(int i = n; i > 0 ; i--){
            sum = prev + next;
            prev = next;
            next = sum;
        }
        return sum;
    }
    /**
     * Gets the Fibonacci number of the position entered using recursive call.
     *
     *
     *
     * Problem with variable overflow at position 46 with datatype int, solved by using datatype long.
     *
     * The datatype is considered to be unsigned.
     *
     * Negative input leads to stack overflow.
     *
     * @param position the asked position of Fibonacci
     * @return the Fibonacci number of the asked position
     */
    public long rec(int position){
        if (position==1||position==2) return 1;
        else return rec(position-1)+rec(position-2);
    }


    public static void main(String[] args){
        Scanner fib = new Scanner(System.in);
        System.out.print("Welche Fibonacci-Stelle soll berechnet werden? Geben Sie die gewünschte Zahl ein: ");
        int input = fib.nextInt();
        Fibonacci calc = new Fibonacci();
        System.out.println(calc.wLoop(input));
        System.out.println(calc.fLoop(input));
        System.out.println(calc.rec(input));
    }
}
