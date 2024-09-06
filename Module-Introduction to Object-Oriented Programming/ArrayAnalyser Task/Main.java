import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * A main class to test the ArrayAnalyser class.
 * @author Tobias Wenner
 * @version 1.0
 */
public class Main
{
    public static final String CAMPUS_NAME = "Canterbury";

    /**
     * The main method for testing the ArrayAnalyser.
     * @param args Not used.
     * @throws IOException If the file cannot be read.
     */
    public static void main(String[] args)
            throws IOException
    {
        System.out.printf("Array Analyser for %s%n", CAMPUS_NAME);

        // Read the data into a list of strings.
        Path filePath = Paths.get("numbersfile.txt");
        List<String> theData = Files.readAllLines(filePath);

        // Convert the list of Strings into an array of int values.
        int[] numbers = convertInput(theData);

        // Set up the analyser.
        ArrayAnalyser analyser = new ArrayAnalyser(numbers);
        // Test the analyser.
        System.out.println("Test with the real data.");
        testTheAnalyser(analyser);

        // Here is a smaller data set that will be easier to check the results of.
        // Sum is 34, max is 8, most frequent is 3, unique count is 4.
        int[] smallDataSet = {
                3, 5, 2, 3, 1, 7, 5, 8,
        };
        ArrayAnalyser smallAnalyser = new ArrayAnalyser(smallDataSet);
        System.out.println("Test with a small amount of data.");
        testTheAnalyser(smallAnalyser);
    }

    /**
     * Convert each String in the list to an int value and
     * store it into an array.
     * @param theData The data to be converted to int values.
     * @return The array of integers from the converted data.
     */
    public static int[] convertInput(List<String> theData)
    {
        int[] numbers = new int[theData.size()];
        int i = 0;
        for(String aString : theData){
            int anInt = Integer.parseInt(theData.get(i));
            numbers[i] = anInt;
            i++;
        }
        return numbers;
    }


    /**
     * Call the analysers methods to test that it is returning
     * the correct values.
     * Print out the results of each test.
     * For instance, call its 'sum' method to check that it
     * returns the sum of all the numbers in the analyser's array.
     * @param analyser The analyser to be tested.
     */
    public static void testTheAnalyser(ArrayAnalyser analyser)
    {
        System.out.println("Array Contents: " + Arrays.toString(analyser.getNumbers()));
        System.out.println("Array Sum: " + analyser.getSum());
        System.out.println("Array max is: " + analyser.getMax());
        System.out.println("Amount of Unique Values: " + analyser.getUniqueCount());
        System.out.println("Lowest most frequent number: " + analyser.getSmallestMostFrequent());
        analyser.printDeliveryOrder();
    }



}
