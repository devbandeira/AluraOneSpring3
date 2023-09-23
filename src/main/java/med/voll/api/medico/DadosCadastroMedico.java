package med.voll.api.medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        //@NotNull/*Verifica somente se não é null*/
        @NotBlank/*verifica se não é null e se está vazio*/
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")/*Passa uma expressao regular para restringir a qnt de numero \\d - sao digitos {4,6} de 4 a 6 digitos*/
        String crm,
        @NotNull/*@NotNull porque @NotBlank é somente para String*/
        Especialidade especialidade,
        @NotNull/*Dadosendereco tbm não pode ser null, mas ele proprio tem suas validações por ser outro DTO. Então
        boto anotação chamada @Valid "O bean, vc ta validando meu DadosEndereco, mas dentro dele tem suas proprias
        validações"*/
        DadosEndereco endereco) {


}
