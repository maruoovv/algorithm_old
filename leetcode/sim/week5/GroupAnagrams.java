package sim.week5;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tmp = new String(temp);

            if (map.get(tmp) != null) {
                List<String> list = map.get(tmp);
                list.add(new String(temp));
                map.put(tmp, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp, list);
            }
        }

        map.forEach((k, v) -> result.add(v));

        return result;
    }
}
