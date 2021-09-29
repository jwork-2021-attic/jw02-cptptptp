package work1;

public class HeapSorter implements Sorter{
    private int[] a;
    @Override
    public void load(int[] a) {
        this.a = a;
    }
    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }
    private String plan = "";
    @Override
    public void sort(int left,int right) {
        heap();
        int size = a.length;
        while (size > 1) {
            swap(0, size - 1);
            size--;
            beHeap( 0, size);
        }
    }
    public void heap() {
        for (int i = 0; i < a.length; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;//父结点索引
            while (a[currentIndex] > a[fatherIndex]) {
                swap(currentIndex,fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }
    public  void beHeap( int index, int size) {
        int left = 2 * index + 1;//第一个子
        int right = 2 * index + 2;//第二个子
        while (left < size) {
            int largestIndex;
            if (a[left] < a[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;//判断哪个儿子大
            }
            if (a[index] > a[largestIndex]) {
                largestIndex = index;
            }
            if (index == largestIndex) {
                break;
            }
            swap(largestIndex, index);
            index = largestIndex;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }


    @Override
    public String getPlan() {
        return this.plan;
    }




}
