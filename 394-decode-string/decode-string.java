class Solution {
    public String decodeString(String s) {
        Stack<Integer>st1 = new Stack<>();
        Stack<String>st2 = new Stack<>();

        String str = "";
        int num = 0;

        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num =  num * 10 + (ch-'0');
            }
            else if(ch == '['){
                st1.push(num);
                num = 0;
                st2.push(str);
                str = "";
            }
            else if(ch == ']'){
                int n = st1.pop();
                String repeat = st2.pop();
                String temp = "";

                for(int i=0;i<n;i++){
                    temp += str;
                }
                
                str =  repeat + temp;
            }
            else{
                str += ch;
            }
        }
        return str;
    }
}