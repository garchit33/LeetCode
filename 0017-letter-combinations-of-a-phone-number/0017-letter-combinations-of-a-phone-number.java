class Solution {
    HashMap<Character, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return ans;
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        find(digits, 0, new StringBuilder());
        return ans;
    }

    private void find(String digits, int idx, StringBuilder str) {
        if(idx == digits.length()){
            ans.add(str.toString());
            return;
        }

        char currentDigit = digits.charAt(idx);
        String digitValue = map.get(currentDigit);

        if(digitValue != null){
            for(int i=0; i<digitValue.length(); i++){
                char letter = digitValue.charAt(i);
                str.append(letter);
                find(digits, idx+1, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}