class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res = new ArrayList<>();
        fun(res,"",0,0,n);
        return res;
    }
    public void fun(List<String>res,String s,int open,int close,int n){
        if(open == close && s.length() == 2*n){
            res.add(s);
            return;
        }
        if(open < n){
        fun(res,s+'(',open+1,close,n);
        }

        if(close< open){
        fun(res,s+')',open,close+1,n);
        }
    }
}