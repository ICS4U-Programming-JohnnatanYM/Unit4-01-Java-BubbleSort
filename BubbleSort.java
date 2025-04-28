import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program reads arrays of integers from an input file,
 * sorts each array using bubble sort,
 * and writes the sorted arrays to an output file.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-04-26
 */
public final class BubbleSort {

    /**
     * This is to satisfy the style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BubbleSort() {

        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // List to store arrays read and sorted from the file
        ArrayList<int[]> arrayList = new ArrayList<>();

        try {
            // Create a Scanner to read from the input file
            Scanner scanner = new Scanner(new File("input.txt"));

            // Loop through each line in the input file
            while (scanner.hasNextLine()) {
                // Read the current line from the file
                String line = scanner.nextLine();

                // Split the line into  string tokens by whitespace
                String[] tokens = line.trim().split("\\s+");

                // Create an integer array from the tokens
                int[] numbers = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    numbers[i] = Integer.parseInt(tokens[i]);
                }

                // Sort the array using the bubble sort method
                sortEm(numbers);

                // Add the sorted array to the list
                arrayList.add(numbers);
            }

            // Close the scanner after reading the file
            scanner.close();

            // Create a FileWriter to write to the output file
            FileWriter writer = new FileWriter("output.txt");

            // Loop through each sorted array
            for (int[] arr : arrayList) {
                // Loop through each number in the current array
                for (int num : arr) {
                    // Write the number followed by a space to the file
                    writer.write(num + " ");
                }
            // Write a newline to the file after each array
            writer.write("\n");
            }

        // Close the writer to finish writing the file
            writer.close();
                System.out.println("Output written to output.txt");

        // Handle case where the input file is empty
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("Error writing to output file.");
        }
    }

    /**
     * Sorts an array using bubble sort algorithm.
     *
     * @param ar The array to sort.
     */
    private static void sortEm(final int[] ar) {
        // Temporary variable used during the swapping process
        int temp;

        // Outer loop decreases the range of the inner loop each time
        for (int i = ar.length - 1; i > 0; i--) {
            // Loop to compare other elements
            for (int j = 0; j < i; j++) {
                // If numbers are in the wrong order, swap them
                if (ar[j] > ar[j + 1]) {
                    // Store the current value in temp
                    temp = ar[j];
                    // Move the next value to the current position
                    ar[j] = ar[j + 1];
                    // Assign the stored value to the next position
                    ar[j + 1] = temp;
                }
            }
        }
    }
}
