package sim.week1;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        final int len = s.length();
        int maxLen = 0;
        String answer = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        answer = s.substring(i, j + 1);
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPalindrome(String s) {
        final int len = s.length();

        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

