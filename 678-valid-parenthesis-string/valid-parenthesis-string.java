class Solution {
    Boolean dp[][] = new Boolean[1001][1001];
    public boolean checkValidString(String s) {
        return fun(0,0,s);
    }
    public boolean fun(int i,int open, String s){
        if(open < 0){
            return false;
        }
        if(i ==  s.length()){
             return open == 0;
        }
        if(dp[i][open] != null){
            return dp[i][open];
        }
        if(s.charAt(i)=='('){
            return dp[i][open] = fun(i+1,open+1,s);
        }
        else if(s.charAt(i)==')'){
            return dp[i][open] = fun(i+1,open-1,s);
        }
        else {
        return dp[i][open] = 
                            fun(i+1,open+1,s) || 
                            fun(i+1,open-1,s) || 
                            fun(i+1,open,s);
        }
    }
}