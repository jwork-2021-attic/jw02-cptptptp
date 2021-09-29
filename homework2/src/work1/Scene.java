package work1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Scene {
     public static void main(String[] args)throws IOException{
         Line line=new Line(256);
         LittleMonster[] array=new LittleMonster[256];
         for(int i=0;i<256;i++){
             array[i]=new LittleMonster(i);
         }
         NoRepeatRandomInt rand=new NoRepeatRandomInt(256);
         for(LittleMonster i:array){
              line.put(i,rand.getNumber());
         }
         Snake theSnake = Snake.getTheSnake();
         int i=new java.util.Random().nextBoolean()?0:1;
         Sorter sorter;
         if(i==1){
              sorter = new QuickSorter();
         }
         else {
              sorter = new HeapSorter();
         }
         theSnake.setSorter(sorter);
         String log = theSnake.lineUp(line,array);
         BufferedWriter writer;
         writer = new BufferedWriter(new FileWriter("result.txt"));
         writer.write(log);
         writer.flush();
         writer.close();

     }

}



