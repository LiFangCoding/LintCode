package CommonOperation;

public class BooleanValues {
    public static void main(String[] args) {
        Boolean[][] booleans = new Boolean[2][3];

        for (Boolean[] aBoolean : booleans) {
            for (int j = 0; j < booleans[0].length; j++) {
                System.out.println(aBoolean[j]);
            }
        }
    }
}
