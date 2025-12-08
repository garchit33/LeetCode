class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean foundOpennable = true;
        List<Integer> boxes = new ArrayList<>();
        int totalCandies = 0;

        for(int b : initialBoxes){
            boxes.add(b);
        }

        while(boxes.size() > 0 && foundOpennable){
            foundOpennable = false;
            List<Integer> nextBoxes = new ArrayList<>();
            for(int boxId : boxes){
                if(status[boxId] == 1){
                    foundOpennable = true;
                    for(int cb : containedBoxes[boxId]){
                        nextBoxes.add(cb);
                    }
                    for(int k : keys[boxId]){
                        status[k]=1;
                    }
                    totalCandies+=candies[boxId];
                }else {
                    nextBoxes.add(boxId);
                }
            }
            boxes = nextBoxes;
        }
        return totalCandies;
    }
}