package work1;
import work1.Line.Position;
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
    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank + "  \033[0m";
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
    public static LittleMonster getEachByRank(LittleMonster[] array,int rank){
        for(LittleMonster littleMonster:array){
            if(littleMonster.rank==rank){
                return littleMonster;
            }
        }
        return null;
    }

    }


