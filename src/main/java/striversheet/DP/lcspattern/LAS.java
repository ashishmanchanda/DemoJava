package striversheet.DP.lcspattern;
//
//class LAS {
//    public int findLASLength(int [] nums) {
/// we have to start with two recursive calls, one where we will consider tha
//// bigger than the second element and one where the first element is smaller
//        return Math.max(findLASLengthRecursive (nums, -1, 0, true),
//                findLASLengthRecursive (nums, -1, 0, false));
//    }
//    private in findLASLengthRecursive (int [l nums, int previousIndex, int currentI
//if(currentIndex == nums. length)
//return 0;
//    int c1=0;
/// if ascending, the next element should be bigger
//if isAsc) {
//        if(previousIndex == -1 || nums [previousIndex] < nums [currentIndex])
//            c1 = 1 + this. findLASLengthRecursive (nums, currentIndex, currentIndex+1,
//    } else { / if descending, the next element should be smaller
//        if(previousIndex == -1 || nums [previousIndex] > nums [currentIndex])
//            c1 = 1 + this. findLASLengthRecursive (nums, currentIndex, currentIndex+1,!
//    }
//    // skip the current element
//    int c2 = this.findLASLengthRecursive (nums, previousIndex, currentIndex+1, is/
//return Math. max (c1, c2);
//}
//public static void main (String[] args) {
//    LAS las = new LAS();
//    int [l nums = <1,2,3,4};
//System.out.println(las.findLASLength (nums));
//nums = new int [] {3,2,1,4};
//        System.out.println(las.findLASLength (nums));
//nums = new intlit1,3,2,4s;
//System.out.println(las.findLASLength (nums));
//        }
//        }
