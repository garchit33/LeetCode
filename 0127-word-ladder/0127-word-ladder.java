class Solution {
    class Pair {
        String word;
        int count;
        Pair(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String s : wordList){
            set.add(s);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(q.size() > 0){
            Pair rm = q.poll();
            String word = rm.word;
            int count = rm.count;
            if(word.equals(endWord))
                return count;

            for(int i=0; i<word.length(); i++){
                for(char k = 'a'; k <= 'z'; k++){
                    char[] arr = word.toCharArray();
                    arr[i] = k;
                    String str = new String(arr);
                    if(set.contains(str)){
                        q.offer(new Pair(str, count+1));
                        set.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}