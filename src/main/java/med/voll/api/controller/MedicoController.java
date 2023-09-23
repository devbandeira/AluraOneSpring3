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

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoesMedico(dados);/*chamando o método da classe MEDICO*/
    }

    /*Como aqui vamos fazer diferente do método atualizar, o ID vai vir pela URL, então coloco alguns parametros no
    * @DeleteMapping(), passando um "PARAMETRO DINAMICO" usando {} chaves*/
    /*Para capturar esse ID dinamico que chega através da URL, basta eu receber como parametro no meu método excluir*/
    @DeleteMapping("/{id}")
    @Transactional/*como fazer uma escrita, preciso do transactional*/
    public void excluir(@PathVariable Long id){/*Deixando somente "Long id" o spring n entende que o id vem da URL, então uso
    @PathVariavle, dizendo que é o ID da URL.*/
        repository.deleteById(id);/*chamo o repository para conecatar no meu DB e fazer minha consulta passando id*/

    }
}
