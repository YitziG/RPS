package day5;


import utils.MyFiles;

import java.io.IOException;
import java.util.Stack;

public class Day5 {

    //         [H]     [W] [B]
    //     [D] [B]     [L] [G] [N]
    // [P] [J] [T]     [M] [R] [D]
    // [V] [F] [V]     [F] [Z] [B]     [C]
    // [Z] [V] [S]     [G] [H] [C] [Q] [R]
    // [W] [W] [L] [J] [B] [V] [P] [B] [Z]
    // [D] [S] [M] [S] [Z] [W] [J] [T] [G]
    // [T] [L] [Z] [R] [C] [Q] [V] [P] [H]

    // push 'T', 'D', 'W', 'Z', 'V', 'P' onto stack1
    // push 'L', 'S', 'W', 'V', 'F', 'J', 'D' onto stack2
    // push 'Z', 'M', 'L', 'S', 'V', 'T', 'B', 'H' onto stack3
    // push 'R', 'S', 'J' onto stack4
    // push 'C', 'Z', 'B', 'G', 'F', 'M', 'L', 'W' onto stack5
    // push 'Q', 'W', 'V', 'H', 'Z', 'R', 'G', 'B' onto stack6
    // push 'V', 'J', 'P', 'C', 'B', 'D', 'N' onto stack7
    // push 'P', 'T', 'B', 'Q', onto stack8
    // push 'H', 'G', 'Z', 'R', 'C' onto stack9
    private static Stack<String> stack1 = new Stack<>();
    private static Stack<String> stack2 = new Stack<>();
    private static Stack<String> stack3 = new Stack<>();
    private static Stack<String> stack4 = new Stack<>();
    private static Stack<String> stack5 = new Stack<>();
    private static Stack<String> stack6 = new Stack<>();
    private static Stack<String> stack7 = new Stack<>();
    private static Stack<String> stack8 = new Stack<>();
    private static Stack<String> stack9 = new Stack<>();

    // "move 3 from 2 to 9" means that the top 3 elements of stack2 should be moved, one at a time, to the top of stack9
    private static void move(int num, Stack<String> from, Stack<String> to) {
        for (int i = 0; i < num; i++) {
            to.push(from.pop());
        }
    }

    // "move 3 from 2 to 9" means that the top 3 elements of stack2 should be moved with their order preserved to the top of stack9
    private static void moveWithOrder(int num, Stack<String> from, Stack<String> to) {
        Stack<String> temp = new Stack<>();
        for (int i = 0; i < num; i++) {
            temp.push(from.pop());
        }
        for (int i = 0; i < num; i++) {
            to.push(temp.pop());
        }
    }



    // gets num, from, and to from the string
    private static void move(String s) {
        String[] split = s.split(" ");
        int num = Integer.parseInt(split[1]);
        Stack<String> from = getStack(split[3]);
        Stack<String> to = getStack(split[5]);
        moveWithOrder(num, from, to);
    }

    // returns the stack that corresponds to the string
    private static Stack<String> getStack(String s) {
        switch (s) {
            case "1":
                return stack1;
            case "2":
                return stack2;
            case "3":
                return stack3;
            case "4":
                return stack4;
            case "5":
                return stack5;
            case "6":
                return stack6;
            case "7":
                return stack7;
            case "8":
                return stack8;
            case "9":
                return stack9;
            default:
                return null;
        }
    }

    public static void main(String[] args) throws IOException {
        // push the letters onto the stacks
        stack1.push("T");
        stack1.push("D");
        stack1.push("W");
        stack1.push("Z");
        stack1.push("V");
        stack1.push("P");

        stack2.push("L");
        stack2.push("S");
        stack2.push("W");
        stack2.push("V");
        stack2.push("F");
        stack2.push("J");
        stack2.push("D");

        stack3.push("Z");
        stack3.push("M");
        stack3.push("L");
        stack3.push("S");
        stack3.push("V");
        stack3.push("T");
        stack3.push("B");
        stack3.push("H");

        stack4.push("R");
        stack4.push("S");
        stack4.push("J");

        stack5.push("C");
        stack5.push("Z");
        stack5.push("B");
        stack5.push("G");
        stack5.push("F");
        stack5.push("M");
        stack5.push("L");
        stack5.push("W");

        stack6.push("Q");
        stack6.push("W");
        stack6.push("V");
        stack6.push("H");
        stack6.push("Z");
        stack6.push("R");
        stack6.push("G");
        stack6.push("B");

        stack7.push("V");
        stack7.push("J");
        stack7.push("P");
        stack7.push("C");
        stack7.push("B");
        stack7.push("D");
        stack7.push("N");

        stack8.push("P");
        stack8.push("T");
        stack8.push("B");
        stack8.push("Q");

        stack9.push("H");
        stack9.push("G");
        stack9.push("Z");
        stack9.push("R");
        stack9.push("C");

        // initialize an array of stacks
        Stack<String>[] stacks = new Stack[9];
        stacks[0] = stack1;
        stacks[1] = stack2;
        stacks[2] = stack3;
        stacks[3] = stack4;
        stacks[4] = stack5;
        stacks[5] = stack6;
        stacks[6] = stack7;
        stacks[7] = stack8;
        stacks[8] = stack9;


        String[] steps = MyFiles.fileToList("src/day5/input.txt");

        // do the steps
        for (String step : steps) {
            // print the stacks before the step
            for (Stack<String> stack : stacks) {
                System.out.println(stack);
            }
            System.out.println(step);

            move(step);

        }

        // print the top of each stack
        for (Stack<String> stack : stacks) {
            System.out.println(stack.peek());
        }










}
}
