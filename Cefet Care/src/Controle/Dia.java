package Controle;

import java.io.Serializable;
import java.util.*;

public class Dia implements Serializable {
    ArrayList<Medico> medicos = new ArrayList<>(); 
    

    public boolean adicionarMedico(Medico medico){
     if(medicos.size()<=5)
     {
        medicos.add(medico);
        return true;  
     }
     return false;
    }
    
    public boolean removerMedico(Medico medico){
        return medicos.remove(medico);
    }
    
    public boolean removerHorario(String nome,int horario){
      
      Iterator<Medico> iterar = medicos.iterator();
      Medico aux;
      
      while(iterar.hasNext())
      {
        
        aux = iterar.next();
        if(aux.getNome().equals(nome))
        {
            if(aux.cancelarConsultaPaciente(horario))
                return true;
            
        }
       
      }      
        
        return false;
    }
    
    public String ConsultarHorios(String especialidade){
       Iterator<Medico> iterar =medicos.iterator();
      Medico aux;
      String horarios = null;
      int i = 0;
      
      while(iterar.hasNext())
      {        
          
        aux = iterar.next();
        if(aux.getEspecialidade().equals(especialidade))
        {
            if(i==0)
                horarios = "-";
            
            horarios = horarios + aux.getNome() + ": \n" + aux.consultarDisponibilidade();
          
            i++;
            //Comando de printar da janela
        }
      }   
      
      return horarios;
    }

    boolean consultarHorario(int horario, String especialidade) {
      Iterator<Medico> iterar =medicos.iterator();
      Medico aux;
      
      while(iterar.hasNext())
      {
        
        aux = iterar.next();
        if(aux.getEspecialidade().equals(especialidade) && aux.consultarHorario(horario))
        {
            return true;
        }
      }      
      return false;        
    }    

    public Medico procurarMedico(String nome) {
        
      Iterator<Medico> iterar = medicos.iterator();
      Medico aux;
      
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
    
    public boolean adicionarPaciente(String nomeMedico,Paciente paciente){
        
      Iterator<Medico> iterar = medicos.iterator();
      Medico aux;
      
      while(iterar.hasNext())
      {
        
        aux = iterar.next();
        if(aux.getNome().equals(nomeMedico))
        {
            return aux.adicionarPaciente(paciente, paciente.getHorarioConsulta());
        }
      }  
            return false;
    }
        
    public boolean trabalha(String nomeMedico){
        
      Iterator<Medico> iterar = medicos.iterator();
      Medico aux;
      
      while(iterar.hasNext())
      {
        
        aux = iterar.next();
        if(aux.getNome().equals(nomeMedico))
        {
            System.out.println("tem");
            return true;
        }
      }  
            return false;
        
    }
}

