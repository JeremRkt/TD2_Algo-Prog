package org.example;
import MSort.MergeSort;
import RadixS.RadixSort;
import TDD.Frame;
import TDD.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Merge sort w/out recursion
       int[] arr = {2,5,6,8,1,9,3,7,4,20, 14,40};
       MergeSort.MergeSort(arr);

        for (int i : arr) {
            System.out.println(i + "" + "\n");
        }

        //Radix Sort
        int []arr1 = {170, 45, 75, 90, 2, 802, 2, 60};
        int n = arr1.length;

        RadixSort.radixsort(arr1,n);
        RadixSort.print(arr1,n);

        //TDD : Bowling score

        Game game = new Game();
        Frame frame1 = new Frame();

        Scanner scanner = new Scanner(System.in);
        int[]frameScores = new int[10];

        for (int frame = 1; frame <= 10; frame++) {

            System.out.printf("Enter number of pins knocked down on first roll of frame %d: ", frame);
            int firstRoll = scanner.nextInt();
            game.roll(firstRoll);

            if (firstRoll == 10) {
                System.out.println("STRIKE!");
                frameScores[frame - 1] = 10;
                continue;
            }

            System.out.printf("Enter number of pins knocked down on second roll of frame %d: ", frame);
            int secondRoll = scanner.nextInt();
            game.roll(secondRoll);

            if (firstRoll + secondRoll == 10) {
                System.out.println("SPARE!");
                frameScores[frame - 1] = 10;
            } else {
                frameScores[frame - 1] = firstRoll + secondRoll;
            }
        }

        int totalScore = game.score();
        System.out.printf("Final score: %d%n", totalScore);

        // Display board
        System.out.println("--------------------------------------------------------------");
        System.out.println("| Frame |  Roll 1  |  Roll 2  |  Score  | Cumulative Score |");
        System.out.println("--------------------------------------------------------------");
        int cumulativeScore = 0;
        for (int frame = 1; frame <= 10; frame++) {
            int roll1 = game.getRoll(frame, 1);
            int roll2 = game.getRoll(frame, 2);
            int frameScore = frameScores[frame - 1];
            cumulativeScore += frameScore;
            System.out.printf("|  %d   |    %d    |    %d    |    %d    |        %d        |\n",
                    frame, roll1, roll2, frameScore, cumulativeScore);
            if (frame == 10 && (frame1.isStrike(9) || frame1.isSpare(9))) {
                int roll3 = game.getRoll(10, 3);
                cumulativeScore += roll3;
                System.out.printf("|  %d   |    %d    |    %d    |    %d    |        %d        |\n",
                        frame + 1, game.getRoll(frame, 3), roll3, roll3, cumulativeScore);
            }
            System.out.println("--------------------------------------------------------------");
        }
    }
}