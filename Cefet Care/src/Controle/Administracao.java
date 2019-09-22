package Controle;

import Controle.Dia;
import java.io.Serializable;
import java.util.*;

public class Administracao implements Serializable {
   Dia[] Semana = new Dia[5];
   String[] Dias = {"Segunda","Terça","Quarta","Quinta","Sexta"};

   public Administracao(){
     for(int i=0;i<5;i++)
      {
       Semana[i] = new Dia();
      }
    }
   
   private void lerArquivos(){
     //       
   }
   
   private void atualizarArquivos(){
    //
   }
   
   public boolean adicionarMedico(Medico medico,int dia){
     return Semana[dia].adicionarMedico(medico);
   }
   
   public boolean removerMedico(Medico medico,int dia){
     return Semana[dia].removerMedico(medico);
   }   
   
   public boolean cancelarHorario(int dia,String nomeMedico,int horario){
     return Semana[dia].removerHorario(nomeMedico, horario);
   }
   
   public String consultarHorario(int dia,String especialidade){
       String aux = Semana[dia].ConsultarHorios(especialidade);
       if(aux!=null)
     return aux;
     else
     return "Sem horários disponíveis";
   }
   
   public boolean consultarHorario(int dia, int horario, String especialidade){
     return Semana[dia].consultarHorario(horario,especialidade);
   }   
   
   public void alterarProntuario(int opcao,Paciente paciente,String atualizacao,String nomemedico,int dia){
       // 1: adicionar exames
       // 2: atualizar sintomas
       // 3: atualizar tratamento
     Medico medico = procurarmedico(dia,nomemedico);  
       
     
     
    // medico.alterarProntuario(opcao, paciente, atualizacao);
    }
   
  // public void avaliarMedico(float nota,Paciente paciente,String nomeMedico){
    // paciente.avaliarMedico(nota, medico);
   //}
   
   public Medico procurarmedico(int dia,String nome){
       
       return Semana[dia].procurarMedico(nome);
       
   }
   
   public boolean adicionarPaciente(Paciente paciente, int dia,String nomeMedico){
       
       return Semana[dia].adicionarPaciente(nomeMedico, paciente);
       
   }
   
   public boolean trabalha(String nomeMedico, int dia){
       
       
           return Semana[dia].trabalha(nomeMedico);
           
        
       
   }
   
   public Prontuario exibirProntuario(Paciente paciente,Medico medico){
       Prontuario prontuario = medico.getPacientes().get(paciente).getProntuario();
       //Vc pode chamar o abaixo tb
       //Prontuario prontuario = medico.exibirProntuario(paciente);       
       return prontuario;
   }
   
}