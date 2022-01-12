import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Ordenar {

    public Ordenar() {

    }
    /* 
        Pmin
        Pmax
        Dmin
        Dmax
        LIFO
        FIFO ***
        ATF
        ATL
        Dmin + Pmin
        Dmin + Pmax
        Dmax + Pmin
        Dmax + Pmax
    */
    /*--------------------------------Ordenar tiempos------------------*/
    public ArrayList<double[]> Tmin(ArrayList<double[]> operaciones) {
        Collections.sort(operaciones, new Comparator<double[]>() {
            @Override
            public int compare(double[] t, double[] t1) {
                return Double.compare(t[t.length-2], t1[t.length-2]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    public ArrayList<double[]> mejor(ArrayList<double[]> operaciones) {
        Collections.sort(operaciones, new Comparator<double[]>() {
            @Override
            public int compare(double[] t, double[] t1) {
                return Double.compare(t[t.length-2], t1[t.length-2]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    public ArrayList<double[]> Tmax(ArrayList<double[]> operaciones) {
        Collections.sort(operaciones, new Comparator<double[]>() {
            @Override
            public int compare(double[] t, double[] t1) {
                return Double.compare(t1[t.length-2], t[t.length-2]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }
    //-------------------------------SIMPLE RULES----------------------------------
    //Ordenamiento por menor numero de puntos
    public ArrayList<int[]> Pmin(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[2], t1[2]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }
    //Ordenamiento por mayor numero de puntos
    public ArrayList<int[]> Pmax(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[2], t[2]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Ordenamiento por menor numero de dimensiones
    public ArrayList<int[]> Dmin(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[1], t1[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Ordenamiento por mayor numero de dimensiones
    public ArrayList<int[]> Dmax(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[1], t[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //FIFO Rule.
    public ArrayList<int[]> FIFO(ArrayList<int[]> operaciones){
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //LIFO RULE
    public ArrayList<int[]> LIFO(ArrayList<int[]> operaciones){
        Collections.reverse(operaciones);
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Arrive Time 
    public ArrayList<int[]> ATF(ArrayList<int[]> operaciones){
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[3], t1[3]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Arrive Time 
    public ArrayList<int[]> ATL(ArrayList<int[]> operaciones){
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[3], t[3]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //-------------------------------HYBRID RULES----------------------------------

    //Dmin + Pmin
    public ArrayList<int[]> DPminmin(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[2], t1[2]);
            }
        });
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[1], t1[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Dmax + Pmax
    public ArrayList<int[]> DPmaxmax(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[2], t[2]);
            }
        });
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[1], t[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Dmin + Pmax
    public ArrayList<int[]> DPminmax(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[2], t[2]);
            }
        });
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[1], t1[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }

    //Dmax + Pmin
    public ArrayList<int[]> DPmaxmin(ArrayList<int[]> operaciones) {
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t[2], t1[2]);
            }
        });
        Collections.sort(operaciones, new Comparator<int[]>() {
            @Override
            public int compare(int[] t, int[] t1) {
                return Integer.compare(t1[1], t[1]);
            }
        });
        /*for (int[] is : operaciones) {
            System.out.println(Arrays.toString(is));
        }*/
        return operaciones;
    }
}