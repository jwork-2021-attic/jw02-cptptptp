package work2;

public class Matrix {
    private Position[][] positions;
    public Matrix(int rowNum,int colNum){this.positions=new Position[rowNum][colNum];
    }
    public void put(Linable linable, int rowNum,int colNum) {
        if (this.positions[rowNum][colNum] == null) {
            this.positions[rowNum][colNum] = new Position(null);
        }
        this.positions[rowNum][colNum].setLinable(linable);
    }
    public Linable get(int rawNum,int colNum) {
        if ((rawNum < 0) ||(colNum<0)|| (rawNum> positions.length)||(colNum>positions[0].length)) {
            return null;
        } else {
            return positions[rawNum][colNum].linable;
        }
    }
    class Position{
        private Linable linable;
        Position(Linable linable){
            this.linable=linable;
        }
        public void setLinable(Linable linable){
            this.linable=linable;
            linable.setPosition(this);
        }
    }
    @Override
    public String toString(){
        String lineString = "";
        for(int i=0;i<positions.length;i++){
            for(int j=0;j<positions[0].length;j++){
                lineString+=positions[i][j].linable.toString();
            }
            lineString+="\n";
        }
        return lineString;
    }
    public Linable[][] toMatrix(){
        Linable[][] linables=new Linable[this.positions.length][this.positions[0].length];
        for(int i=0;i<positions.length;i++){
            for(int j=0;j<positions[0].length;j++){
               linables[i][j]=positions[i][j].linable;
            }
        }
        return linables;
    }
}
