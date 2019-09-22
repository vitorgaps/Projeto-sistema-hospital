package Controle;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable {
    
    private String nome;
    private int horarioConsulta; //Se consulta marcada, horario da mesma;
    private String especialista; //Especialidade médica do médico que irá atende-lo, depedente da cdescrição do problema;
    private boolean consultado = false; //Define se o paciente já foi ou não atendido;
    private Prontuario prontuario;
    
    public Paciente(String nome,String senha) {        
        super(nome,senha);        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorarioConsulta(int horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public void setConsultado(boolean consultado) {
        this.consultado = consultado;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    
    public Prontuario getProntuario() {
        return prontuario;
    }    

    public int getHorarioConsulta() {
        return horarioConsulta;
    }

    public String getEspecialista() {
        return especialista;
    }

    public boolean isConsultado() {
        return consultado;
    }    
    
    public boolean consultar(){        
        this.consultado = true;        
        return true;
    }
    

    public boolean avaliarMedico(float nota, Medico medico){        
        if(consultado){
            medico.avaliarMedico(nota);
            return true;
        }        
        else 
         return false;            
    }    
}
