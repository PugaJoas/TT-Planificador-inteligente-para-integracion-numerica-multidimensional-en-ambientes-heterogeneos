import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

class Genetico {

    private ArrayList<ArrayList<double[]>> tiempos;
    private int diveces;
    private Random rand = new Random();
    private double localfitness = 0;
    private double localpromfitness = 0;
    private double esperanzavida = 0;
    private double esperado = 0;
    private double apunta = 0;
    private double[] makespan;
    private Ordenar sort = new Ordenar();
    private int[] notrabajos;
    private String[] tiempodives;
    private String llego = "";
   
    public Genetico(ArrayList<ArrayList<double[]>> tiempos) {
        this.tiempos = tiempos;
        this.diveces = tiempos.get(0).get(0).length - 1;
        this.makespan = new double[tiempos.get(0).get(0).length];
        this.sort = new Ordenar();
        this.tiempodives = new String[tiempos.get(0).get(0).length];
        this.notrabajos = new int[tiempos.get(0).get(0).length];
    }

    public double[] doOperation(int[] jobs,int poblacioninicial, int maxgeneraciones, double mutacion) {
        //System.out.println("-----------------------------Dato en genetico:"+Arrays.toString(jobs)+"-----------------------------");
        llego += Arrays.toString(jobs);
        //System.out.println("Makespan Global: "+Arrays.toString(makespan));
        ArrayList<double[]> poblacion = new ArrayList<double[]>();
        ArrayList<double[]> tmpd = tiempos.get(jobs[1] - 3);
        /* ----------------------Poblacion Inicial-------------------------- */
        for (int i = 0; i < poblacioninicial; i++) {
            double generacion[] = new double[jobs[2]+1];
            for (int j = 0; j < (jobs[2]-1); j++) {
                generacion[j] = rand.nextInt((diveces - 0) + 1) + 0;
            }
            generacion = calfitness(generacion,tmpd);
            poblacion.add(generacion);
        }
        /*------------------------------------Algoritmo Evolutivo-----------------------*/
        for (int i = 0; i < maxgeneraciones; i++) {
            ArrayList<double[]> nextgeneration;
            /* ------------------------------------Torneo binario-----------------------*/
            poblacion = torneobinario(poblacion);
            nextgeneration = (ArrayList<double[]>) poblacion.clone();
            /* ------------------------------------Torneo binario-----------------------*/
            for (int j = 0; j < poblacioninicial; j=j+2) {

                /*-----------------------------Cruza unidorme-------------------------*/
                int ln = poblacion.get(j).length;
                int d = 0;
                double hijo[] = new double[ln];
                double hija[] = new double[ln];
                double padre[] = poblacion.get(j);
                double madre[] = poblacion.get(j+1);
                for(int k=0; k<(ln-2);k++){
                    d = rand.nextInt((1 - 0) + 1) + 0;
                    hijo[k] = (d == 0) ? padre[k]: madre[k];
                    hija[k] = (d == 1) ? padre[k]: madre[k];
                }
                /*-----------------------------Cruza unidorme-------------------------*/
                hijo = calfitness(hijo,tmpd);
                hija = calfitness(hija,tmpd);
                /*-----------------------------Mutacion por porcentaje-------------------------*/
                /*Mutacion  0 entre 1 por cada gen mejor al porcentaje de mutacion*/
                hijo = mutar(hijo,(int)(mutacion*100));
                hija = mutar(hija,(int)(mutacion*100));
                hijo = calfitness(hijo,tmpd);
                hija = calfitness(hija,tmpd);
                nextgeneration.add(hijo);
                nextgeneration.add(hija);
            }
            //poblacioninicial++;
            //Collections.shuffle(nextgeneration);
            /*---------------------------------------------Ruleta/Seleccion sin reemplazo-------------------------------------*/
            Collections.shuffle(nextgeneration);
            nextgeneration = aptitud(nextgeneration);
            nextgeneration = sort.mejor(nextgeneration);
            double mejor[] = nextgeneration.get(0);
            Collections.shuffle(nextgeneration);
            poblacioninicial--;
            double r = 0;
            int cont = 0;
            while (nextgeneration.size() > poblacioninicial) {
                if(cont == nextgeneration.size()){
                    Collections.shuffle(nextgeneration);
                    cont=0;
                    r=0;
                }else{
                    double tmp[] = nextgeneration.get(cont);
                    r += tmp[tmp.length - 1];
                    if (r >= apunta) {
                        if (tmp[tmp.length - 2] > esperanzavida) {
                            nextgeneration.remove(tmp);
                            nextgeneration = aptitud(nextgeneration);
                            cont = 0;
                            r = 0;
                        }
                    }
                    cont ++;
                    Collections.shuffle(nextgeneration);
                }
                
            }
            /*---------------------------------------------Ruleta/Seleccion sin reemplazo-------------------------------------*/
            poblacion = (ArrayList<double[]>) nextgeneration.clone();
            poblacion.add(mejor);
            poblacion = sort.mejor(poblacion);
            poblacioninicial++;
            //Collections.shuffle(poblacion);
        }
        poblacion = sort.Tmin(poblacion);
        ActualizarMakespan(poblacion.get(0), tmpd,"J"+jobs[jobs.length-1]+"F"+jobs[0]+"D"+jobs[1]+"P");
        //System.out.println("Makespan Global actualizado: "+Arrays.toString(makespan));
        return poblacion.get(0);
    }



