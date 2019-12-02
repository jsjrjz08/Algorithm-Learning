class Tools {
    /**
     * 二分搜索
     * @param arr 待查有序数组
     * @param target 待查元素
     * @return target在数组中的下标
     */
    public static int binarySearch02(int[] arr,int target) {
        if(arr.length == 0) {
            return -1;
        }

        //在(-1...n)区间内查找target
        int l = -1;
        int r = arr.length;

        while(l < r) {//边界问题：如果l==r，那么，在(l...r)区间是没有元素的
            int mid = l + (r-l)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {//target在左侧 (l...r_new)
                r = mid;//边界问题：下标mid肯定不是目标位置，在(l...r_new)区间中不包含mid
            } else {//arr[mid] < target //target在右侧 (l_new...r)
                l = mid;//边界问题：下标mid肯定不是目标位置，在(l_new...r)区间中不包含mid
            }
        }
        return -1;
    }

    /**
     * 二分搜索
     * @param arr 待查有序数组
     * @param target 待查元素
     * @return target在数组中的下标
     */
    public static int binarySearch01(int[] arr,int target) {
        if(arr.length == 0) {
            return -1;
        }

        //在[l...r] 区间内查找target
        int l = 0;
        int r = arr.length-1;
        while(l <= r) {//边界问题：当l==r时，[l...r]区间只有一个元素，这也是有意义的
            int mid = l + (r-l)/2;
            if(arr[mid] == target) {
                return mid;

            } else if(arr[mid] > target) {//target在左侧
                r = mid - 1;//边界问题：下标mid肯定不是目标位置，不必在[l...r_new]区间考虑

            } else {//arr[mid] < target //target在右侧
                l = mid + 1;//边界问题：下标mid肯定不是目标位置，不必在[l_new...r]区间考虑

            }
        }
        return -1;
    }

    //冒泡排序
//    1. 从0位置开始，比较相邻两个数的大小，如果后面的数小于前面，则交换位置。
//    2. 遍历一遍下来，最后一个数为整个数组中的最大值。
//    3. 把最后一个数排除，继续比较剩下的数组。
//    4. 总共比较次数为N*N，时间复杂度为O（n²）。
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        printArray(arr);
    }

    //选择排序
//    1.遍历一遍，找到整个数组中最小的数，与位置0的数交换位置。
//    2.从1位置开始，继续遍历，找到最小的数，与1位置交换。以此类推。
//    3.同冒泡排序，复杂度为O（n²）。
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        printArray(arr);
    }

    //插入排序
//    1.从1位置开始，比较与前面数的大小，如果小于前面的数，则交换位置，直到不再小于停止。
//    2.接着从2位置开始，重复这个过程。直到最后位置为止。
//    3.时间复杂度取决于数组的排序情况，当数组基本有序时候，复杂度很低，接近O（n）。
//    当数组完全无序时，每个数都要经过多次移动，复杂度趋近于O（n²）。
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        printArray(arr);
    }

    //希尔排序
    //1. 过程类似于插入排序，算是插入排序的一种优化。
    //2. 首先，需要确定一个步长k，根据步长，把数组分为N/k部分，每一部分单独排序。
    //3. 把步长缩短，继续排序，直到步长为1。
    //4. 通过步长，减少了数组需要移动的次数，从而降低了复杂度。
    //5. 所以复杂度的高低完全取决于步长的好坏，是一种特别不稳定的算法，也是一种实现简单分析困难的算法。
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        printArray(arr);
    }

    //快速排序 -- 升序
//    快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
//    快速排序如果每次都选到最大值，或者最小值，就会产生最坏的情况，使复杂度达到O（n²）级别。但是可以通过随机选择partition值，从数学期望上避免这种情况的发生。所以可以默认其复杂度为O（N * lg N）。

//    1.从数列中挑出一个元素，称为 “基准”（pivot）；
//    2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
//    3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

//    1.随机选出一个partition值，把大于partition值的放在它右边，小于它的放在它左边。
//    2.从partition值的左右两边分割，调用自己，开始递归。
//    3.这里有一点优化，因为partition值在数组中可能不止一个，因此返回一个长度为2的数组，代表partition的左右边界，从边界两端进行递归，更加快速。
    public static void quickSort(int[] arr) {
        if ( arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if ( left >= right ) {
            return;
        }
        //随机产生partition值，防止出现最坏情况
        swap(arr, right, (int) (Math.random() * ( right - left + 1)  )+ left );
        //返回的数组p为partition的左右边界
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0]-1);
        quickSort(arr, p[1]+1, right);
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1, more = right;
        while ( left < more ) {
            if ( arr[left] < arr[right] ) {
                swap(arr, ++less, left++);
            } else if ( arr[left] > arr[right] ) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[] {less+1,more};
    }

    //归并排序
//    1.把长度为n的输入序列分成两个长度为n/2的子序列；
//    2.对这两个子序列分别采用归并排序；
//    3.将两个排序好的子序列合并成一个最终的排序序列。
    public static void mergeSort(int[] arr) {
        if ( arr == null || arr.length < 2 ) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1 ) ;
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    //堆排序
//    1.首先用数组构造一个大根堆。
//    2.把大根堆队顶和最后位置的元素交换位置，最后一个元素脱离大根堆，即数组长度减一。
//    3.队顶下沉，再次构造大根堆，重复这个过程，直至完全排序。
    public static void heapSort(int[] arr) {
        if ( arr == null || arr.length < 2 ) {
            return;
        }
        for ( int i = 1; i < arr.length; i++ ) {
            insertHeap(arr, i);
        }
        int r = arr.length - 1;
        while(r > 0 ) {
            swap(arr, 0, r);
            heapify(arr, 0, r--);
        }
        printArray(arr);
    }

    public static void insertHeap(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while ( left < size ) {
            int largest = left+1 < size && arr[left] < arr[left + 1] ? left+1 : left;
            if ( arr[index] > arr[largest] ) {
                return;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr,int i,int j) {
        if(i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //幂运算 --一次递归调用
    //时间复杂度 O(logn)
    //递归深度=logn,每次递归函数的时间复杂度为=O(1)，因此，这个方法的时间复杂度为O(logn)
    public static double pow(double x, int n) {
        int n0 = n>0 ? n : (-n);

        if(n0 == 0) {
            return 1.0;
        }

        double tmp = pow(x,n0/2);

        if(n0 % 2 != 0) {
            return n>0 ? x * tmp * tmp : 1/(x * tmp * tmp);
        }
        return n>0 ? tmp * tmp : 1/(tmp * tmp);

    }

    //判断是否为素数
    //算法的时间复杂度为O(sqrt(N)) N为num
    public static boolean isPrime(int num) {

        if(num < 0 || num == 0 || num == 1) {
            return false;
        }

        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //将整数转换成字符串
    //算法的时间复杂度为O(logN) N为num的位数
    public static String intToString(int num) {
        int numR = Math.abs(num);

        if(numR == 0) {
            return "0";
        }

        String s = "";
//        int i = 0;

        //O(logN) N为num的位数
        while (numR != 0) {
//            System.out.println(i+" "+s +" "+numR);
            s += (numR % 10);
            numR /= 10;
//            i++;
        }

        int len = s.length();
        String result = "";
        //O(logN) N为num的位数
        for(int k=len-1; k>=0; k--) {
            result += s.charAt(k);
        }
        return num < 0 ? "-"+result : result;
    }

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
            if(i != arr.length-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
