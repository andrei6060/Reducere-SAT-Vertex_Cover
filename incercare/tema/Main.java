import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        task1 task1 = new task1();
        task1.readProblemData();
        task1.solve();
        task1.askOracle();
        task1.decipherOracleAnswer();
        task1.writeAnswer();
    }
}
