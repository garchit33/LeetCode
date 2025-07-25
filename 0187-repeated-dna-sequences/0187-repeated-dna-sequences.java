class Solution {
    public List<String> findRepeatedDnaSequences(String s) {    
        List<String> ans = new ArrayList<>();
        if(s.length() <= 10)    
            return ans;
        
        Set<String> set = new HashSet<>();
        // String str = "";
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<10){
            sb.append(s.charAt(i++));
            // str+=s.charAt(i++);
        }
        set.add(sb.toString());

        while(i<s.length()){
            String sub = s.substring(i-9, i+1);
            if(set.contains(sub) && !ans.contains(sub)){
                ans.add(sub);
            }else {
                set.add(sub);
            }
            i++;
        }
        return ans;
    }
}