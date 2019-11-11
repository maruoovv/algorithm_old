class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<String> wordQueue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        wordQueue.add(s);
        map.put(s, s);
        
        while(!wordQueue.isEmpty()) {
            String temp = wordQueue.poll();

            for (String word : wordDict) {
                if (temp.startsWith(word)) {

                    String t1 = temp.substring(0 ,temp.indexOf(word));
                    String t2 = temp.substring(temp.indexOf(word) + word.length());

                    if (t1.isEmpty() && t2.isEmpty()) return true;

                    if (!t1.isEmpty() && map.get(t1) == null) {
                        wordQueue.add(t1);
                        map.put(t1, t1);
                    }
                    if (!t2.isEmpty() && map.get(t2) == null) {
                        wordQueue.add(t2);
                        map.put(t2, t2);
                    }
                }
            }
        }
        
        return false;
    }
    
}
