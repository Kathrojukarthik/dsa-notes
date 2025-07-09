Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.


//code
Approach: HashMap to store (target - num) while iterating

 code----->
       ...code 
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                     return new int[]{i,j};
                }
            }
        }
        return new int[] {};

Time: O(n)

Tricky: Not using the correct index when checking the map



Use Case: Searching for pairs with a given sum, stock buy/sell, data validation

 
