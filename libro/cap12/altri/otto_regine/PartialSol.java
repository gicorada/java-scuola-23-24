package libro.cap12.altri.otto_regine;

import java.util.Arrays;

public class PartialSol {
    private Queen[] queens;

    public static final int ACCEPT = 1;
    public static final int ABANDON = 2;
    public static final int CONTINUE = 3;


    public PartialSol(int size) {
        queens = new Queen[size];
    }

    public int esamina() {
        for(int i=0; i<queens.length; i++) {
            for(int j=i+1; j<queens.length; j++) {
                if(queens[i].attacca(queens[j])) return ABANDON;
            }
        }
        if(queens.length == 8) return ACCEPT;
        else return CONTINUE;
    }


    public PartialSol[] espandi() {
        PartialSol[] res = new PartialSol[8];
        for(int i=0; i<8; i++) {
            res[i] = new PartialSol(queens.length+1);
            for(int j=0; j<queens.length; j++) {
                res[i].queens[j] = queens[j];
            }
            res[i].queens[queens.length] = new Queen(queens.length, i);
        }
        return res;
    }

    public String toString() {
        return Arrays.toString(queens);
    }
}
