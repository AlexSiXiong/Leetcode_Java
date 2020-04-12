package Weekly.Contest_184;

public class d {
    private static double compute (int n) {
        double result = Math.pow(24, n) + 9 * Math.pow(8, n) + 18 * Math.pow(3, n) + 9 * Math.pow(2, n)- 24;

        return result;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(compute(n));

//        x x x
//        x x x
//        x x x
    }
}
