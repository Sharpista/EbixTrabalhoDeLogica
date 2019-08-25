import java.util.Scanner;

public class Alunos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = null;
        int nota1 = 0;
        int nota2 = 0;
        int nota3 = 0;
        int frequenciaAluno =0;
        int mediaAluno =0;
        int aluno;
        int contReprovados = 0;
        int reprovadosPorFreq = 0;
        int menor = 0;
        int maior = 0;
        int turmaMedia = 0;



        for(aluno= 1; aluno<=3;aluno++) {
            System.out.print("Entre com a Matricula");
            id = sc.next();
            sc.nextLine();
            System.out.println("Entre com a primeira nota");
            nota1=sc.nextInt();
            sc.nextLine();
            System.out.println("Entre com a segunda Nota");
            nota2= sc.nextInt();
            sc.nextLine();
            System.out.println("Entre com a terceina nota");
            nota3 = sc.nextInt();
            sc.nextLine();
            System.out.println("Entre com a frequencia");
            frequenciaAluno= sc.nextInt();
            sc.nextLine();

            mediaAluno = (nota1+nota2+nota3)/3;
            if(frequenciaAluno <40) {


                reprovadosPorFreq ++;
            }

            if(mediaAluno >= 6 &&  frequenciaAluno >=40) {


                System.out.println("O Aluno da Matricula:"+id+
                        "com media de nota :"+mediaAluno+" e com frequencia :"
                        +frequenciaAluno+
                        " está Aprovado");



            }else {


                System.out.println("O Aluno da Matricula:"+id+
                        "com media de nota:"+mediaAluno+" e com frequencia:"
                        +frequenciaAluno+
                        " está Reprovado");

                contReprovados ++;

            }
            if(mediaAluno < menor || menor ==0) {

                menor = mediaAluno;

            }if (mediaAluno > maior) {
                maior = mediaAluno;
            }

            turmaMedia = turmaMedia+mediaAluno;

            System.out.println("-----------------------------------------");

        }


        System.out.println("Media da Turma:" + turmaMedia/3);
        System.out.println("A menor nota da turma é: "+menor);
        System.out.println("A maior nota da turma é: "+maior);
        System.out.println("O numero de Alunos Reprovado é:"+contReprovados);
        System.out.println("O numero de Alunos Reprovados por Frequencia é:"+reprovadosPorFreq);
        System.out.println("Quantidade De Alunos por infrequencia"+(reprovadosPorFreq*100)/10+"%");

        sc.close();
    }
}
