package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){/*OBS. Minha: Como aqui para salvar ele recebe
    DadosCadastroMedico que é o record DTO, mas eu tenho que salvar minha ENTITY(ENTIDADE) Medico, crio um construtor
    na ENTITY Medico que quando for chamada "new Medico" é preechida pelos dados do DTO, conforme cada atributo que eu
    preciso*/
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
