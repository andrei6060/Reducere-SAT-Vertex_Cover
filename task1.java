import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class task1 extends Task {
    public static void main(String[] args) throws IOException, InterruptedException {
        task1 task1 = new task1();
        task1.readProblemData();
        task1.formulateOracleQuestion();
        task1.askOracle();
        task1.decipherOracleAnswer();

    }

    int n;
    int m;
    int k;
    int max;
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

        this.m = Integer.parseInt(stringTokenizer.nextToken());
        this.k = Integer.parseInt(stringTokenizer.nextToken());
        this.n = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < this.k; i++) {
            data.add(new ArrayList<>());
            stringTokenizer = new StringTokenizer(in.readLine());
            x = Integer.parseInt(stringTokenizer.nextToken());
            if (x > this.max)
                max = x;
            for (int j = 0; j < x; j++) {
                data.get(i).add(Integer.parseInt(stringTokenizer.nextToken()));

            }
        }

    }

    @Override
    public void formulateOracleQuestion() throws IOException {
        FileWriter fileWriter = new FileWriter("sat.cnf");
        int value = n + k + k * m * (m - 1) / 2 + m * k * (k - 1) / 2;
        fileWriter.write("p cnf " + this.n * this.k + " " + value + "\n");
        int h = 0;
        int e = 0;
        int q;
        for (int i = 0; i < n; i++) {
            q = 0;
            for (int j = 1; j <= k; j++) {
                //matrix.get(e).set(q, j + i * k);
                matrix.get(e).add(j + i * k);
                fileWriter.write((matrix.get(e).get(q)) + " ");
                q++;
            }
            e++;
            fileWriter.write("0\n");
        }
//        m k n
//        n m k

        for(int g=0; g<n; g++)
            for(int i=0; i<k-1; i++){
                for( int j=i+1; j<k; j++){
                    fileWriter.write("-" + matrix.get(g).get(i) + " -" + matrix.get(g).get(j) + " 0\n");

                }

            }


        for (int contor = 1; contor <= m; contor++) {
            for (int i = 0; i < k; i++)
                for (int j = 0; j < max; j++)
                    if (j < data.get(i).size()) {
                        if (data.get(i).get(j) == contor) {
                            int aux = i + 1;
                            while (aux <= n * k) {
                                fileWriter.write(aux + " ");
                                aux += k;
                            }
                        }
                    }
            fileWriter.write("0\n");
        }
        fileWriter.close();
    }

    @Override
    public void decipherOracleAnswer() throws IOException {
        FileReader fileReader = new FileReader("sat.sol");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String auxx = stringTokenizer.nextToken();
        if(auxx.equals("True")){
            System.out.println("True");
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int no = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(n);
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i < no; i++){
                int w = Integer.parseInt(stringTokenizer.nextToken());
                if(w>0){
                    if(w % k == 0){
                        System.out.print(k + " ");
                    }else{
                        System.out.print(w % k + " ");
                }
            }

        }
        } else {
            System.out.print(auxx);
        }

    }

    @Override
    public void writeAnswer() throws IOException {


    }
}