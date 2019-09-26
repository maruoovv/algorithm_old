package sim.week2;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    final String phoneMap[][] = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        makeLetter(ans, digits, 0, digits.length(), "");
        return ans;
    }

    private void makeLetter(List<String> res, String digits, int index, int len, String temp) {
        if (index >= len) {
            if (!temp.isEmpty())
                res.add(temp);
            return;
        }

        String[] digit = phoneMap[getIndex(digits, index)];

        for (int i = 0; i < digit.length; i++) {
            final String cur = temp + getDigit(digit, i);
            makeLetter(res, digits,index + 1, len, cur);
        }

        return;
    }

    private int getIndex(String digit, int index) {
        Character cha = digit.charAt(index);
        return (cha - '0') - 2;
    }

    private String getDigit(String[] digit, int index) {
        return digit[index];
    }
}
