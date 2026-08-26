class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        int left = 0;
        int ones = 0;

        String answer = "";

        for (int right = 0; right < n; right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // If more than k ones, shrink from left
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                // Remove leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Update answer
                if (answer.equals("") ||
                    current.length() < answer.length() ||
                    (current.length() == answer.length() &&
                     current.compareTo(answer) < 0)) {

                    answer = current;
                }
            }
        }

        return answer;
    }
}