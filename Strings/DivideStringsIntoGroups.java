import java.util.*;
//https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int j = 0;
        int n = s.length();
        List<String> result = new ArrayList<>();
        String res = "";

        while (j < n) {
            //add characters into the string res
            res += s.charAt(j);
            //once the string size is equal to the k then add it into the main result String 
            if (res.length() == k) { 
                result.add(res);
                res = "";  // Reset for next group
            }
            j++;
        }

        //check if any of them is empty then just fill it by the given character
        if (!res.isEmpty()) {
            while (res.length() < k) {
                res += fill;
            }
            result.add(res);
        }

        //and just conver the list into String array 
        return result.toArray(new String[0]);
    }
}
