package ageOfMythologyRetoldArena;

import ageOfMythologyRetoldArena.questoes.Questoes;
import guerreiros.Guerreiro;
import java.util.LinkedList;
import manipularlista.ManipularLista;
import manipulararquivo.ManipularArquivo;
import java.util.Random;
import static manipularlista.ManipularLista.moverFinalFila;


public class Arena {
    private boolean ataqueGigantePedra = false;
    private int indiceGigante = 0;
    LinkedList<LinkedList<Guerreiro>> ladoGN;
    LinkedList<LinkedList<Guerreiro>> ladoAE;
    Guerreiro ultimoMorto = null;
    Guerreiro ultimoAtacante = null;
    Equipe equipeVencedora = null;
    Equipe equipeDerrotada = null;

    public boolean isAtaqueGigantePedra() {
        return ataqueGigantePedra;
    }

    public void setAtaqueGigantePedra(boolean ataqueGigantePedra) {
        this.ataqueGigantePedra = ataqueGigantePedra;
    }

    public int getIndiceGigante() {
        return indiceGigante;
    }

    public void setIndiceGigante(int indiceGigante) {
        this.indiceGigante = indiceGigante;
    }

    public LinkedList<LinkedList<Guerreiro>> getLadoGN() {
        return ladoGN;
    }

    public LinkedList<LinkedList<Guerreiro>> getLadoAE() {
        return ladoAE;
    }

    public void setUltimoMorto(Guerreiro ultimoMorto) {
        this.ultimoMorto = ultimoMorto;
    }

    public void setUltimoAtacante(Guerreiro ultimoAtacante) {
        this.ultimoAtacante = ultimoAtacante;
    }

    public void setEquipeVencedora(Equipe equipeVencedora) {
        this.equipeVencedora = equipeVencedora;
    }

    public void setEquipeDerrotada(Equipe equipeDerrotada) {
        this.equipeDerrotada = equipeDerrotada;
    }

   
    
    public Guerreiro getUltimoMorto() {
        return ultimoMorto;
    }

    public Guerreiro getUltimoAtacante() {
        return ultimoAtacante;
    }

    public Equipe getEquipeVencedora() {
        return equipeVencedora;
    }

    public Equipe getEquipeDerrotada() {
        return equipeDerrotada;
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        final int quantidade = 4;
       
        Arena areninha = new Arena();
        
        areninha.ladoGN=Equipe.CriaLista(quantidade);
        areninha.ladoAE = Equipe.CriaLista(quantidade);
        
        //Lê os arquivos e monta as filas
        System.out.println("=== Lado Gregos e Nórdicos ===");
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo1.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo2.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo3.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo4.txt", 1));    
        
        System.out.println("\n\n\n=== Lado Atlantes e egípicios ===");
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo5.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo6.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo7.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo8.txt", 2));

        Equipe equipeGN = new Equipe(1, areninha.ladoGN, 0);
        Equipe equipeAE = new Equipe(2, areninha.ladoAE, 0);
        
        System.out.println("\n\n\nQUESTÃO 2");
        Questoes.somaPeso(equipeGN);
        Questoes.somaPeso(equipeAE);
        
        System.out.println("\n\n\nQUESTÃO 3");
        Questoes.guerreiroMaisVelho(areninha, quantidade);
        
        areninha.rodada(areninha, equipeGN, equipeAE, quantidade);
        
    }//FIM DA MAIN ==============================================================
    
