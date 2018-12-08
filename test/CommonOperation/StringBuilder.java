package CommonOperation;

public class StringBuilder {
    public static void main(String[] args) {
        String s1 = "he";
        String s2 = "1";
        String s3 = "2";

        String s = "";
        s = s + s1;
        s = s + s2;
        s = s + s3;

        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(s1);
        sb.append(s2);
        sb.append(s3);

        sb.append(2);
        sb.append(true);
        System.out.println(sb);
    }
}
