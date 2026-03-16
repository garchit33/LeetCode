class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int maxLen = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length(); j++){
                char ch = grid[i].charAt(j);
                if(ch == '@')
                    q.offer(new int[]{0, i, j});
                else if(ch>='a' && ch <= 'f'){
                    maxLen = Math.max(ch-'a'+1, maxLen);
                }
            }
        }

        Set<String> vis = new HashSet<>();
        int steps = 0;
        while(q.size() > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[1];
                int y = rm[2];
                int key = rm[0];

                if(key == (1<<maxLen)-1)
                    return steps;

                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx<0 || nx >= grid.length || ny<0 || ny >= grid[0].length())
                        continue;
                    
                    char ch = grid[nx].charAt(ny);
                    if(ch == '#')
                        continue;
                    
                    if(ch>='A' && ch<='F' && ((key>>(ch-'A'))&1)==0)
                        continue;
                    
                    int newKey = key;

                    if(ch >= 'a' && ch <= 'f'){
                        newKey |= (1<<(ch-'a'));
                    }

                    if(!vis.contains(newKey + " " + nx + " " + ny)){
                        q.offer(new int[]{newKey, nx, ny});
                        vis.add(newKey + " " + nx + " " + ny);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}