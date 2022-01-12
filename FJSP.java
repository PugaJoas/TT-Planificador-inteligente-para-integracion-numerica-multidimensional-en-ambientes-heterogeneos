import java.util.ArrayList;
import java.util.Arrays;
class FJSP {
    public static void main(String[] args) {
        ArrayList<ArrayList<double[]>> DiviceTime = new ArrayList<ArrayList<double[]>>();
        ArrayList<int[]> jobs = new ArrayList<int[]>();
        ArrayList<int[]> jobs2;
        String files[] = { "F2_3D.csv", "F2_4D.csv", "F2_5D.csv", "F2_6D.csv" };
        Oaleatorias rdjobs = new Oaleatorias();
        LecturaDatos datos = new LecturaDatos();
        LecturaDatos2 datos2 = new LecturaDatos2();
        LecturaDatos3 datos3 = new LecturaDatos3();
        Ordenar sort = new Ordenar();
        DiviceTime = datos.Archivos(files);
        Genetico genetico = new Genetico(DiviceTime);
        // CSV
        /*for (int i = 0; i < DiviceTime.size(); i++) {
            ArrayList<double[]> tmp = DiviceTime.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                double dato[] = tmp.get(j);
                System.out.println("Datos Dimension:"+(i+2)+"P"+(j+1)+" "+"{"+dato[0]+ ","+dato[1]+ ","+dato[2]+ "}");
            }
        }*/
        data d = new data();
        jobs = rdjobs.RTrabajos(50);
        jobs2 = (ArrayList<int[]>) jobs.clone();

        /*------------------------------------------------------------------------------*/
        jobs = sort.FIFO(jobs);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba FIFO");
        d.grabar(genetico.gettiempodives(),"FIFO.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo FIFO");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.LIFO(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba LIFO");
        d.grabar(genetico.gettiempodives(),"LIFO.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo LIFO");
        /*--------------------------------------------------------------------------------*/
        jobs = sort.Pmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        System.out.println("Graba Pmin");
        d.grabar(genetico.gettiempodives(),"Pmin.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo Pmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Pmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba Pmax");
        d.grabar(genetico.gettiempodives(),"Pmax.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo Pmax");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba Dmin");
        d.grabar(genetico.gettiempodives(),"Dmin.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo Dmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba Dmax");
        d.grabar(genetico.gettiempodives(),"Dmax.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo Dmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba DPminmin");
        d.grabar(genetico.gettiempodives(),"DPminmin.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo DPminmin");
        
        
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba DPmaxmax");
        d.grabar(genetico.gettiempodives(),"DPmaxmax.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo DPmaxmax");
        
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba DPminmax");
        d.grabar(genetico.gettiempodives(),"DPminmax.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo DPminmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba DPmaxmin");
        d.grabar(genetico.gettiempodives(),"DPmaxmin.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo DPmaxmin");

        //*********************************************************************************************************************
        jobs = (ArrayList<int[]>) jobs2.clone();
        DiviceTime = datos2.Archivos(files);
        genetico = new Genetico(DiviceTime);
        /*------------------------------------------------------------------------------*/
        jobs = sort.FIFO(jobs);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 FIFO");
        d.grabar(genetico.gettiempodives(),"FIFO2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 FIFO");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.LIFO(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 LIFO");
        d.grabar(genetico.gettiempodives(),"LIFO2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 LIFO");
        /*--------------------------------------------------------------------------------*/
        jobs = sort.Pmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        System.out.println("Graba 2 Pmin");
        d.grabar(genetico.gettiempodives(),"Pmin2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 Pmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Pmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 Pmax");
        d.grabar(genetico.gettiempodives(),"Pmax2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 Pmax");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 Dmin");
        d.grabar(genetico.gettiempodives(),"Dmin2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 Dmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 Dmax");
        d.grabar(genetico.gettiempodives(),"Dmax2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 Dmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 DPminmin");
        d.grabar(genetico.gettiempodives(),"DPminmin2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 DPminmin");
        
        
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 DPmaxmax");
        d.grabar(genetico.gettiempodives(),"DPmaxmax2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 DPmaxmax");
        
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 DPminmax");
        d.grabar(genetico.gettiempodives(),"DPminmax2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 DPminmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 2 DPmaxmin");
        d.grabar(genetico.gettiempodives(),"DPmaxmin2.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 2 DPmaxmin");

        //*********************************************************************************************************************
        jobs = (ArrayList<int[]>) jobs2.clone();
        DiviceTime = datos3.Archivos(files);
        genetico = new Genetico(DiviceTime);
        /*------------------------------------------------------------------------------*/
        jobs = sort.FIFO(jobs);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 FIFO");
        d.grabar(genetico.gettiempodives(),"FIFO3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 FIFO");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.LIFO(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 LIFO");
        d.grabar(genetico.gettiempodives(),"LIFO3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 LIFO");
        /*--------------------------------------------------------------------------------*/
        jobs = sort.Pmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        System.out.println("Graba 3 Pmin");
        d.grabar(genetico.gettiempodives(),"Pmin3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 Pmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Pmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 Pmax");
        d.grabar(genetico.gettiempodives(),"Pmax3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 Pmax");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 Dmin");
        d.grabar(genetico.gettiempodives(),"Dmin3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 Dmin");
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.Dmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 Dmax");
        d.grabar(genetico.gettiempodives(),"Dmax3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 Dmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 DPminmin");
        d.grabar(genetico.gettiempodives(),"DPminmin3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 DPminmin");
        
    
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 DPmaxmax");
        d.grabar(genetico.gettiempodives(),"DPmaxmax3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 DPmaxmax");
        
        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPminmax(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 DPminmax");
        d.grabar(genetico.gettiempodives(),"DPminmax3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 DPminmax");

        
        /*------------------------------------------------------------------------------*/
        jobs = sort.DPmaxmin(jobs);
        genetico = new Genetico(DiviceTime);
        for (int[] trabajo : jobs) {
            long inicio = System.currentTimeMillis();
            // condierar rangos 10-20 = 100 generaciones , 21 - 30 = 200 generaciones, 31-40 = 300
            double tmp[]= genetico.doOperation(trabajo,trabajo[2]*2,trabajo[2]*10,0.2);
            long fin = System.currentTimeMillis();
            //System.out.println("La mejor solucion: "+Arrays.toString(tmp));
            //System.out.println("Tiempo de ejecucion: "+(fin-inicio));
        }
        d = new data();
        System.out.println("Graba 3 DPmaxmin");
        d.grabar(genetico.gettiempodives(),"DPmaxmin3.txt", genetico.getnotrabajos(),genetico.getmakespan(),genetico.getllego());
        System.out.println("Grabo 3 DPmaxmin");
    }
}