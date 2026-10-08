import java.util.Random;

class Solution {
    private int[] array;
    private int[] original;
    private Random rand = new Random();

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone(); // Keep a copy of the original array configuration
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        // Fisher-Yates shuffle algorithm
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // Pick a random index from 0 to i
            
            // Swap array[i] and array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        
        return array;
    }
}