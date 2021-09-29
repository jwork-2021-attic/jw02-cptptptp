package work1;

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
    public String lineUp(Line line,LittleMonster[] array) {
        String log = "";
        if (sorter == null) {
            return null;
        }
        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];
        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }
        sorter.load(ranks);
        sorter.sort(0, ranks.length-1);
        System.out.println(sorter.getPlan());
        String[] sortSteps = this.parsePlan(sorter.getPlan());
        for (String step : sortSteps) {
            this.execute(step,array);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }
        return log;
    }
    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }
    private void execute(String step,LittleMonster[] array) {
        String[] couple = step.split("<->");
       LittleMonster.getEachByRank(array,Integer.parseInt(couple[0])).swapPosition(LittleMonster.getEachByRank(array,Integer.parseInt(couple[1])));


    }

}

