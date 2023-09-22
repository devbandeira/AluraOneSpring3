package med.voll.api.controller;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    /*
    Injeção de dependencia -> Você quem vai instanciar pra mim, SpringBoot, já que é uma interfaceRepository
    * e o springboot conhece, então vc consegue criar esse objeto e passar aqui para o REpository automaticamente
    */
    @Autowired/*Injeção de dependencia*/
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        /*Então aqui dentro do método Cadastrar do controller eu uso o método do repository*/
        /*Preciso passar um obj do tipo médico, mas aqui o cadastrar não recebe um obj do tipo Medico, recebemos
        * o DTO representado pelo nosso RECORD.
        * Então teremos que fazer uma conversão, recebo um DTO e transformo para uma entidade JPA Medico
        * */
        repository.save(new Medico(dados));/*Id NULL, quem gera é o DB.*/
        /*Ao inves de passar repository.save(new Medico(null,dados.nome(), dados.email(), dados.crm(), new Endereco()))
        *
        * Crio um construtor na Classe MEDICO, para deixar melhor a visualização...
        * Passo somente o DADOS e faço essa construção dentro da propria entidade Medico. E passo somente
        * new Medico(dados) que fica mais limpa nossa entidade. Por então um construtor que recebe o tipo dados*/

        System.out.println(dados);
    }

}
