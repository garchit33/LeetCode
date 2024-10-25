class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for(int num : nums1){
            arr[num]++;
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(arr[num]>0){
                list.add(num);
                arr[num]--;
            }
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}