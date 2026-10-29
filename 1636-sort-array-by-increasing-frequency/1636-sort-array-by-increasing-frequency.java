class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        List<Integer> result = Arrays.stream(nums).boxed()
            .sorted((a,b) -> {
                int freqCompare = Long.compare(freqMap.get(a), freqMap.get(b));

                return freqCompare != 0 ? freqCompare : Integer.compare(b,a);
            })
            .collect(Collectors.toList());
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}