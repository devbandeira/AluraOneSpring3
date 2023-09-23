package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    /*não posos usar @RequestBody @Valid DadosCadastroMedico dados, pois os dados desse DTO são todos obrigatorios
    * e para atualizar eles não são obrigatorios, posso att um, varios ou nenhum.
    * Então vamos ter que criar um novo DTO para passar no lugar de DadosCadastroMedico*/
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        /*Como vamos atualizar? : Precisamos primeiro trazer os dados atuais do BD e sobrebrescever de acordo com o novo
        * DTO.*/
        var medico = repository.getReferenceById(dados.id());/*Buscar a referencia pelo ID que esta dentro do nosso DTO recebido*/
        medico.atualizarInformacoesMedico(dados);/*Qnd chamo aqui, passo o DADO novo que vai ser usado para att,
         la na classe Medico e Endereco*/

        /*Como falo para ele att no BD, não precisa fazer nada, já é automatico, esse trecho de codigo vai rodar dentro
        * de uma TRANSAÇÃO (TRANSACTIONAL) e ai a JPA se vc carrega uma entidade do BD e muda algum ATRIBUTO, a JPA
        * Já faz o UPDATE automaticamente.*/
    }
}
/*
    Para atualizar os dados precisamos:
*Disparo uma requisição do tipo PUT.
Levo o JSON com dados que eu quero atualizar do FRONT pro meu BACKEND, junto com o ID para identificar o obj vai ser att

E no nosso controller aqui, para atualizar.
Carregamos o registro atual com base no ID enviado
Sobrescreve os atributos baseados nos novos campos chegados no DTO
e não precisa chamar nada do REPOSITORY aqui a JPA Irá att automaticamente.

*/
