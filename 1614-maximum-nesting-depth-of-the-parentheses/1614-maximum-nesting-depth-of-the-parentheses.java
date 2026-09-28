class Solution {
    public int maxDepth(String s) {
        int res=Integer.MIN_VALUE,f=0;

        for(char c:s.toCharArray()){
            if(c=='(') f++;
            else if(c==')') f--;
            res=Math.max(res,f);
        }
        return res;

















        // int c=0,r=0,n=s.length();
        // for(char i:s.toCharArray()){
        //     if(i=='('){
        //         c++;
        //         r=Math.max(r,c);
        //     }else if(i==')') c--;
        // }
        // return r;
    }
}