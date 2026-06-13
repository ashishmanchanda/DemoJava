package multithreading;

class MoveZerosToEnd {

    static void movezerotoend(int a[]) {
        int n = a.length;

        int fzi = -1;
        for (int i = 0; i < n; i++) {

            if (a[i] != 0 && fzi == -1) {
                continue;
            }

            if (a[i] == 0 && fzi == -1) {
                fzi = i;
                continue;
            }

            if (a[i] != 0 && fzi != -1) {
                int nzi = i;
                int temp = a[nzi];
                a[nzi] = a[fzi];
                a[fzi] = temp;
                fzi++;
                continue;
            }

            if (a[i] == 0 && fzi != -1) {
                continue;
            }
        }
    }

    public static void main(String[] a) {
        int arr[] = {-5, 1, 0, 2, 0, 5, 0, 0, 3, 0, -2, -3};
        movezerotoend(arr);
        for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ,");
        }
    }
}

