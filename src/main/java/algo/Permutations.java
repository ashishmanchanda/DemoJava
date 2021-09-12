package algo;

/**

 *     Input, A string ABC -> print all the permutations of this String
 * ABC, ACB, BAC, BCA, CAB, CBA
 */






public class Permutations {

    static char[] swap(char[] array,int i,int j){
        char temp;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        return array;
    }

    static char[] printArray(char[] array){
        for (int k=0;k<array.length;k++){
            System.out.print(array[k]);
        }
        System.out.println();
        return array;
    }

    static void printPermutations(char[] array,int start,int end) {
        int i = start;
        if (start == end){
            printArray(array);
        }
            for (int j = start ; j <= end; j++) {
                array = swap(array, start, j);
                printPermutations(array, start+1, end);
                array = swap(array, start, j);
            }


    }
    public static void main(String[] args) {

        String s ="abcdef";
        int start=0;
        int end=s.length()-1;
        char[] array=s.toCharArray();
        printPermutations(array,start,end);

    }
}

/*abc
  b  a   c
   start
  b  c  a
        start
        */


