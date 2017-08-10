package com.nmerris.newimprovedfb;

public class FizzBuzzProcessor {


    /**
     * This program displays numbers between 1 and 100.
     * If it's a multiple of 2, display 'Copy' instead of the number.
     * If it's a multiple of 3, display 'Fizz' instead of the number.
     * If it's a multiple of 5, display 'Buzz' instead of the number.
     * If it's a multiple of 10, display 'Cat' instead of the number.
     * Any number that is a multiple of more than one case above,
     * Then output all corresponding words in series, instead of the number.
     * For example, 10 will output "CopyBuzzCat".
     * For example, 6 will output "CopyFizz".
     *
     * @author Nathan Merris
     */

    private int endNum;


    public FizzBuzzProcessor(int endNum) {
        this.endNum = endNum;
    }


    public String startFizzing() {

        String finalOutput = "";
        String output;

        for (int i = 1; i <= endNum; i++) {

            output = ""; // start with empty String every time

            if (i % 2 == 0) { // multiple of 2
                output += "Copy";
            }
            if (i % 3 == 0) { // multiple of 3
                output += "Fizz";
            }
            if (i % 5 == 0) { // multiple of 5
                output += "Buzz";
            }
            if (i % 10 == 0) { // multiple of 10
                output += "Cat";
            }
            if (output == "") { // not a multiple of 2, 3, 5, or 10
                output += Integer.toString(i);
            }

            finalOutput += output;

        } // for

        return finalOutput;
    }



}
