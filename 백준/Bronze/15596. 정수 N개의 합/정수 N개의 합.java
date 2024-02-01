public class Test {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += (long) a[i];
        }
        return ans;
    }
}
