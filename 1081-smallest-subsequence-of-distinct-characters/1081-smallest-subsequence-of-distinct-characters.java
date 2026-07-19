class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(inStack[ch - 'a']){
                continue;
            }

            while(!st.isEmpty() && st.peek() > ch && lastIdx[st.peek() - 'a'] > i){
                char removed = st.pop();
                inStack[removed - 'a'] = false;
            }

            st.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}