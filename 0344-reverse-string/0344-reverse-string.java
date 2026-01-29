class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            // swap s[left] and s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
}