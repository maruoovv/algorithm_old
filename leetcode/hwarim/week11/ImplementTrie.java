class Trie {
    static Trie root;
    char key;
    boolean end;
    HashMap<Character,Trie> childList;
    /** Initialize your data structure here. */
    public Trie() {
        root=this;
        childList=new HashMap<Character,Trie>();
    }
     public Trie(char c) {
        key=c;
        childList=new HashMap<Character,Trie>();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie tmpTrie=root;
        int length= word.length();

        for(int i=0; i<length; i++){
            char c=word.charAt(i);    
            if(tmpTrie.childList.containsKey(Character.valueOf(c))){
                tmpTrie=tmpTrie.childList.get(Character.valueOf(c));
            } else{
                Trie newTrie= new Trie(c);
                tmpTrie.childList.put(c,newTrie);
                tmpTrie=newTrie;
            }
        }
        tmpTrie.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tmpTrie=root;
        int length= word.length();
     
        for(int i=0; i<length; i++){
             char c=word.charAt(i);
             if(tmpTrie.childList.containsKey(Character.valueOf(c))){
                 tmpTrie=tmpTrie.childList.get(Character.valueOf(c));
             }
             else   return false;
         }
        if(!tmpTrie.end) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tmpTrie=root;
        int length= prefix.length();
     
        for(int i=0; i<length; i++){
             char c=prefix.charAt(i);
             if(tmpTrie.childList.containsKey(Character.valueOf(c))){
                 tmpTrie=tmpTrie.childList.get(Character.valueOf(c));
             }
             else   return false;
         }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */