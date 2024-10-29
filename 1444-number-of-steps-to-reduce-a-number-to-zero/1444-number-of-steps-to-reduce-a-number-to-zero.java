class Solution {
    public int numberOfSteps(int num) {
        return totalSteps(num, 0);
    }

    private int totalSteps(int num, int count){
        if(num == 0)
            return count;
        
        if(num%2 == 0)
            return totalSteps(num/2, count+1);
        
        return totalSteps(num-1, count+1);
    }
}