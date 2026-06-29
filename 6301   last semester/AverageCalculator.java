public class AverageCalculator {

    public static void main(String[] args) {
        // Test case that might cause a crash or incorrect result
        String[] myInputs = {"10", "20", "abc", "30"}; 
        System.out.println("Average: " + calculateAverage(myInputs));
    }

    /**
     * Calculates average of numeric strings.
     * LOGIC: Sum all numbers and divide by count.
     */
    public static double calculateAverage(String[] inputs) {
        double sum = 0;
        // BUG 1: Potential NullPointerException if inputs is null
        // BUG 2: Potential Division by Zero if inputs is empty
        for (int i = 0; i <= inputs.length; i++) { // BUG 3: Off-by-one error
            // BUG 4: No error handling for non-numeric strings
            int val = Integer.parseInt(inputs[i]);
            sum += val;
        }
        return sum / inputs.length;
    }
}
