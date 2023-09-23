package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoesMedico(DadosAtualizacaoMedico dados) {
        /*Como os dados são opcionais, se ele não for preenchido o SpringBoot trata eles como null, então devo usar o IF*/
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            /*Fazer a mesma estrategia na classe Endereco, onde crio este método, passo o DTO vindo do FRONT com os dados
            * atuais e atualizo os dados*/
            this.endereco.atualizarEnderecoMedico(dados.endereco());
        }


    }
}
