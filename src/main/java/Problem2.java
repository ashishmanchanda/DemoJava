public class Problem2 {
    static int result  = 0;
    static int maxDiff = Integer.MAX_VALUE;

    static int sqrt(int num, int mid,int prevMid) {
        System.out.println("left");
        if (mid <= 1 || mid >= num) {
            return result;
        }
        System.out.println("mid"+mid);
        if (Math.abs(mid * mid - num) < maxDiff) {
            maxDiff=Math.abs(mid * mid - num);
            result = mid;
        }
        if (mid * mid == num) {
            result=mid;
            return result;
        } else if (mid * mid < num) {
           result= sqrt(num, (mid + prevMid) / 2,mid);
        } else {
           result = sqrt(num, mid / 2,mid);
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 9;
        int mid = num / 2;
        int prevmid=num;
        System.out.println(sqrt(num, mid,prevmid));

    }
}
