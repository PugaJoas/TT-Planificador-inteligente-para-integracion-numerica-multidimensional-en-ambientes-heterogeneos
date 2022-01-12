import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

class data{
    public data(){
        
    }

    public void grabar(String[] dato,String name, int[] nojobs,double[] makespan, String llego){
        try{
            // Create new file
            FileWriter fw = new FileWriter(name);
            // Write in file
            fw.write("Trabajos: "+llego+"\n");
            for(int i=0; i < dato.length;i++){
                fw.write("Device: "+i+" Atendio: "+nojobs[i]+" makespan: "+makespan[i]+"\n"+dato[i]+"\n");
            }
            fw.write("\n");
            // Close connection
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}