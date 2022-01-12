import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class Oaleatorias {
    //Funtion
    private int Fmin = 2;
    private int Fmax = 2;
    //Dimensions 
    private int Dmin = 4;
    private int Dmax = 6;
    //Points
    private int Pmin = 2;
    private int Pmax = 40;
    //Arrive Time
    private int Tmin = 0;
    private int Tmax = 0;

    public Oaleatorias() {

    }

    public ArrayList<int[]> RTrabajos(int a) {
        Random rand = new Random();
        ArrayList<int[]> trabajos = new ArrayList<int[]>();
        for (int i = 0; i < a; i++){
            // {F,D,P,AT,ST,ET}
            int aux = rand.nextInt((Dmax - Dmin) + 1) + Dmin;
            if(aux == 4){
                int tmp[] = {2,4, rand.nextInt((40 - 24) + 1) + 24,0,-1,i};
                trabajos.add(tmp);
            }else{
                if(aux == 5){
                    int tmp[] = {2,5, rand.nextInt((40 - 20) + 1) + 20,0,-1,i};
                    trabajos.add(tmp);
                }else{
                    int tmp[] = {2,6, rand.nextInt((40 - 10) + 1) + 10,0,-1,i};
                    trabajos.add(tmp);
                }
            }   
        }
        return trabajos;
    }
}