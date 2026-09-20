class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // SAME AS 2 SUM PROBLEM BUT HERE WE ARE USING

        int n=nums.length; 
        List<List<Integer>> r=new ArrayList<>();    
        Arrays.sort(nums);
        for (int i=0;i<n-2;i++){
            if(nums[i]>0) break;
            if (i!=0 && nums[i] == nums[i - 1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int s=nums[i]+nums[j]+nums[k];
                if(s==0){
                    r.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(k>j && nums[k]==nums[k+1]) k--;
                }
                if(s<0){
                    j++;
                }
                if(s>0){
                    k--;   
                }
            } 
        }
        return r;

    }
}