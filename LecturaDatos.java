import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class LecturaDatos {
    private String linea = "";
    private String limitador = ",";
    private ArrayList<ArrayList<double[]>> tiempos = new ArrayList<ArrayList<double[]>>();
    private BufferedReader br;

    public LecturaDatos() {

    }

    public ArrayList<ArrayList<double[]>> Archivos(String[] archivo) {
        try {
            int larchivo = archivo.length;
            for (int i = 0; i < larchivo; i++) {
                br = new BufferedReader(new FileReader(archivo[i]));
                ArrayList<double[]> tmptiempos = new ArrayList<double[]>();
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] arreglo = linea.split(limitador);
                    //Tiemp {Sec,OMP,P400}
                    double tmp[] = { Double.parseDouble(arreglo[1]),Double.parseDouble(arreglo[4]),Double.parseDouble(arreglo[7])};
                    tmptiempos.add(tmp);
                }
                tiempos.add(tmptiempos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiempos;
    }
}