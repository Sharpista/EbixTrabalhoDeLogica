public class FtoC {
    public static void main(String[] args) {
        float c;

        for(double f = 50; f <= 150; f++) {

            c = (float) ((f -32)*5/9);

            System.out.println("F° em C° é = " + c );
        }
    }
}
