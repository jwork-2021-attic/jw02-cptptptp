package work2;
import work2.Matrix.Position;

public class LittleMonster implements Linable {
    private int r;
    private int g;
    private int b;
    private int rank;
    private Position position;
    LittleMonster(int rank){
        this.rank=rank;
        int n=this.rank/49;
        int re=this.rank%49;
        switch(n){
            case 0:{r=5*re;g=0;b=0;break;}
            case 1:{r=255;g=5*re;b=0;break;}
            case 2:{r=255-5*re;g=255;b=0;break;}
            case 3:{r=0;g=255;b=5*re;break;}
            case 4:{r=0;g=255-5*re;b=255;break;}
            case 5:{r=5*re;g=0;b=255;break;}
        }

    }
    public String repeat(String s,int n){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            res.append(s);
        }
return res.toString();
    }    @Override
    public String toString() {
        int n=String.valueOf(this.rank).length();
        String s=repeat("0",3-n)+String.valueOf(this.rank);
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " +s+"  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(LittleMonster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank;
    }
    public static LittleMonster getEachByRank(LittleMonster[][] matrixMonster,int rank){
        for(int i=0;i<matrixMonster.length;i++){
            for(int j=0;j<matrixMonster[0].length;j++) {
                if (matrixMonster[i][j].rank == rank) {
                    return matrixMonster[i][j];
                }
            }
            }
        return null;
    }

    }


