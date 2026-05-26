package striversheet.DP.lcspattern;

class EditDistance {
    public int findMinOperations (String s1, String s2) {
        return findMinOperationsRecursive (s1, s2, 0, 0);
    }
    private int findMinOperationsRecursive (String s1, String s2, int i1, int i2) {
// if we have reached the end of s1, then we have to insert all the remainin.
        if (i1 == s1. length ())
            return s2.length() - i2;
// if we have reached the end of s2, then we have to delete all the remainin.
        if (i2 == s2. length ())
            return s1.length() - i1;
// If the strings have a matching character, we can recursively match for the
        if(s1.charAt (i1) == s2.charAt ( i2))
            return findMinOperationsRecursive (s1, s2, i1+1, i2+1);
        int c1 = 1 + findMinOperationsRecursive (s1, s2, i1+1, i2); //perform deletio
        int c2 = 1 + findMinOperationsRecursive (s1, s2, i1, i2+1); //perform inserti
        int c3 = 1 + findMinOperationsRecursive (s1, s2, i1+1, i2+1); // perform repli
        return Math.min(c1, Math.min (c2, c3));
    }
    public static void main(String [] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(editDisatnce.findMinOperations("bat","but"));
        System.out.println(editDisatnce.findMinOperations("abdca","cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot","ppsspart"));
    }
}