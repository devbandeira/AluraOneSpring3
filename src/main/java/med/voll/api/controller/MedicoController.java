package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){/*Passando a class Pageable do Spring e vamos mudar
    o tipo List<> para uma classe do proprio Springboot chamada Page*/
        /*No repository existe uma sobrecarga do findAll que recebe um Pageble como parametro*/
        /*Vamos ter que tirar o stream, porque o findall devolve um Page e o PAGE ja tem o método MAP diretamente e remover
        * o toList() no final da fn
        * Antigo -> return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
        * chamando o MAP ele já faz a conversão e devolve um PAGE do DTO DadosListagemMedico automaticamente*/
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
