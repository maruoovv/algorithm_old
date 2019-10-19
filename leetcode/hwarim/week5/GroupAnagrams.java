package week5;

import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> answer = new ArrayList<List<String>>();
		HashMap<String, Integer> groups = new HashMap<String, Integer>();
		int i = 0;
		for (String str : strs) {
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String tmpStr = new String(tmp);
			if (groups.get(tmpStr) != null) {
				answer.get(groups.get(tmpStr)).add(str);
			} else {
				groups.put(tmpStr, i);
				List<String> newList = new ArrayList<String>();
				newList.add(str);
				answer.add(newList);
				i++;
			}
		}
		return answer;
	}
}
