class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer>map1=new HashMap<>();
        Map<Character,Integer>map2=new HashMap<>();
        for(char key:s.toCharArray()){
            map1.put(key,map1.getOrDefault(key,0)+1);
        }
        for(char key:t.toCharArray()){
                map2.put(key,map2.getOrDefault(key,0)+1);
            }
        if(map1.equals(map2)){
            return true;
        }
        return false;
    }
}
