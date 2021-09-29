package work2;

public class Snake {
    public static Snake theSnake;
    public static Snake getTheSnake(){
        if(theSnake==null){
            theSnake=new Snake();
        }
        return  theSnake;
    }
    private Sorter sorter;
    public void setSorter(Sorter sorter){
        this.sorter=sorter;
    }
    public String matrixUp(Matrix matrix, LittleMonster[][] matrixMonster) {
        String log = "";
        if (sorter == null) {
            return null;
        }
        Linable[][] linables = matrix.toMatrix();
        int[][] ranks = new int[linables.length][linables[0].length];
        for (int i = 0; i < linables.length; i++) {
            for(int j=0;j<linables[0].length;j++) {
                ranks[i][j] = linables[i][j].getValue();
            }
        }
        sorter.load(ranks);
        sorter.sort(0,ranks.length*ranks[0].length-1);
        System.out.println(sorter.getPlan());
        String[] sortSteps = this.parsePlan(sorter.getPlan());
        for (String step : sortSteps) {
            this.execute(step,matrixMonster);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }
        return log;
    }
    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }
    private void execute(String step, LittleMonster[][] matrixMonster) {
        String[] couple = step.split("<->");
       LittleMonster.getEachByRank(matrixMonster,Integer.parseInt(couple[0])).swapPosition(LittleMonster.getEachByRank(matrixMonster,Integer.parseInt(couple[1])));


    }

}

