class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l = players.length-1;
        int r = trainers.length-1;
        int count = 0;
        while(l>=0 && r>=0){
            if(players[l] > trainers[r]){
                l--;
            }else{
                r--;
                l--;
                count++;
            }
        }
        return count;
    }
}