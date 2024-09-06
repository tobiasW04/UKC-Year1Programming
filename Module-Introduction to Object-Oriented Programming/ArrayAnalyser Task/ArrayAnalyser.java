import java.util.*;

/**
 * An array analyser, that contains a range of methods that can
 * provide information on the data held in its array.
 * @author Tobias Wenner
 * @version 1.0
 */
public class ArrayAnalyser {
    private int[] numbers;

    /**
     * Create an ArrayAnalyser.
     * Store the array parameter into an array field so that it
     * can be accessed by the methods you write.
     *
     * @param numbers An array of numbers to be analysed.
     */
    public ArrayAnalyser(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Returns the Array of Numbers.
     *
     * @return The Array of Numbers.
     */
    public int[] getNumbers() {
        return numbers;
    }

    /**
     * Calculates and returns the sum of all Numbers in the Array.
     *
     * @return Sum of numbers in the Array.
     */
    public int getSum() {
        int i = 0;
        int sum = 0;
        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }
        return sum;
    }

    /**
     * Returns the highest value in the array.
     *
     * @return highest value in the Array.
     */
    public int getMax() {
        Arrays.sort(numbers);
        return numbers[numbers.length -1];
    }

    /**
     * Returns the amount of Unique values within the Array.
     *
     * @return amount of Unique values.
     */
    public int getUniqueCount(){
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> repeatedNumbers = new HashSet<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                repeatedNumbers.add(number);
            }
        }
        uniqueNumbers.removeAll(repeatedNumbers);
        return uniqueNumbers.size();
    }

    /**
     * Returns the most frequent value of an Array. If two or more values have the same frequency, return smallest.
     * @return Smallest most frequent value.
     */
    public int getSmallestMostFrequent(){
        Arrays.sort(numbers);

        int currentNumber = numbers[0];
        int currentCount = 1;

        int mostFrequentNumber = numbers[0];
        int mostFrequentCount = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == currentNumber) {
                currentCount++;
            }
            else {
                if (currentCount > mostFrequentCount || (currentCount == mostFrequentCount && currentNumber < mostFrequentNumber)) {
                    mostFrequentNumber = currentNumber;
                    mostFrequentCount = currentCount;
                }
                currentNumber = numbers[i];
                currentCount = 1;
            }
        }
        if (currentCount > mostFrequentCount || (currentCount == mostFrequentCount && currentNumber < mostFrequentNumber)) {
            mostFrequentNumber = currentNumber;
        }

        return mostFrequentNumber;


    }

    /**
     * Prints the delivery order by grouping even and odd numbers separately.
     * Even numbers are printed in ascending order, followed by odd numbers in descending order.
     */
    public void printDeliveryOrder(){
        Set<Integer> evenNumbers = new HashSet<>();
        Set<Integer> oddNumbers = new HashSet<>();

        for (int aNumber : numbers){
            if (aNumber % 2 == 0){
                evenNumbers.add(aNumber);
            }
            else{
                oddNumbers.add(aNumber);
            }
        }

        Integer[] evenNumbersArray = evenNumbers.toArray(new Integer[0]);
        Arrays.sort(evenNumbersArray);
        for (Integer anInt : evenNumbersArray) {
            System.out.print(anInt + " ");
        }

        System.out.println();

        Integer [] oddNumbersArray = oddNumbers.toArray(new Integer [0]);
        Arrays.sort(oddNumbersArray, Collections.reverseOrder());
        for (Integer anInt : oddNumbersArray) {
            System.out.print(anInt + " ");
        }


    }

}
