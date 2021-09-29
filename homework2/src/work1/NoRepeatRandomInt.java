package work1;
import java.util.Random;

//0-n随机生成且不重复
public class NoRepeatRandomInt {
    private  int n;
    private int[] existNum;
    public NoRepeatRandomInt(int n){
        this.n =n;
        this.existNum=new int[n];
    }
    private int maxIndex=-1;
    public int getNumber(){
        Random rand=new Random();
        while (true){
            int num=rand.nextInt(n);
            if(maxIndex==-1){
                existNum[0]=num;
                maxIndex+=1;
                return num;
            }
            else{
                int flag=0;
                for(int i=0;i<maxIndex+1;i++){
                    if(existNum[i]==num){
                        flag=1;
                        break;
                    }}
                if(flag==0){
                    maxIndex+=1;
                    existNum[maxIndex]=num;
                    return num;
                }

            }}}

}


