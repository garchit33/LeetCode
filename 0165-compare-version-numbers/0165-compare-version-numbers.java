class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");
        int i=0, j=0;
        while(i<arr1.length && j<arr2.length){
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[j]);
            if(a<b)
                return -1;
            if(a>b)
                return 1;
            i++;
            j++;
        }
        while(i<arr1.length){
            int a = Integer.parseInt(arr1[i++]);
            if(a>0)
                return 1;
        }
        while(j<arr2.length){
            int a = Integer.parseInt(arr2[j++]);
            if(a>0)
                return -1;
        }
        return 0;
    }
}