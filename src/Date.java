import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Date1 {

    private int id;
    private float notaExercicio;
    private float notaFinal;
    private Date dataDaEntrega;
    private String data;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM");
            ArrayList<Date1> alunos = new ArrayList<Date1>();
            Date1 getAll = new Date1();
            float notaExercicio[] = new float[10];
            float notaFinal[] = new float[10];

            for (int i = 0; i < 3; i++){

                alunos.add(new Date1());
                System.out.println("Entre com a Matricula do Aluno");
                alunos.get(i).id = sc.nextInt();
                sc.nextLine();
                System.out.println("Entre com a nota provisoria");
                alunos.get(i).notaExercicio = sc.nextFloat();
                sc.nextLine();
                System.out.println("Entre com a data de Entrega");
                alunos.get(i).data = sc.nextLine();
                alunos.get(i).dataDaEntrega = formatoData.parse(alunos.get(i).data);



                alunos.get(i).calcularNotaDoAluno();
                notaFinal[i] = alunos.get(i).notaFinal;
                notaExercicio[i] = alunos.get(i).notaExercicio;
            }
            for (int i = 0 ; i< alunos.size(); i++){
                System.out.println("Matricula Aluno"+ alunos.get(i).id);
                System.out.println("Nota Aluno"+ alunos.get(i).notaFinal);

            }
            Date1 geral;

            System.out.println("A Media das notas provisoria é igual a :" + getAll.mediaAlunos(notaExercicio));
            System.out.println("O Desvio padrão das notas provisorias é igual a :"+ getAll.desvioDeSoma(notaExercicio));
            System.out.println("A Media das notas finais é igual a: " + getAll.mediaAlunos(notaFinal));
            System.out.println("O Desvio padrão das notas finais é igual a ;" +  getAll.desvioDeSoma(notaFinal));

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }


    }
    private void calcularNotaDoAluno(){

        SimpleDateFormat formatoData1 = new SimpleDateFormat("dd/MM");


        try {
            Date firstDate = formatoData1.parse("20/04");
            Date secondDate = formatoData1.parse("02/05");
            Date thirdDate = formatoData1.parse("30/05");
            Date fourthDate = formatoData1.parse("30/06");
            if (this.dataDaEntrega.before(firstDate)||
                    this.dataDaEntrega.equals(firstDate)){
                this.notaFinal = (float) (notaExercicio + 10.0);
            }else if(this.dataDaEntrega.after(firstDate) && (this.dataDaEntrega.before(secondDate)
                    ||(this.dataDaEntrega.equals(secondDate)) )){
                this.notaFinal = this.notaExercicio;
            }else if(this.dataDaEntrega.after(secondDate) && (this.dataDaEntrega.before(thirdDate))
                    ||(this.dataDaEntrega.equals(thirdDate)) ){
                this.notaFinal = this.notaExercicio/=2;
            }else if(this.dataDaEntrega.after(thirdDate) && (this.dataDaEntrega.before(fourthDate)
                    || (this.dataDaEntrega.equals(fourthDate)) )){
                this.notaFinal = (float) 0;
            }
            else{

                this.notaFinal = (float) 0;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private double mediaAlunos(float[] nota){
        float soma = 0;
        for (int i = 0 ; i <nota.length; i++){
            soma = (float) (soma + nota[i]);
        }
        return soma/nota.length;
    }
    private double desvioDeSoma(float[] nota){
        float sum1 = (float) 0.2f;
        float sum2 = (float) 0.2f;
        for (int i= 0; i <nota.length;i++ ){
            sum1 = (float) (sum1 + Math.pow(nota[i],2));
            sum2 = (float) (sum2 + nota[i]);
        }
        float somaDesvio = (float) ((sum1 - (Math.pow(sum2, 2)/nota.length))/(nota.length -1));
        return Math.sqrt(somaDesvio);
    }
}
