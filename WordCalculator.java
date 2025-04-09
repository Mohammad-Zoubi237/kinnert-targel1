/*
Mohammad Zoubi 324005206
Shada Salty 214658809
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class WordCalculator {
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);
        System.out.println("Please enter your equation using numbers from one to ten\n");
        String input = num.nextLine().toLowerCase();
        String[] space = input.split(" ");
        List<String> newspace = new ArrayList<>();

        for (String word : space) {
            switch (word) {
                case"zero":newspace.add("0");break;
                case "one": newspace.add("1"); break;
                case "two": newspace.add("2"); break;
                case "three": newspace.add("3"); break;
                case "four": newspace.add("4"); break;
                case "five": newspace.add("5"); break;
                case "six": newspace.add("6"); break;
                case "seven": newspace.add("7"); break;
                case "eight": newspace.add("8"); break;
                case "nine": newspace.add("9"); break;
                case "ten": newspace.add("10"); break;
                case "plus": case "minus": case "times": case "dividedby":
                    newspace.add(word); break;
                default:
                    System.out.println("Invalid input: " + word);
                    return;
            }
        }

        for (int i = 1; i < newspace.size() - 1; i =i+ 2) {
            String op = newspace.get(i);
            if (op.equals("times") || op.equals("dividedby")) {
                int num1 = Integer.parseInt(newspace.get(i - 1));
                int num2 = Integer.parseInt(newspace.get(i + 1));
                int result = 0;

                if (op.equals("times")) {
                    result = num1 * num2;
                } else {
                    if (num2 == 0) {
                        System.out.println("Error: cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                }

                newspace.set(i - 1, Integer.toString(result));
                newspace.remove(i);
                newspace.remove(i);
                i =i-2;
            }
        }

        int sum = Integer.parseInt(newspace.get(0));
        for (int i = 1; i < newspace.size(); i += 2) {
            String op = newspace.get(i);
            int num1 = Integer.parseInt(newspace.get(i + 1));

            if (op.equals("plus")) {
                sum =sum+ num1;
            } else if (op.equals("minus")) {
                sum = sum -num1;
            } else {
                System.out.println("Unknown operator: " + op);
                return;
            }
        }

        System.out.println("The result of expression: " + input + " = "+sum);
}
}
