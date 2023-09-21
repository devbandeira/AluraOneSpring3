package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  Endereco endereco) {
}
