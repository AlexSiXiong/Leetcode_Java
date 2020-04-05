public class Test2 {
    public static int numSteps(String s) {
        if (s.equals("1")) {
            return 0;
        }
        long real_number = Long.parseLong("278675673186014720");//convert(s);

        int times = 0;
        while(true) {
            if (real_number % 2 != 0) {
                real_number += 1;
                times++;
            }
            if (real_number == 2) {
                times++;
                break;
            }
            real_number = real_number / 2;
            times++;


        }
        return times;
    }

    private static int convert(String s) {
        return Integer.parseInt(s,2);
    }

    private static boolean judge(int num) {
        return num % 2 == 0;
    }

    String radix = "1010";
    public static int method(String radix){
        int x = 0;
        for(char c:radix.toCharArray())
            x = x*2 + (c=='1'?1:0);
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
//        System.out.println(convert("10"));
//        System.out.println(judge(1));
//        System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
//        Long a = Long.parseLong("278675673186014720");

//        long real_number = Long.parseLong("1111011110000011100000110001011011110010111001010111110001");
//        System.out.println(real_number);

        method("1111011110000011100000110001011011110010111001010111110001");



    }


}