    public ArrayList<double[]> aptitud(ArrayList<double[]> generacion) {
        ArrayList<double[]> tmp = generacion;
        localfitness = 0;
        localpromfitness = 0;
        esperado = 0;
        apunta = 0;
        esperanzavida=0;

        for (double[] is : tmp) {
            localfitness += is[is.length - 2];
        }
        localpromfitness = localfitness / tmp.size();
        esperanzavida =  localpromfitness/2.0;
        /*-------------------------Valor esperado-------------------------*/
        for (double[] is : tmp) {
            is[is.length - 1] = is[is.length - 2] / localpromfitness;
            esperado += is[is.length - 1];
        }
        /*-------------------------Valor esperado-------------------------*/
        apunta = 0 + (esperado - 0) * rand.nextDouble();
        return tmp;
    }

    public double[] calfitness(double[] individuo,ArrayList<double[]> tiempos){
        double[] makespantemporal = new double[makespan.length];
        System.arraycopy(makespan, 0, makespantemporal, 0, makespan.length);
        int l = individuo.length-2;
        double[] time;
        for(int i=0; i < l; i++){
            time = tiempos.get(i);
            makespantemporal[(int)individuo[i]] += time[(int)individuo[i]];
        }
        Arrays.sort(makespantemporal);
        individuo[individuo.length-2] = makespantemporal[makespantemporal.length-1];
        return individuo;
    }
    
    public double[] mutar(double[] individuo, int porcentaje){
        int l = individuo.length-2;
        for(int i=0; i<l; i++){
            int aux = rand.nextInt((100 - 0) + 1) + 0;
            if( aux <= porcentaje)
                individuo[i] = rand.nextInt((diveces - 0) + 1) + 0;
        }
        return individuo;
    }

    public void ActualizarMakespan(double[] individuo,ArrayList<double[]> tiempos, String id){
        int l = individuo.length-2;
        double[] time;
        for(int i=0; i < l; i++){
            time = tiempos.get(i);
            notrabajos[(int)individuo[i]] +=1;
            tiempodives[(int)individuo[i]] += id+(i+2)+" TI "+makespan[(int)individuo[i]];
            makespan[(int)individuo[i]] += time[(int)individuo[i]];
            tiempodives[(int)individuo[i]] += " TF "+makespan[(int)individuo[i]]+"\n";
        }
    }

    public ArrayList<double[]> torneobinario(ArrayList<double[]> generacion){
        int l = generacion.size()-1;
        ArrayList<double[]> antecesortmp = new ArrayList<double[]>();
        ArrayList<double[]> antecesoratmp = new ArrayList<double[]>();
        ArrayList<double[]> generaciontmp = new ArrayList<double[]>();
        /*---------------------Primer torneo--------------------*/
        Collections.shuffle(generacion);
        for(int i=0; i< l;i=i+2){
            double[] antecesor = generacion.get(i);
            double[] antecesora = generacion.get(i+1);
            if(antecesor[antecesor.length-2] <= antecesora[antecesora.length-2])
                antecesortmp.add(antecesor);
            else
                antecesortmp.add(antecesora);
        }
        /*---------------------Segundo torneo--------------------*/
        Collections.shuffle(generacion);
        for(int i=0; i< l;i=i+2){
            double[] antecesor = generacion.get(i);
            double[] antecesora = generacion.get(i+1);
            if(antecesor[antecesor.length-2] <= antecesora[antecesora.length-2])
                antecesoratmp.add(antecesor);
            else
                antecesoratmp.add(antecesora);
        }
        /*----------------------Mejores parejas------------------*/
        int a = antecesortmp.size();
        for(int i=0; i< a;i++){
            generaciontmp.add(antecesortmp.get(i));
            generaciontmp.add(antecesoratmp.get(i));
        }
        return generaciontmp;
    }

    public String[] gettiempodives(){
        return tiempodives;
    }

    public int[] getnotrabajos(){
        return notrabajos;
    }

    public double[] getmakespan(){
        return makespan;
    }

    public String getllego(){
        return llego;
    }
}