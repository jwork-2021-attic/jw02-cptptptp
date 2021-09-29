package work2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
     public static void main(String[] args)throws IOException{
         Matrix matrix=new Matrix(16,16);
         LittleMonster[][] matrixMonster=new LittleMonster[16][16];
         int eachRank=0;
         for(int i=0;i<16;i++){
             for(int j=0;j<16;j++){
             matrixMonster[i][j]=new LittleMonster(eachRank);
             eachRank+=1;
         }}
         NoRepeatRandomInt rand=new NoRepeatRandomInt(256);
         for(int i=0;i<16;i++){
             for(int j=0;j<16;j++){
                 int k=rand.getNumber();
                 matrix.put(matrixMonster[i][j],k/16,k%16);
         }}
         Snake theSnake = Snake.getTheSnake();
         int whatSorter=new java.util.Random().nextBoolean()?0:1;
         Sorter sorter;
         if(whatSorter==1){
              sorter = new QuickSorter();
         }
         else {
              sorter = new HeapSorter();
         }
         theSnake.setSorter(sorter);
         String log = theSnake.matrixUp(matrix,matrixMonster);
         BufferedWriter writer;
         writer = new BufferedWriter(new FileWriter("result.txt"));
         writer.write(log);
         writer.flush();
         writer.close();

     }

}



