package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }


        // imprimirListaCandidatosSelecionados();
        // selecaoCandidatos();
        // analisarCandidato(1900.0);
    }

    static void entrandoEmContato(String candidato){
        int numeroTentativas = 1;
        boolean candidatoAtendeu = false;
        boolean continuarTentando = true;

        do {
            candidatoAtendeu = atendeu();
            continuarTentando = !candidatoAtendeu;

            if(continuarTentando){
                numeroTentativas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        } while (continuarTentando && numeroTentativas <= 3);
        
        if(candidatoAtendeu){
        System.out.println("CONSEGUIMOS CONTATO COM "+candidato+" NA "+numeroTentativas+"º TENTATIVA");
        }else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM "+candidato+". NÚMERO DE TENTATIVAS: "+ numeroTentativas);

        }

    }
    
    //método auxiliar
    static boolean atendeu(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirListaCandidatosSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        // For normal
        for(int i=0; i<=candidatos.length;i++){
            System.out.println("O candidato nº " + (i+1) + " é "+ candidatos[i]);
        }
        //For each
        for(String candidato: candidatos){
            System.out.println("O candidato "+candidato+" foi selecionado" );
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JOAO"};

        int candidatoAtual = 0;
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;
        

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double valorPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + " solicitou esse valor de salario R$" + valorPretendido);

            if (salarioBase > valorPretendido) {
                System.out.println("O candidato "+ candidato + " foi selecionado para vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    //método auxiliar
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0,2200.0);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase==salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else{
            System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
