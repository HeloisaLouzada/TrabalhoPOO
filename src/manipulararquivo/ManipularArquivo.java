package manipulararquivo;

//Guerreiros
import guerreiros.Guerreiro;
import guerreiros.gregos.*;
import guerreiros.atlantes.*;
import guerreiros.egipicio.*;
import guerreiros.nordico.*;


//Utilidade
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ManipularArquivo{
    
    public static LinkedList<Guerreiro> LerArquivo(String nomeArquivo, int time){
        LinkedList<Guerreiro> subLista = new LinkedList<>(); //cria a sublista e adiciona todos nela
        try{    
               FileInputStream fil = new FileInputStream(nomeArquivo);
               Scanner scan = new Scanner(fil);
               
               while (scan.hasNext()) {
                    int tipo = scan.nextInt();
                    String nome = scan.next();
                    int idade = scan.nextInt();
                    int peso = scan.nextInt();
                    
                    Guerreiro guerreiro = null;
                    
                    if(time == 1){
                        switch(tipo){
                            case 1 -> guerreiro = new Ciclope(tipo,nome,idade,peso, 35);//O pai
                            case 2 -> guerreiro = new Manticora(tipo,nome,idade,peso, 30);//guerreiro = new Manticora(tipo,nome,idade,peso,30);
                            case 3 -> guerreiro = new Hidra(tipo,nome,idade,peso, 50);//guerreiro = new Hidra(tipo,nome,idade,peso, 50);
                            case 4 -> guerreiro = new Valquiria(tipo,nome,idade,peso, 20);
                            case 5 -> guerreiro = new LoboFenris(tipo,nome,idade,peso, 40);
                            case 6 -> { 
                                guerreiro = new GiganteDePedra(tipo,nome,idade,peso, 30);
                                guerreiro.setEnergia(300);//não sei se está certo
                            }
                            
                            default -> {
                           }
                        }
                    } else{
                        switch(tipo){
                            case 1 -> guerreiro = new Prometeano(tipo,nome,idade,peso, 10, 0);//O pai
                            case 2 -> guerreiro = new Satiro(tipo,nome,idade,peso,10);
                            case 3 -> {
                                guerreiro = new Argus(tipo,nome,idade,peso,1000);
                                 guerreiro.setEnergia(60);
                            }
                            case 4 -> guerreiro = new Anubita(tipo,nome,idade,peso,10);
                            case 5 -> guerreiro = new HomemEscorpiao(tipo,nome,idade,peso,20);
                            case 6 -> guerreiro = new Mumia(tipo,nome,idade,peso,50);
                            default -> {
                                break;
                           }
                        }
                    
                    }
                    
                    
                    if (guerreiro != null) {
                        System.out.println(guerreiro.getNome());
                        System.out.println(guerreiro.getIdade());
                        System.out.println(guerreiro.getPeso());
                        System.out.println(guerreiro.getEnergia());
                        
                        subLista.add(guerreiro);
                    } else{
                        System.out.println("Tipo de guerreiro inválido: " + tipo);
                    }
               }
               scan.close();
               //equipe.add(subLista);
           }catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
           } 
   
    return subLista;
    }
}


