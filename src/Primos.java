public class Primos {
    public static void main(String[] args) {
        for(int i=5000;i<=7000;i++ ) {

            if(Primo(i)){

                System.out.println(i+"primo");


            }


        }



    }
    public static  boolean Primo( int numero ){


        if(numero % 2 == 0) {

            return false;
        }

        if(numero % 1 == numero || numero % numero == 1) {


            return false;
        }


        return true;



    }


}

