import java.util.*;

class Library {
    static Set<List<Integer>> result = new HashSet<>();
    static HashSet<Integer> hash=new HashSet<>();

    static Set<List<Integer>> countNumerOfSubSetsUtil(int[] arr,int start,int end,List<Integer> elements,int hashcode){
        if (start == arr.length) {
            List<Integer> temp = new ArrayList<>(elements);
                result.add(temp);

            return result;
        }
        elements.add(arr[start]);
        hashcode+=arr[start];
        countNumerOfSubSetsUtil(arr, start + 1, end, elements,hashcode);
        elements.remove(elements.size() - 1);
        hashcode-=arr[start];
        countNumerOfSubSetsUtil(arr, start + 1, end, elements,hashcode);
        return result;

    }

    static Set<List<Integer>> countNumberOfSubsets(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        List<Integer> elements = new ArrayList<>();
        int hashcode=0;
        return countNumerOfSubSetsUtil(arr, start, end, elements,hashcode);
    }

    public static void main(String[] args) {
        int[] a = { 1,2,3,4,5,7,9,10};
        Set<List<Integer>> subSets = countNumberOfSubsets(a);
        System.out.println(subSets);
    }
}


