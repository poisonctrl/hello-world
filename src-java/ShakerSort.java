package assignmentone;


public class ShakerSort {
    public static void ShakerSort(int[] a) {
        for (int p = 1; p <= a.length / 2; p++) {
            // phase p of Shaker sort
            // first do left-to-right bubbling pass
            for (int i = p - 1; i < a.length - p; i++)
                if (a[i] < (a[i+1]))
                myswap(a, i, i + 1);
                // now do right-to-left bubbling pass
                for (int i = a.length - p - 1; i >= p; i--)
                if (a[i] < (a[i-1]) && a[i-1] < 0)
                myswap(a, i, i - 1);
            }
        }
    public static int[] myswap (int[] a, int i, int ii) {
        int temp = a[i];
        a[i] = a[ii];
        a[ii] = temp;
        return a;
        
    }
}


