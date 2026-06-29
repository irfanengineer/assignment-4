import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * AverageCalculator
 *
 * <p>This program calculates the average of numeric strings.
 * It ignores invalid inputs and logs important events.</p>
 *
 * <p>Features:
 * - Handles null and empty input arrays
 * - Avoids crashes using try-catch
 * - Uses logging instead of print statements
 * - Uses assertions for validation</p>
 */
public class AverageCalculator {

    private static final Logger logger =
        Logger.getLogger(AverageCalculator.class.getName());

    public static void main(String[] args) {

        String[] myInputs = {"10", "20", "abc", "30"};

        System.out.println("Average: " + calculateAverage(myInputs));
    }

    /**
     * Calculates the average of an array of numeric strings.
     *
     * <p>This method parses each string into an integer and computes
     * the average. Invalid numeric strings are ignored and logged.</p>
     *
     * @param inputs an array of strings representing numbers
     * @return the average of valid numbers
     * @throws IllegalArgumentException if input is null or empty
     */
    public static double calculateAverage(String[] inputs) {

        if (inputs == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        if (inputs.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty");
        }

        assert inputs.length > 0 : "Array must not be empty";

        double sum = 0;
        int count = 0;

        for (int i = 0; i < inputs.length; i++) {
            try {
                int val = Integer.parseInt(inputs[i]);
                sum += val;
                count++;

                logger.info("Parsed number: " + val);

            } catch (NumberFormatException e) {
                logger.warning("Invalid number: " + inputs[i]);
            }
        }

        return sum / count;
    }
}
