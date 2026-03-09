class Solution {
    public boolean canTransform(String start, String result) {
        if(start.length() != result.length())
            return false;
        
        int i=0;
        int j=0;
        while(i<start.length() || j<result.length()){
            while(i < start.length() && start.charAt(i) == 'X'){
                i++;
            }
            while(j < result.length() && result.charAt(j) == 'X'){
                j++;
            }

            if(i == start.length() ^ j == result.length())
                return false;
            
            if(i < start.length() && j < result.length()){
                if(start.charAt(i) != result.charAt(j))
                    return false;

                if(start.charAt(i) == 'L' && i < j){
                    return false;
                }
                if(start.charAt(i) == 'R' && i > j){
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}