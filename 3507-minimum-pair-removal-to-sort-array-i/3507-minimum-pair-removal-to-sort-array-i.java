class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums)
            list.add(n);
        
        int count = 0;
        while(!isSorted(list)){
            int minSum = Integer.MAX_VALUE;
            int pos = -1;
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i) + list.get(i+1) < minSum){
                    minSum = list.get(i) + list.get(i+1);
                    pos = i;
                }
            }

            list.set(pos, minSum);
            list.remove(pos+1);

            count++;
        }
        return count;
    }

    private boolean isSorted(List<Integer> list){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1))
                return false;
        }
        return true;
    }
}