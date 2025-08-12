class Solution {
    public int search(int[] nums, int target) {
        return searchtar(nums,target,0,nums.length-1);
    }
    static int searchtar(int[] nums, int target, int s,int e){
        if(s > e){
            return -1;
        }
        int mid=s+(e-s)/2;
        if(target==nums[mid]){
            return mid;
        }
        if(nums[s] <=nums[mid]){
            if(target >=nums[s] && target <= nums[mid]){
                return searchtar(nums,target,s,mid-1);
            }else{
                return searchtar(nums,target,mid+1,e);
            }
        }
        if(target >=nums[mid] && target <=nums[e]){
                return searchtar(nums,target,mid+1,e);
        }
        return searchtar(nums,target,s,mid-1);
    }
}
