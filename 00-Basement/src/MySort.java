public class MySort {
    public static void main(String[] args) {
//        Math.random();
        bubbleSort(GenerateArrayUtil.generateRandomArray(7,20));
        selectionSort(GenerateArrayUtil.generateRandomArray(7,20));
        insertionSort(GenerateArrayUtil.generateRandomArray(7,20));
        mergeSort(GenerateArrayUtil.generateRandomArray(7,20));
        heapSort(GenerateArrayUtil.generateRandomArray(7,20));
        quickSort(GenerateArrayUtil.generateRandomArray(7,20));

    }

    //快速排序
    //O(nlogn)
    private static void quickSort(int[] arr) {
        String desc = "快速排序";
        GenerateArrayUtil.printArray(arr,desc,true);
        if(arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr,0,arr.length-1);
        GenerateArrayUtil.printArray(arr,desc,false);
    }

    //递归函数：在arr数组区间[low...high]中进行快速排序
    //O(nlogn)
    private static void quickSort(int[] arr,int low,int high) {
        //结束条件
        if(low >= high) {
            return;
        }

        //返回标的点位置
        int mid = getMiddle(arr,low,high);
        quickSort(arr,low,mid);
        quickSort(arr,mid+1,high);
    }

    //在arr数组区间[low...high]中找到第一个元素在排序后的位置
    //O(n)
    private static int getMiddle(int[] arr,int low,int high) {
        int pivot = arr[low];

        while(low<high) {
            while(low<high && arr[high]>=pivot) {
                high--;
            }
            arr[low] = arr[high];
            while(low<high && arr[low]<=pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    //O(nlogn)
    //堆排序
    //升序-构建大顶堆
    private static void heapSort(int[] arr) {
        String desc = "堆排序";
        GenerateArrayUtil.printArray(arr,desc,true);
        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;

        //将数组处理成堆
        //O(logn)
        for(int i=(n-2)/2; i>=0; i--) {
            siftDown(arr,n,i);
        }

        //O(n)
        for(int size=n-1;size>0;size--) {
            GenerateArrayUtil.swap(arr,0,size);
            siftDown(arr,size-1,0);
        }

        GenerateArrayUtil.printArray(arr,desc,false);
    }

    //O(logn)
    //在arr数组[0...size-1]区间内的元素组成的树中，将index对应元素下沉
    private static void siftDown(int[] arr,int size,int index) {
        int left = 2*index +1;
        while(left < size) {

            int maxIdx = left;
            if(left+1 < size && arr[left] < arr[left+1]) {
                maxIdx = left+1;
            }

            if(arr[index] < arr[maxIdx]) {
                GenerateArrayUtil.swap(arr,index,maxIdx);
                index = maxIdx;
                left = 2*index +1;
            } else {
                break;
            }
        }
    }

    //O(nlogn)
    private static void mergeSort(int[] arr) {
        String desc = "合并";
        GenerateArrayUtil.printArray(arr,desc,true);
        if(arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr,0,arr.length-1);

        GenerateArrayUtil.printArray(arr,desc,false);
    }

    //递归函数：将arr数组[l...r]区间的元素进行排序
    //o(nlogn)
    private static void mergeSort(int[] arr,int l,int r) {
        //结束条件---------------------很重要！否则栈溢出!!!!!!!!
        if(l == r) {//只有一个元素
           return;
        }
        int mid = l+(r-l)/2;
        mergeSort(arr,l,mid);//前半部分排序
        mergeSort(arr,mid+1,r);//后半部分排序
        merge(arr,l,mid,r);//合并两部分，整体排序
    }

    //O(n)
    private static void merge(int[] arr,int l,int mid,int r) {
        int i = 0;
        int[] result = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;

        //维护指针偏移！！！！！！
        while(p1<=mid && p2<=r) {//长度相同的部分，比较合并
            result[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1<=mid) {//剩余部分直接追加
            result[i++] = arr[p1++];
        }
        while(p2<=r) {//剩余部分直接追加
            result[i++] = arr[p2++];
        }

        for(i=0; i<result.length; i++) {
            arr[l+i] = result[i];
        }
    }

    //O(n^2)
    //通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
    private static void insertionSort(int[] arr) {
        String desc = "插入";
        GenerateArrayUtil.printArray(arr,desc,true);

        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(arr[j] > arr[j+1]) {
                    GenerateArrayUtil.swap(arr, j, j+1);
                }
            }
        }

        GenerateArrayUtil.printArray(arr,desc,false);

    }

    //O(n^2)
    private static void selectionSort(int[] arr) {
        String desc = "选择";
        GenerateArrayUtil.printArray(arr,desc,true);

        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;

        //选择次数
        for(int i=0; i<n-1; i++) {
            int minIdx = i;
            //每次在剩余部分选取最小值的下标
            for(int j=i+1; j<n; j++) {//------------注意：j每次都要比较到末尾n-1的位置！！！
                minIdx = arr[j]<arr[minIdx] ? j : minIdx;
            }
            //更新最小值
            GenerateArrayUtil.swap(arr,minIdx,i);
        }

        GenerateArrayUtil.printArray(arr,desc,false);
    }

    //O(n^2)
    private static void bubbleSort(int[] arr) {
        String desc = "冒泡";
        GenerateArrayUtil.printArray(arr,desc,true);
        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        //趟数
        for(int i=0; i<n-1; i++) {
            //每趟内进行比较
            for(int j=0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    GenerateArrayUtil.swap(arr,j,j+1);
                }
            }
        }
        GenerateArrayUtil.printArray(arr,desc,false);
    }



}
