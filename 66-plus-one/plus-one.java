class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        // Adding one to the last digit
        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10; // Update the digit
            carry = sum / 10; // Update the carry
            if (carry == 0) {
                // If there's no carry, we can stop the loop
                break;
            }
        }
        // If there's still a carry after iterating through all digits
        if (carry > 0) {
            // Create a new array with an additional digit
            int[] newArray = new int[len + 1];
            newArray[0] = carry; // Set the first digit to the carry
            // Copy the remaining digits from the original array
            System.arraycopy(digits, 0, newArray, 1, len);
            return newArray;
        } else {
            return digits; // No carry, return the original array
        }
    }
}
