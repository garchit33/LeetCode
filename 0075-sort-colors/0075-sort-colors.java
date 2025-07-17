class Solution {
    public void sortColors(int[] nums) {
        //zeroth pointer, 1 pointer, 2 pointer
        int cz = -1;
        int co = 0;
        int ct = nums.length;
        while(co<ct){
            if(nums[co] == 1)
                co++;
            else if(nums[co] == 0){
                cz++;
                int temp = nums[cz];
                nums[cz] = nums[co];
                nums[co] = temp;
                co++;
            }else{
                ct--;
                nums[co] = nums[ct];
                nums[ct] = 2;
            }
        }
    }
}