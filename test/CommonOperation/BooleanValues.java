package CommonOperation;

public class BooleanValues {
    public static void main(String[] args) {
        Boolean[][] booleans = new Boolean[2][3];

        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                System.out.println(booleans[i][j]);
            }
        }
    }
}
