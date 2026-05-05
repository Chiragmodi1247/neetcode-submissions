class TimeMap {
    private static class KeyPair {
        List<Integer> timestamps;
        List<String> vals;
        KeyPair() {
            this.timestamps = new ArrayList<>();
            this.vals = new ArrayList<>();
        }
    }
    Map<String, KeyPair> userMap;
    public TimeMap() {
        userMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        KeyPair kv = userMap.computeIfAbsent(key, k -> new KeyPair());
        kv.timestamps.add(timestamp);
        kv.vals.add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!userMap.containsKey(key)) {
            return "";
        }
        KeyPair userValues = userMap.get(key);
        int idx = Collections.binarySearch(userValues.timestamps,timestamp);
        if(idx >= 0) {
            return userValues.vals.get(idx);
        } else {
            int insert = -(idx + 1);
            int floor = insert - 1;
            return floor < 0 ? "" : userValues.vals.get(floor);
        }
    }
}
