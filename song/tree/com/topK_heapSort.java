package song.tree.com;

/*
* 题目：给定一个无序的整型数组arr 找出其中最小的k个数
* 思路：
* 1.建立一个k个元素的大根堆
* 2.遍历arr 当遍历到的元素大于大根堆的堆顶元素时，替换
* 3.继续调整为大根堆 这样不断调整，直到遍历结束
* 4.剩下的就是arr中最小的k个数
*
* ==============对堆的理解：=============================
*1.堆是一个满二叉树，所以可以用数组表示
* 2.某个结点的下标 i ：
*   父节点：i/2
*   左子树：2*i+1
*  右子树：2*i+2
* */
public class topK_heapSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        topK_heapSort aa = new topK_heapSort();
        int[] minKNumsByHeap = aa.getMinKNumsByHeap(a, 4);
        System.out.println(minKNumsByHeap);
        for (int res:minKNumsByHeap) {
            System.out.println(res);
        }

    }
    public int[] getMinKNumsByHeap(int[] arr, int k) {
        if(k < 1 || k > arr.length) {
            return arr;
        }
        //构建k个元素的大根堆
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            //insert一个一个插入建堆
            heapInsert(kHeap, arr[i], i);
        }
        //从k开始往后遍历 若果当前值比堆顶元素小 则交换 并重新调整堆为大根堆
        for (int i = k; i != arr.length; i++) {
            if(arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }
    //建堆 输入新建的堆 值 位置
    //所以新建堆 插入的时候也是在一遍调整
    public void heapInsert(int[] arr, int value, int index) {
        arr[index] = value; //1.先将遍历到的值插入空堆中
        while (index != 0) {  //如果是第一个插入的 不用调整，不是第一个插入的 调整
            int parent = (index-1)/2;  //2.找到当前值在堆中父节点的位置
            if(arr[parent] < arr[index]) { //判断当前值与父节点的值的大小
                swap(arr, parent, index);//3.如果子比父大 则交换父子
                index = parent;  //4.当前值变为父的位置 ，向上比较 直到堆顶
            } else {
                break;
            }
        }
    }
    //调整大根堆 关键所在 输入的是堆 检索位置（为0 表示从堆顶开始） 堆的大小
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;  //暂定最大值在堆顶
        while (left < heapSize) {  //left 还在堆内 继续操作 也就是说左子树存在
            if(arr[left] > arr[index]) { //判读左子树是否大于检索 堆顶
                largest = left;  //如果左子树大于其堆顶 则最大值更改为左子树
            }
            if(largest != index) {  //只要最大值的位置不是堆顶，就调整最大值的位置为堆顶
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;  //调整后将 index 任然在最大值的位置 向下调整
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    //交换k大根堆的连个节点
    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


}