    //FUNÇÕES AUXILIARES 
    public void rodada(Arena parquinho, Equipe equipeGN, Equipe equipeAE, int quantidadeFilas){ 
        int time = 0;
        String equipeVencedora = "";
           
        try {
            while (!equipeGN.getEquipe().isEmpty() && !equipeAE.getEquipe().isEmpty()) {

                Random sorteador = new Random();
                time = (sorteador.nextInt(2) + 1);

                System.out.println("\nO TIME SORTEADO FOI:" + time);

                if (time == 1) { //ADICIONAR O MÉTODO ENTERRO DEPOIS DE CADA ATAQUE PARA LIMPAR A ARENA
                    equipeVencedora = "Equipe AE";
                    parquinho.combate(parquinho, equipeGN, equipeAE, time, quantidadeFilas);
                    ManipularLista.enterro(equipeAE);

                    equipeVencedora = "Equipe GN";
                    parquinho.combate(parquinho, equipeAE, equipeGN, time, quantidadeFilas);
                    ManipularLista.enterro(equipeGN);

                } else {
                    equipeVencedora = "Equipe GN";
                    parquinho.combate(parquinho, equipeAE, equipeGN, time, quantidadeFilas);
                    ManipularLista.enterro(equipeGN);

                    equipeVencedora = "Equipe AE";
                    parquinho.combate(parquinho, equipeGN, equipeAE, time, quantidadeFilas);
                    ManipularLista.enterro(equipeAE);
                }
                //REINICIAR RODADA
                //finalizou o combate, joga os guerreiros para trás
                //Desliga o método gigante
                parquinho.setAtaqueGigantePedra(false);
                System.out.println("Efeito do gigante de pedra silenciado");

                moverFinalFila(equipeGN, quantidadeFilas);
                moverFinalFila(equipeAE, quantidadeFilas);
                equipeGN.setContadorAtaques(0);
                equipeAE.setContadorAtaques(0);

                System.out.println("\n\n FIM DA RODADA \n\n");
                /*if (equipeGN.getEquipe().isEmpty() || equipeAE.getEquipe().isEmpty()) {
                    System.out.println("\n\n ACABOOOOU \n\n");
                }*/
                
        }
        } catch (FimDeJogoException erro) {
            System.out.println(erro.getMessage());
            
        }
    }

    public void combate(Arena parquinho, Equipe equipeAliada, Equipe equipeInimiga, int timeSorteado, int quantidade) throws FimDeJogoException {
        System.out.println("\n\n\n======================== INICIO DO COMBATEEEE! ========================\n\n\n");

        // Pega a fila que irá atacar, e repete por todas
        for (int i = 0; i < equipeAliada.getEquipe().size(); i++) { //anda para o próximo for
            LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(i);

            // Verifica se a fila aliada não está vazia, se tiver ela passa para a próxima
            if (filaAliada.isEmpty()) {
                System.out.println("A fila" + i + "Está vazia...");
                continue;
            }

            //pega o guerreiro que irá atacar
            Guerreiro guerreiroAliado = filaAliada.getFirst();

            for (Guerreiro guerreiro : filaAliada) {
                if (guerreiroAliado.isStatusVida()) {
                    guerreiroAliado = guerreiro;
                    break;  // Encontra o primeiro vivo e sai do loop, obs deveria pegar o primeiro
                }
            }
                //ESCOLHER INIMIGO ========================================================================================
                Guerreiro guerreiroInimigo = null;
                int j = i; //pega o índice da equipe do lado

                while (j < equipeInimiga.getEquipe().size()) { //roda até encontrar 
                    LinkedList <Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(j);
                    if (!filaInimiga.isEmpty()) {//se não estiver vazia
                        guerreiroInimigo = filaInimiga.getFirst();
                        break;
                    }
                    j++;
                }

                if ((guerreiroInimigo != null) && (guerreiroInimigo.isStatusVida())) {//se o gurreiro estiver vivo LUTEMMM
                    
                    System.out.println("Guerreiro aliado da fila " + i + " está atacando o inimigo da fila" + j);
                    equipeAliada.setContadorAtaques(equipeAliada.getContadorAtaques() + 1);
                    
                    if ((parquinho.ataqueGigantePedra == true) && (timeSorteado != equipeAliada.getIndicador())) {
                        guerreiroAliado.ataque(parquinho, equipeInimiga, equipeAliada, parquinho.getIndiceGigante(), i, timeSorteado);
                    } else {
                        guerreiroAliado.ataque(parquinho, equipeInimiga, equipeAliada, j, i, timeSorteado);
                    }
                    
                    parquinho.setUltimoMorto(guerreiroInimigo);
                    guerreiroInimigo.verificaMorte(equipeInimiga);// Tira o morto da arena
                    
                    
                } else {
                    System.out.println("Nenhum inimigo disponível para o guerreiro aliado do índice " + i);
                    //removerFila(equipeInimiga,j);//coloquei de volta
                    parquinho.setUltimoAtacante(guerreiroAliado);
                    parquinho.setEquipeDerrotada(equipeInimiga);
                    parquinho.setEquipeVencedora(equipeAliada);
                    throw new FimDeJogoException(parquinho.ultimoAtacante, parquinho.ultimoMorto , parquinho.equipeVencedora, parquinho.equipeDerrotada);
                    
                }
        }
}

}//FIM DA CLASSE   

