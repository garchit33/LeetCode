class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> regionsMap = new HashMap<>();
        regionsMap.put(0,0);

        int region = 2;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, region);
                    regionsMap.put(region, area);
                    region++;
                }
            }
        }

        int max = regionsMap.getOrDefault(2,0);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    Set<Integer> nbr = new HashSet<>();
                    nbr.add(i>0 ? grid[i-1][j] : 0);
                    nbr.add(i<grid.length-1 ? grid[i+1][j] : 0);
                    nbr.add(j>0 ? grid[i][j-1] : 0);
                    nbr.add(j<grid[0].length-1 ? grid[i][j+1] : 0);

                    int area = 1;
                    for(int n : nbr){
                        area+=regionsMap.get(n);
                    }

                    if(area > max){
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, int region){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1)
            return 0;
        
        grid[i][j] = region;
        int sum = 1;
        sum += dfs(grid, i-1, j, region);
        sum += dfs(grid, i+1, j, region);
        sum += dfs(grid, i, j-1, region);
        sum += dfs(grid, i, j+1, region); 
        return sum;
    }
}