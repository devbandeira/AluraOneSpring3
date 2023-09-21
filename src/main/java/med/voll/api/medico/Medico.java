package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

/*Entidade JPA para persistir o dados no DB*/
/*Parecido com o RECORD, são os mesmos atributos declarados la no DTO, mas aqui é uma entidade JPA. São
* duas coisas distintas*/

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")/*gera o rashcode em cima do ID e n de todos*/
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    /*
    essa anotacao para não criar uma tabela no DB e cria relacionamentos. No DB eles ficam em classes separados
    *mas no DB ele considera os campos da classe endereco fazem parte da tabela de Medicos, para funcionar
    * la na classe endereco deve ter a anotacao @Embeddeble tbm
     */
    @Embedded
    private Endereco endereco;


}
