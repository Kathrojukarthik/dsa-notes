 public static void main(String[] args) {
4	      int[] nums={5,4,3,2,1};
5	      sort( nums,0,nums.length-1);
6	      System.out.print(Arrays.toString(nums));
7	      
8	   }
9	   static void sort(int[] nums,int low ,int high){
10	    if( low >= high){
11	      return;
12	      }
13	      int s=low;
14	      int e=high;
15	      int m=s+(e-s)/2;
16	      int pivot=nums[m];
17	      while( s<= e){
18	      
19	         while( nums[s] < pivot){
20	         s++;
21	         }
22	         
23	         while( nums[e] > pivot){
24	         e--;
25	         }
26	         if(s <= e){
27	         int temp=nums[s];
28	            nums[s]=nums[e];
29	            nums[e]=temp;
30	            s++;
31	            e--;
32	         }
33	      }
34	      sort(nums,low,e);
35	      sort(nums,s,high);
