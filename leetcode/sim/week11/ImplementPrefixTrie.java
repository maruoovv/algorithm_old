class Trie {

    private Trie[] tries = new Trie[26];
    private boolean isEnd = false;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int index = word.charAt(0) - 'a';
        if (this.tries[index] == null) {
            this.tries[index] = new Trie();
        }
        
        if (word.length() == 1) {
            this.tries[index].isEnd = true;
            return;
        }
        
        this.tries[index].insert(word.substring(1));
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int index = word.charAt(0) - 'a';
        if (this.tries[index] == null) return false;
        else {
            if (word.length() == 1) {
                if (this.tries[index].isEnd) return true; 
                else return false;
            } 
            
            return this.tries[index].search(word.substring(1));
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int index = prefix.charAt(0) - 'a';
        if (this.tries[index] == null) return false;  
        else {
            if (prefix.length() == 1) {
                if (this.tries[index] != null) return true; 
                else return false;
            }
            
            return this.tries[index].startsWith(prefix.substring(1));
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
