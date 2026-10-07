import java.util.*;

class TimeMap {
    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String result = "";

        // Binary Search to find the largest timestamp <= target timestamp
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                low = mid + 1; // Try to find a closer (larger) timestamp
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */