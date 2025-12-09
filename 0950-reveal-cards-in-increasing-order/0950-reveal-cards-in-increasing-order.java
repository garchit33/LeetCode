class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();

        for(int i = deck.length-1; i>=0; i--){
            if(q.size()>0){
                q.offer(q.poll());
            }
            q.offer(deck[i]);
        }

        int[] ans = new int[deck.length];
        for(int i = deck.length-1; i>=0; i--){
            ans[i] = q.poll();
        }

        return ans;
    }
}