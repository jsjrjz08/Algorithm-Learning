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

    //选择排序

    //归并排序

    //快速排序 -- 升序
    public static void quickSort(int[] arr) {
        int len = arr.length;
        if(len == 0 || len == 1) {
            return;
        }

        int left = 0;//数组下标左边界
        int right = len - 1;//数组下标右边界
        //标的点，初始化为最左侧元素
        int pivot = arr[left];
        //(left,k]区间为小于等于pivot的元素下标。初始化为left，此时，(left,k]区间没有任何元素
        int k = left;

        for(int i=left+1;i<=right;i++) {
            if(arr[i] <= pivot) {
                k++;
                swap(arr,k,i);
            }
            //(k,i)之间是大于pivot的元素
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
}
