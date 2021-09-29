package work1;

public class QuickSorter implements Sorter{
    private int[]a;
    public  void load(int[ ]a){
        this.a=a;
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
    public static void main(String[]args){
        QuickSorter w=new QuickSorter();
        NoRepeatRandomInt rand=new NoRepeatRandomInt(256);
        int[]s=new int[256];
        for(int i=0;i<256;i++){
            s[i]=rand.getNumber();
        }
        w.load(s);
        w.sort(0,s.length-1);
        for(int i=0;i<s.length;i++){
            System.out.println(w.a[i]);
        }}
    @Override
    public String getPlan() {
        return this.plan;
    }

}