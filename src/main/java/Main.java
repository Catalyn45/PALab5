import parser.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        while(true) {
            try {
                parser.parse();
                parser.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
