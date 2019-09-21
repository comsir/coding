package Hot;
//归并排序
//https://www.cnblogs.com/of-fanruice/p/7678801.html
public class guibingSort {
    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int[] res = sort(arr, 0, arr.length - 1);
        for (int i:res) {
            System.out.print(i + " ");
        }
    }
    private static int[] sort(int[] a, int low, int high) {
        int mid = (low + high)/2;
        if(low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //归并
            merge(a, low, mid, high);
        }
        return a;
    }
    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        //把较小的数移到新数组中
        while (i<=mid && j<=high) {
            if(a[i]< a[j]) {
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        //把左边剩下的移入数组中
        while (i<=mid) {
            tmp[k++] = a[i++];
        }
        //把右边剩下的移入数组中
        while (j<=high) {
            tmp[k++] = a[j++];
        }
        //把新数组的数覆盖nums数组
        for (int l = 0; l < tmp.length; l++) {
            a[l+low] = tmp[l];
        }

    }
}
