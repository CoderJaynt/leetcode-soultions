class Tuple{
    int dist;
    int row;
    int col;

    Tuple(int dist, int row, int col){
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] distance = new int[m][n];

        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.dist - y.dist);

        pq.add(new Tuple(0, 0, 0));
        distance[0][0] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int dist = t.dist;
            int r = t.row;
            int c = t.col;

            if(r == m-1 && c == n-1) return dist;

            for(int i = 0 ; i<4 ; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newDiff = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), dist);

                    if(newDiff < distance[nr][nc]){
                        distance[nr][nc] = newDiff;
                        pq.add(new Tuple(distance[nr][nc], nr, nc));
                    }
                }
            }
        }
        return 1;
    }
}