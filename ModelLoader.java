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
        ArrayList<List<Integer>> Faces = new ArrayList<>();
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
                List<Integer> TotalFaces = new ArrayList<>();
                if (P[0].equals("f")) {
                    if (P[1].contains("/")) {
                        System.out.println("Case I"); // "f 1/1/1 2/2/2 3/3/3"
                        for (int i = 1; i < P.length; i++) {
                            parts = P[i].split("/"); // '1 1 1'
                            for (int j = 0; j < parts.length; j++) {
                                int idx = Integer.parseInt(parts[j]);
                                TotalFaces.add(idx);
                            }
                        }
                        Faces.add(TotalFaces);
                        System.out.println(Faces);
                    } else {
                        System.out.println("Case II");
                        int x = Integer.parseInt(P[1]);
                        int y = Integer.parseInt(P[2]);
                        int z = Integer.parseInt(P[3]);
                        List<Integer> face = new ArrayList<>();
                        face.add(x);
                        face.add(y);
                        face.add(z);
                        Faces.add(face);
                    }
                    System.out.println(Faces);

                }

            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}