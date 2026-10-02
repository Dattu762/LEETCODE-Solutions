class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, new StringBuilder(),n,0);
        return res;
    }
    
   public void recurse(List<String> res, int sum, StringBuilder s, int n,int lsum) {

        if(s.length()==n*2){
            res.add(s.toString());
            return;
        }
        if(lsum<n){
            s.append("(");
            recurse(res,sum+1,s,n,lsum+1);
            s.deleteCharAt(s.length() - 1);
        }

        if(sum>0){
            s.append(")");
            recurse(res,sum-1,s,n,lsum);
            s.deleteCharAt(s.length() - 1); 
        }


    }
}