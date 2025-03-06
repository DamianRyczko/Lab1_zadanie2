
public class zadanie_2 {

    public static long overflowValidatedMultiplyLong(long a, long b) {
        if (a > 0 && b > 0 && a > Long.MAX_VALUE / b) {
            return Long.MAX_VALUE;
        } else if (a > 0 && b < 0 && b < Long.MIN_VALUE / a) {
            return Long.MAX_VALUE;
        } else if (a < 0 && b > 0 && a < Long.MIN_VALUE / b) {
            return Long.MAX_VALUE;
        } else if (a < 0 && b < 0 && a < Long.MAX_VALUE / b) {
            return Long.MAX_VALUE;
        }
        return a * b;
    }

    public static boolean longOverflow(long sum, long addedValue) {
        if (addedValue > 0 && sum > Long.MAX_VALUE - addedValue) {
            return true;
        } else if (addedValue < 0 && sum < Long.MIN_VALUE - addedValue) {
            return true;
        }
        return false;
    }
    private static void kolejna(long ni) {
        long n = 0;
        while(n<1000) {
            n++;
            long next = 0;
            if (ni % 2 == 0) {
                next = ni / 2;
                System.out.println(ni + ", parzysta, " + next);
            } else {
                long multiplication = overflowValidatedMultiplyLong(ni,3);
                if(multiplication == Long.MAX_VALUE){
                    System.out.println("Overflow detected");
                    break;
                }
                if (longOverflow(multiplication, 1)) {
                    System.out.println("Overflow detected");
                    break;
                }
                next = multiplication + 1;
                System.out.println(ni + ", nieparzysta, " + next);
            }
            if (next == 1) {
                break;

            }
            ni = next;

        }

    }
    private static boolean isInteger(String s) {

        return s.matches("-?\\d+"); // regex check
    }

    public static void main(String[] args) {
        long ni = 0;
        if (args.length == 0) {
            System.out.println("Missing argument n:");
        } else {
            if (args.length == 1) {
                String arg = args[0];
                if (isInteger(arg)) {
                    ni = Long.parseLong(arg);
                    if(ni>=0){
                        kolejna(ni);
                    }
                    else{
                        System.out.println("Invalid integer format");
                    }
                } else {
                    System.out.println("Invalid integer format");
                }
            } else {
                System.out.println("Too many arguments");
            }
        }
    }

}