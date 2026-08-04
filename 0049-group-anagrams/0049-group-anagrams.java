class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String sortedStr = sortString(str);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }

    private String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(char ch : arr){
            sb.append(ch);
        }
        return sb.toString();
    }
}