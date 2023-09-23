package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.numero();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarEnderecoMedico(DadosEndereco endereco) {/*Montando como vai ocorrer a atualização, passando
    o DTO de endereço que vai vir do front com os dados que serão usados para atualizar o OBJETO*/
        if(endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if(endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if(endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if(endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if(endereco.numero() != null){
            this.complemento = endereco.numero();
        }
        if(endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if(endereco.uf() != null){
            this.uf = endereco.uf();
        }
    }
}
