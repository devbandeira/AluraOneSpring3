package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Especialidade;

/*Classe RECORDS ja cria todos getters/setters e construtores automaticamente e uma classe imutavel*/
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  Endereco endereco) {
}
