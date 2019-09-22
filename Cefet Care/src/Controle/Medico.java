package Controle;

import java.io.Serializable;
import java.util.*;

public class Medico extends Usuario implements Serializable{    
    
    private Map<Integer,Paciente> pacientes = new HashMap<>();
    private String especialidade;
    private int avaliacao;
    private int qtd_avaliacoes;
    
    
    
    public Medico(String nome,String senha) {
        
        super(nome,senha);
        
        this.qtd_avaliacoes = 0;
        this.avaliacao = 0;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Map<Integer, Paciente> getPacientes() {
        return pacientes;
    }

 
    public String getEspecialidade() {
        return especialidade;
    }

    public int getAvaliacao() {
        return avaliacao;
    }
    
    public boolean adicionarPaciente(Paciente novoPaciente,int horario){
        
        if(pacientes.containsKey(horario))
        {
            return false;
        }
        
        else 
            pacientes.put(horario,novoPaciente);
            
        return true;
   
    }
    
    public boolean cancelarConsultaPaciente(int horario){        
      
       if(pacientes.remove(horario)!=null)
       return true;
      
      return false;       
    }
    
    public boolean avaliarMedico(float nota) {
       
        avaliacao = avaliacao*qtd_avaliacoes;
        qtd_avaliacoes++;
        avaliacao+= nota;
        avaliacao = avaliacao/qtd_avaliacoes;
        
        return true;
    }
    
    public String consultarDisponibilidade(){
        
        String horariosDisponiveis = null;
        
        for(int i=8,j=0; i<17;i++)
        {
            if(pacientes.containsKey(i)!=true)
            {
                if(j==0)
                    horariosDisponiveis = " ";
            
                horariosDisponiveis = horariosDisponiveis + i + ":00\n";
                
                j++;
            } 
        }
        
        if(horariosDisponiveis == null)
            horariosDisponiveis = "Médico sem horários disponíveis";        
        else
            horariosDisponiveis = String.format("Horarios disponíveis: \n" + horariosDisponiveis);
        return horariosDisponiveis;
    }
    
      
    
    public boolean consultarHorario(int horario){        
        return pacientes.containsKey(horario);   
    }
}
