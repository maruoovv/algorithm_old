package week1;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeat {
    public  int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Boolean> map = new HashMap<>();
            map.put(s.charAt(i), true);
            int temp = 1;

            for (int j = i + 1; j < s.length(); j++) {
                if (map.get(s.charAt(j)) != null) {
                    break;
                }

                temp++;
                map.put(s.charAt(j), true);
            }

            if (temp > answer) {
                answer = temp;
            }
        }

        return answer;
    }
}
