class Solution {
    public boolean canTransform(String start, String result) {
        if (start.length() != result.length())
            return false;

        int i = 0, j = 0;
        int n = start.length();
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X')
                i++;
            while (j < n && result.charAt(j) == 'X')
                j++;

            if(i == n ^ j == n)
                return false;

            if (i < n && j < n) {
                if (start.charAt(i) != result.charAt(j))
                    return false;

                if (start.charAt(i) == 'L' && j > i)
                    return false;

                if (start.charAt(i) == 'R' && i > j)
                    return false;
            }

            i++;
            j++;
        }
        return true;
    }
}