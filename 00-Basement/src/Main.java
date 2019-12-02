public class Main {
    public static void main(String[] args) {
//        System.out.println(Tools.intToString(38294));
//        System.out.println(Tools.intToString(-38294));
//
//        System.out.println(Tools.intToString(0));
//        System.out.println(Tools.intToString(-0));
//
//        System.out.println(Tools.intToString(638294));
//        System.out.println(Tools.intToString(-638294));
//
//        System.out.println(Tools.isPrime(-3));
//        System.out.println(Tools.isPrime(0));
//        System.out.println(Tools.isPrime(2));
//        System.out.println(Tools.isPrime(3));
//        System.out.println("9:"+Tools.isPrime(9));
//        System.out.println(Tools.isPrime(13));
//        System.out.println(Tools.isPrime(14));
//
//        System.out.println(Tools.pow(2,3));
//        System.out.println(Tools.pow(2,-3));
//
//        System.out.println(Tools.binarySearch01(GenerateArrayUtil.generateOrderedArray(30),4));
//        System.out.println(Tools.binarySearch02(GenerateArrayUtil.generateOrderedArray(30),4));

//        int[] arr = {6,9,7,8,6,10,3};
        System.out.print("冒泡排序：");
        Tools.bubbleSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("选择排序：");
        Tools.selectionSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("插入排序：");
        Tools.insertionSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("希尔排序：");
        Tools.shellSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("快速排序：");
        Tools.quickSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("归并排序：");
        Tools.mergeSort(new int[]{6,9,7,8,6,10,3});
        System.out.print("堆排序：");
        Tools.heapSort(new int[]{6,9,7,8,6,10,3});
    }

}
