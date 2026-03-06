class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int l=0;
        int r=0;
        while(l < firstList.length && r < secondList.length){
            if(firstList[l][1] >= secondList[r][0] && firstList[l][0] <= secondList[r][1]){
                list.add(new int[]{Math.max(firstList[l][0], secondList[r][0]), Math.min(firstList[l][1], secondList[r][1])});
            }

            if(firstList[l][1] > secondList[r][1]){
                r++;
            }else if(firstList[l][1] < secondList[r][1]){
                l++;
            }else {
                l++;
                r++;
            }
        }

        int[][] res = new int[list.size()][];
        int x=0;
        for(int[] arr : list){
            res[x++] = arr;
        }   
        return res;
    }
}