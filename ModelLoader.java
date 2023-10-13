import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelLoader {
    public static void main(String args[]) {
        ArrayList<float[]> Vertics = new ArrayList<>();
        ArrayList<float[]> VerticsN = new ArrayList<>();
        ArrayList<float[]> VerticsT = new ArrayList<>();
        List<Integer> Vindex = new ArrayList<>();
        List<Integer> Tindex = new ArrayList<>();
        List<Integer> Nindex = new ArrayList<>();
        String FilePath = "african_head.obj";
        try {
            FileReader f = new FileReader(FilePath);
            BufferedReader reader = new BufferedReader(f);
            String Line;
            String[] P;
            while ((Line = reader.readLine()) != null) {
                P = Line.split("\\s+");

                if (P.length == 0) {
                    continue;
                }

                if (P[0].equals("v")) {
                    float x = Float.parseFloat(P[1]);
                    float y = Float.parseFloat(P[2]);
                    float z = Float.parseFloat(P[3]);
                    Vertics.add(new float[] { x, y, z });
                }
                if (P[0].equals("vn")) {
                    float x = Float.parseFloat(P[1]);
                    float y = Float.parseFloat(P[2]);
                    float z = Float.parseFloat(P[3]);
                    float[] Vs = { x, y, z };
                    VerticsN.add(Vs);
                }
                if (P[0].equals("vt")) {
                    float x = Float.parseFloat(P[1]);
                    float y = Float.parseFloat(P[2]);
                    float z = Float.parseFloat(P[3]);
                    float[] Vs = { x, y, z };
                    VerticsT.add(Vs);
                }
                String[] parts;
               
                if (P[0].equals("f")) {
                    if (P[1].contains("/")) {
                        for (int i = 1; i < P.length; i++) {
                            parts = P[i].split("/"); // '1 1 1'
                            Vindex.add(Integer.parseInt(parts[0]));
                            Tindex.add(Integer.parseInt(parts[1]));
                            Nindex.add(Integer.parseInt(parts[2]));
                        }

                    }  
                }

            }
            System.out.println(Vindex.size());
            
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}