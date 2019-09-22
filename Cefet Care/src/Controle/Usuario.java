package Controle;

import java.io.Serializable;


public abstract class Usuario implements Serializable{
    
    String senha;
    private String nome;

    public Usuario( String nome,String senha) {
        this.senha = senha;
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

  /*  public String getEspecialidade(){
        return null;
    }*/
        
    
    
    
    
}
