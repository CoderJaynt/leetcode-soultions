class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0;
        int b = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid.length ; j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0)+1);

                if(map.get(grid[i][j]) > 1){
                    a = grid[i][j];
                }               
            }
        }

        int n = grid.length;

        for(int i = 1 ; i<=n * n ; i++){
            if(!map.containsKey(i)){
                b = i;
                break;
            }
        }

        return new int[]{a, b};

        
    }
}