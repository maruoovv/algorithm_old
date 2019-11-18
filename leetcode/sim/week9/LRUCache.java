class LRUCache {
    private LinkedList<Integer> lru = new LinkedList<>();
    private Map<Integer, Integer> cache = new HashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        Integer value = cache.get(key);
        
        if (value == null) return -1; 
        else { 
            lru.remove(lru.indexOf(key));
            lru.add(key);
            return value; 
        }
    }
    
    public void put(int key, int value) {
        if (lru.size() >= capacity) {
            if (cache.get(key) == null) {
                Integer removed = lru.poll();
                cache.put(removed, null);
            } else {
                lru.remove(lru.indexOf(key));
            }
            lru.add(key);
        } else {
            if (cache.get(key) == null)
                lru.add(key);
            else {
                lru.remove(lru.indexOf(key));
                lru.add(key);
            }
        }
        cache.put(key, value);
    }
}
