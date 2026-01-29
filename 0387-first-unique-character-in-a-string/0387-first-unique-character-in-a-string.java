class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        // Step 1: count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Step 2: find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // no unique character
    }
}