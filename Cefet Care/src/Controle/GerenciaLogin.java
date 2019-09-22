package Controle;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciaLogin implements Serializable {

    public ArrayList<Usuario> bancoDados = new ArrayList<>();
    public ArrayList<Prontuario> bancoProntuarios = new ArrayList();
    
    public boolean consultarCadastro(String nome, String senha){
        
        Iterator<Usuario> iterar = bancoDados.iterator();
        Usuario aux;
      
      while(iterar.hasNext())
      {
          
        
        aux = iterar.next();
        
          
        if(aux.getNome().equals(nome))
        {
            
            if(aux.getSenha().equals(senha))
                return true;
            
            else
                return false;
        }
      }  
            return false;
    }
    
    public Usuario retornarUsuario(String nome){
        
        
      Iterator<Usuario> iterar = bancoDados.iterator();
      Usuario aux;
        
      while(iterar.hasNext())
      {
         
        aux = iterar.next();
        if(aux.getNome().equals(nome))
        {
            return aux;
        }
      }  
            return null;
        
    }
    
    public boolean adicionarnovoUsuario(Usuario usuario,String nome){
        
        
      Iterator<Usuario> iterar = bancoDados.iterator();
      Usuario aux;
        
      while(iterar.hasNext())
      {
        
        aux = iterar.next();
        if(aux.getNome().equals(nome))
        {
            return false;
        }
      }  
            
        return bancoDados.add(usuario);
        
        
    }
        
    public boolean removerUsuario(Usuario usuario){
        
      return bancoDados.remove(usuario);
        
    }
    
    public int verificarSenha(String senha){
        
        //1-SENHA CURTA
        //2-SENHA SEM LETRA MAIUSCULA
        //3-SENHA SEM NUMERO
        //0-TUDO OK
        
        
        if(senha.length()<8)
        {
            return 1;
        }
        for(char aux = 'A'; aux<='Z';aux++)
        {
            String aux2 = String.valueOf(aux);
           
            if(senha.contains(aux2))
                return 2;
        }
        
         for(char aux = '0'; aux<='9';aux++)
        {
            String aux2 = String.valueOf(aux);
           
            if(senha.contains(aux2))
                return 3;
        }
        
        return 0;
    }
    
    public boolean existePaciente(String nome){
        
        Iterator<Usuario> iterar = bancoDados.iterator();
        Usuario aux;
      
      while(iterar.hasNext())
      {
          
        
        aux = iterar.next();
        
        if(aux.getNome().equals(nome))
        {
            return true;
        }
      }  
            return false;
    }
        
    public void alterarProntuario(int op, String nome,String atualizacao){
        
        Iterator<Prontuario> iterar = bancoProntuarios.iterator();
        Prontuario aux;
        Prontuario pront = null;
      while(iterar.hasNext())
      {
          
        aux = iterar.next();
        
        if(aux.getNome().equals(nome))
        {
            
           pront = aux;
            break;
        }
      }  
     
        switch(op){
            case 1:
            {
               pront.AdicionarExames(atualizacao);
                
               break;
            }
            
            case 2:
            {
                pront.AtualizarSintomas(nome);
                break;
            }
            
            case 3:
            {
                pront.AtualizarTratamento(atualizacao);
                break;
            }
        }       
    }  
    
    
    public void criarProntuario(String nome){
        
        Iterator<Usuario> iterar = bancoDados.iterator();
        Usuario aux;
      
      while(iterar.hasNext())
      {
          
        aux = iterar.next();
        
        if(aux.getNome().equals(nome)!=false)
        {
            Prontuario pront = new Prontuario(nome);
            bancoProntuarios.add(pront);
        }
      }  
           
    }
    
    public Prontuario retornarProntuario(String nome){
        
         Iterator<Prontuario> iterar = bancoProntuarios.iterator();
        Prontuario aux;
       
      while(iterar.hasNext())
      {
          
        aux = iterar.next();
        
        if(aux.getNome().equals(nome))
        {
           return aux;
          
        }
      }
      
      return null;
    }
        
        
    
    
    
}
