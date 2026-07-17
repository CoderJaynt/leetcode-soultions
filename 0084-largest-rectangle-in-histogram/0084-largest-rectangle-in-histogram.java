class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxA = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                int element = heights[st.pop()];

                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();

                maxA = Math.max(maxA, (element*(nse-pse-1)));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int element = heights[st.pop()];

            int nse = n;
            int pse = (st.isEmpty()) ? -1 : st.peek();

            maxA = Math.max(maxA, (element*(nse-pse-1)));
        }

        return maxA;
    }
}