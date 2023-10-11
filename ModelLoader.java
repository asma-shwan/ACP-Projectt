import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelLoader{
    public static void main(String args[]){
        ArrayList<float[]> Vertics=new ArrayList<>();
        ArrayList<float[]> VerticsN=new ArrayList<>();
        ArrayList<float[]> VerticsT=new ArrayList<>();
        ArrayList<int[]> Faces=new ArrayList<>();
        String FilePath="Cube.obj";
        try{
        FileReader f=new FileReader(FilePath);
        BufferedReader reader=new BufferedReader(f);
        String Line;
        String[] P;
        while((Line=reader.readLine())!=null){
            P=Line.split("\\s+"); 

            if (P.length == 0) {
                continue;
            }

            if(P[0].equals("v")){
                float x=Float.parseFloat(P[1]);
                float y=Float.parseFloat(P[2]);
                float z=Float.parseFloat(P[3]);
                Vertics.add(new float[] {x,y,z});
            }
             if(P[0].equals("vn")){
                float x=Float.parseFloat(P[1]);
                float y=Float.parseFloat(P[2]);
                float z=Float.parseFloat(P[3]);
                float[] Vs={x,y,z};
                VerticsN.add(Vs);
            }
             if(P[0].equals("vt")){
                float x=Float.parseFloat(P[1]);
                float y=Float.parseFloat(P[2]);
                float z=Float.parseFloat(P[3]);
                float[] Vs={x,y,z};
                VerticsT.add(Vs);
            }
            if(P[0].equals("f")){
              for(int i=0;i<P.length;i++){
                String Snumber=P[i].replace("/","");
                int number =Integer.parseInt(Snumber.charAt(0));

              }
                
            }
           
        }
        reader.close(); 
        }catch(Exception e){
            System.out.println(e);
        }
        for(int i=0;i<Faces.size();i++){
            System.out.println(Arrays.toString(Faces.get(i)));
        }
    }
}