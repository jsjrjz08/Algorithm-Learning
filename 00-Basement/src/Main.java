public class Main {
    public static void main(String[] args) {
        System.out.println(Tools.intToString(38294));
        System.out.println(Tools.intToString(-38294));

        System.out.println(Tools.intToString(0));
        System.out.println(Tools.intToString(-0));

        System.out.println(Tools.intToString(638294));
        System.out.println(Tools.intToString(-638294));

        System.out.println(Tools.isPrime(-3));
        System.out.println(Tools.isPrime(0));
        System.out.println(Tools.isPrime(2));
        System.out.println(Tools.isPrime(3));
        System.out.println("9:"+Tools.isPrime(9));
        System.out.println(Tools.isPrime(13));
        System.out.println(Tools.isPrime(14));

        System.out.println(Tools.pow(2,3));
        System.out.println(Tools.pow(2,-3));

        System.out.println(Tools.binarySearch01(GenerateArrayUtil.generateOrderedArray(30),4));
        System.out.println(Tools.binarySearch02(GenerateArrayUtil.generateOrderedArray(30),4));
    }
}
