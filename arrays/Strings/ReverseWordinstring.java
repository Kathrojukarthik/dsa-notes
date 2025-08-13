char[] arr=s.toCharArray();

        int l=0;
        for(int r=0;r<arr.length;r++){
            if(arr[r]==' '){
                reverse(arr,l,r-1);
                l=r+1;
            }else if(r==arr.length-1){
                reverse(arr,l,r);
            }
        }
        String str=new String(arr);
        return str;
    }
    static char[] reverse(char[] arr,int l,int r){
        while(l<r){
            char temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            l++;
            r--;
        }
        return arr;
    }
