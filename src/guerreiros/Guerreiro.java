package guerreiros;

import ageOfMythologyRetoldArena.Equipe;
import java.util.LinkedList;

public abstract class Guerreiro {
    private int tipo;
    private String nome;
    private int idade;
    private double peso;
    private int energia = 100; //Por causa do prometeano
    private int ataque;
    private boolean statusVida = true;
    private boolean statusEnvenenado = false;
    private int qtdeInimigosMortos = 0;
  

    public Guerreiro(int tipo, String nome, int idade, double peso, int ataque) {
        this.tipo = tipo;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.ataque = ataque;
    }
    
    
    public int getTipo() {
        return tipo;
    }
   
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public int getEnergia() {
        return energia;
    }
    
     public int getAtaque() {
        return ataque;
    }
     
    public boolean isStatusEnvenenado() {
        return statusEnvenenado;
    }
     
    public boolean isStatusVida() {
        return statusVida;
    }

    public int getQtdeInimigosMortos() {
        return qtdeInimigosMortos;
    }
         
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }   
    
    public void setEnergia(int energia){
        this.energia = energia;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public void setStatusVida(boolean status) {
        this.statusVida = status;
    }

    public void setStatusEnvenenado(boolean statusEnvenenado) {
        this.statusEnvenenado = statusEnvenenado;
    }

    public void setQtdeInimigosMortos(int qtdeInimigosMortos) {
        this.qtdeInimigosMortos = qtdeInimigosMortos;
    }
        
    public abstract void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado);
    
    
    public void perderVida(int ataque, Equipe equipeAliada) {
       this.setEnergia(getEnergia()-ataque);
       System.out.println(this.getNome()+" recebeu "+ ataque + " de dano."+"Sua energia agora é" + this.getEnergia());
      
       this.verificaMorte(equipeAliada);
       
    }

    public void verificaMorte(Equipe equipeAliada) {
        if(this.getEnergia() <= 0){
            this.setStatusVida(false);
            System.out.println(this.getNome()+"...E morreu \n\n\n");
            //ManipularLista.enterro(ladoAliado, guerreiro, indice);
            
        }
        
    }
    
    public void envenenado(){
        if(this.isStatusEnvenenado()){
            this.setEnergia(this.getEnergia()-5);
            System.out.println("TRISTE, -5 de dano por veneno. Sua vida é:"+this.getEnergia());
            System.out.println("-----------------\n");
        }
}
    
}   