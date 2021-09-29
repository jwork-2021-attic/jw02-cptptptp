package work2;

public class QuickSorter implements Sorter {
    private int[]a;
    public  void load(int[][] b){
        a=new int[b.length* b.length];
        int sumNum=0;
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                this.a[sumNum]=b[i][j];
                sumNum+=1;
    }}}
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
        if(left<right) {
            int base = a[left];
            int i = left, j = right;
            while (i != j) {
                while (j > i && a[j] >= base) {
                    j--;
                }
                while (i < j && a[i] <= base) {
                    i++;
                }
                if (i < j) {
                    swap(i, j);
                }
            }
            swap(left,j);
            sort(left, j - 1);
            sort(j + 1, right);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}