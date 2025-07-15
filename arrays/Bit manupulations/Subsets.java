 List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for(int mask=0;mask <(1<<n) ;mask++){
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<n;i++){
                if( (mask & 1<<i) !=0){
                    sub.add(nums[i]);
                }
            }
            res.add(sub);
        }
        return res;
