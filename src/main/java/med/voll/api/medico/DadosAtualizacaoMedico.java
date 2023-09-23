package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
/*Utilizo o ID para saber o que estou alterando*/
/*aqui no lugar do endereço, eu posso e não posso usar meu DTO DadosEndereco -> Pois as regras permanecem e agora eu quero não ter
* regras de obrigatóriedade. Como na minha regra de negocio não diz que algo do endeço não seja obrigatorio, eu vou usar
* o DTO DadosEndereco que ja temos*/
public record DadosAtualizacaoMedico(
        /*NotNull pq não é uma string, NotBlank somente para string. Passo ele como obriga*/
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
