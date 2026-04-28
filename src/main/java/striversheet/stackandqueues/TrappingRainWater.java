package striversheet.stackandqueues;

public class TrappingRainWater {

    int taprainwater(int[] h){
        int result=0;
        int left=0;
        int right=h.length-1;
        int maxleft=0;
        int maxright=0;
        while(left<=right){
            if(h[left]<h[right]){
                if(h[left]>=maxleft){
                    maxleft=h[left];
                }else {
                    result += maxleft - h[left];
                }
                left++;
            }else{
                if(h[right]>=maxright){
                    maxright=h[right];
                }else {
                    result += maxright - h[right];
                }
                right--;
            }
        }


        return result;
    }

    public static void main(String[] args){
        int[] height = {3,0,2,0,4};
        TrappingRainWater r = new TrappingRainWater();
        int result=r.taprainwater(height);
        System.out.println(result);
    }
}
