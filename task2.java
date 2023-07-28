
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class task2 extends Task{
    public static void main(String[] args) throws IOException, InterruptedException {
        task2 task2 = new task2();
        task2.readProblemData();
            task2.formulate();

    }
    int okay = 0;
    int n;
    int m;
    int k;
    int max;
    HashMap<String, Integer> dictionary = new HashMap<>();
    ArrayList<Integer> x = new ArrayList<>();

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    ArrayList<ArrayList<Integer>> data = new ArrayList<>();

    @Override
    public void solve() throws IOException, InterruptedException {

    }

    @Override
    public void readProblemData() throws IOException {
        int x;
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
        if(m!=0) {
            for (int i = 0; i < m; i++) {
                name = in.readLine();
                alreadyHadCards.add(name);
            }
        }
//        if(n == 1){
////            System.out.println(1);
////            System.out.println(1);
//        }
//        else {

            int auxx = 1;
            for (int i = 0; i < k; i++) {
                name = in.readLine();
                int contor = 0;
                for (String string : alreadyHadCards) {
                    if (name.equals(string))
                        contor++;
                }
                if (contor == 0) {
                    dictionary.put(name, auxx);
                    auxx++;
                }
            }
            for (int i = 0; i < n; i++) {
                data.add(new ArrayList<>());
                stringTokenizer = new StringTokenizer(in.readLine());
                int noOfCards = Integer.parseInt(stringTokenizer.nextToken());
                for (int j = 0; j < noOfCards; j++) {
                    name = in.readLine();
                    for (var entry : dictionary.entrySet()) {
                        if (entry.getKey().equals(name))
                            data.get(i).add(entry.getValue());
                    }
                }
            }


    }

    @Override
    public void formulateOracleQuestion() throws IOException {

    }


    public void formulate() throws IOException, InterruptedException {
        for(int andrei = 1; andrei <= n; andrei++){
        FileWriter fileWriter = new FileWriter("sat.cnf");
        fileWriter.write("p cnf " + andrei * this.n + " " + 100000 + "\n");
        int h = 0;
        int e = 0;
        int q;
        for (int i = 0; i < andrei; i++) {
            q = 0;
            for (int j = 1; j <= n; j++) {
                matrix.get(e).add(j + i * n);
                fileWriter.write((matrix.get(e).get(q)) + " ");
                q++;
            }
            e++;
            fileWriter.write("0\n");
        }

        for (int g = 0; g < andrei; g++)
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    fileWriter.write("-" + matrix.get(g).get(i) + " -" + matrix.get(g).get(j) + " 0\n");

                }

            }


        for (int contor = 1; contor <= this.dictionary.entrySet().size(); contor++) {

            for (int i = 0; i < n; i++) {
                for (int string : data.get(i))
                    if (string == contor) {
                        int aux = i + 1;
                        while (aux <= andrei * n) {
                            fileWriter.write(aux + " ");
                            aux += n;
                        }
                    }

            }
            fileWriter.write("0\n");
        }
        fileWriter.close();
            this.askOracle();
            FileReader fileReader = new FileReader("sat.sol");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String auxx = stringTokenizer.nextToken();
            if(auxx.equals("True")){
                System.out.println(andrei);
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int no = Integer.parseInt(stringTokenizer.nextToken());
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int i = 0; i < no; i++) {
                    int w = Integer.parseInt(stringTokenizer.nextToken());
                    if (w > 0) {
                        if (w % n == 0) {
                            System.out.print(n + " ");
                        } else {
                            System.out.print(w % n + " ");
                        }
                    }
                }
                andrei = n;

            }
    }

        }

    @Override
    public void decipherOracleAnswer() throws IOException {
//        FileReader fileReader = new FileReader("sat.sol");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        String auxx = stringTokenizer.nextToken();
//        if(auxx.equals("True")){
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            int no = Integer.parseInt(stringTokenizer.nextToken());
//            System.out.println(2);
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            for(int i = 0; i < no; i++){
//                int w = Integer.parseInt(stringTokenizer.nextToken());
//                if(w>0){
//                    if(w % n == 0){
//                        System.out.print(n + " ");
//                    }else{
//                        System.out.print(w % n + " ");
//                    }
//                }
//
//            }
//
//        } else {
//            System.out.print("auxx");
//            System.out.println("auxx");
//        }

    }

    @Override
    public void writeAnswer() throws IOException {


    }
}
