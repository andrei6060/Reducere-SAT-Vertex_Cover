
import java.io.*;
import java.util.*;

public class task3 extends Task {
    public static void main(String[] args) throws IOException, InterruptedException {
        task3 task3 = new task3();
        task3.readProblemData();

    }

    int okay = 0;
    int n;
    int m;
    int k;
    int max;
    HashMap<String, Integer> dictionary = new HashMap<>();
    HashMap< Integer, ArrayList<String>> x = new HashMap<>();

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    ArrayList<ArrayList<Integer>> data = new ArrayList<>();

    @Override
    public void solve() throws IOException, InterruptedException {

    }

    @Override
    public void readProblemData() throws IOException {
        int size = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        ArrayList<String> alreadyHadCards = new ArrayList<>();
        this.m = Integer.parseInt(stringTokenizer.nextToken());
        this.k = Integer.parseInt(stringTokenizer.nextToken());
        this.n = Integer.parseInt(stringTokenizer.nextToken());
        String name;
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        if (m != 0) {
            for (int i = 0; i < m; i++) {
                name = in.readLine();
                alreadyHadCards.add(name);
            }
        }

        int auxx = 1;
        for (int i = 0; i < k; i++) {
            name = in.readLine();
            int contor = 0;
            for (String string : alreadyHadCards) {
                if (name.equals(string))
                    contor++;
            }
            if (contor == 0) {
                size++;
                dictionary.put(name, auxx);
                auxx++;
            }
        }
        int r;



        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(in.readLine());
            int noOfCards = Integer.parseInt(stringTokenizer.nextToken());

            r = 0;
            ArrayList<String> lista = new ArrayList<>();
            for (int j = 0; j < noOfCards; j++) {
                name = in.readLine();
                for (var entry : dictionary.entrySet()) {
                    if (entry.getKey().equals(name)) {
                        lista.add(name);
                    }
                }
            }
            this.x.put(i + 1, lista);
        }
        ArrayList<String> cardsFound = new ArrayList<>();
        ArrayList<Integer> setsNeeded = new ArrayList<>();
        int size_taken = 0;
        int still_searching = 1;
        while (still_searching == 1) {
            int aux = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int contor = 0;
//                for (var varr : this.x.entrySet())
//                    if (varr.getValue().equals(i + 1)) {
//                        for (String string : varr.getKey())
//                            if (!cardsFound.contains(string)) {
//                                contor++;
//                            }
//                    }
                var varr = this.x.get(i+1);
                for (String string : varr)
                            if (!cardsFound.contains(string)) {
                                contor++;
                            }

                if (contor > max) {
                    aux = i;
                    max = contor;
                }
            }
            //for(var varr : this.x.entrySet())
            var varr = this.x.get(aux + 1);
            //for(String string : varr)
              //  if(varr.getValue().equals(aux + 1)){
                    cardsFound.addAll(varr);
                //}
            setsNeeded.add(aux + 1);
            size_taken += max;
            if (size_taken >= size) {
                still_searching = 0;
            }
        }
        System.out.println(setsNeeded.size());
        for (Integer integer : setsNeeded) System.out.print(integer + " ");



    }

    @Override
    public void formulateOracleQuestion() throws IOException {

    }






    @Override
    public void decipherOracleAnswer() throws IOException {

    }

    @Override
    public void writeAnswer() throws IOException {


    }
}
