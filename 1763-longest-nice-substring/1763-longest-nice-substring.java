class Solution {
    // time:O(n^3), n = number of character to loop through
    //space:O(n), n = number of character in a HashSet

    public String longestNiceSubstring(String s) {

       // ij 
       // Y  a  y        sub = Ya       set = {Y,a}        f

       // i  j 
       // Y  a  y        sub = Yay      set = {Y,a,y}      f

       // i     j 
       // Y  a  y        sub = Yay      set = {Y,a,y}      f

       //    ij 
       // Y  a  y        sub = ay       set = {a,y}        f

       //    i  j 
       // Y  a  y        sub = ay       set = {a,y}        f

       //       ij  
       // Y  a  y        sub = y        set = {y}          f


        String result = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if(isNice(sub) == true) {
                    if(sub.length() > result.length()) result = sub;
                }
            }
        }

        return result;
    }

    public boolean isNice(String s) {
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) set.add(c);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!(set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c)))) {
                return false;
            }
        }

        return true;
    }
}