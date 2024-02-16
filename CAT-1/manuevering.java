public class manuevering {
    public static void main(String[] args) {
        System.out.println(numberOfpaths(3, 3));
    }

    static int numberOfpaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return numberOfpaths(m - 1, n) + numberOfpaths(m, n - 1);
    }
}
