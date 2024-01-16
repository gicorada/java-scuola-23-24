package libro.cap12.altri.otto_regine;

public class OttoRegine {
    public static void risolvi(PartialSol sol) {
        int exam = sol.esamina();
        if(exam == PartialSol.ACCEPT) System.out.println(sol);
        else if(exam == PartialSol.CONTINUE) {
            for(PartialSol ps : sol.espandi()) {
                risolvi(ps);
            }
        }
    }

    public static void main(String[] args) {
        risolvi(new PartialSol(0));
    }
}
