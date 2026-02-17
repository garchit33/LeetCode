class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()+1];
        for(int[] a : shifts){
            int startIdx = a[0];
            int endIdx = a[1]+1;
            int dir = a[2];
            int val = dir == 0?-1:1;
            arr[startIdx]+=val;
            arr[endIdx]-=val;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum+=arr[i];
            int val = sum;
            if(val > 0){
                val = ((s.charAt(i)-'a')+val)%26;
            }else{
                val = ((s.charAt(i)-'a' + val)%26 + 26)%26;
            }
            sb.append((char)(val+97));
        }
        return sb.toString();
    }
}