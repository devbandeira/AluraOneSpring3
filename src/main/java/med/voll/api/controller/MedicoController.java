package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
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

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    /*Posso enviar por URL os parametros de SIZE&PAGE&SORT, mas posso mudar o padrão do PAGEABLE aqui
    * por padrão ele tem size 20, etc. Se for informado o SIZE na url esse padrão, se comporta conforme url mandar.
    * Padrão Spring: Size = 20, PAGE = 0, SORT conforme foi inserido no db*/
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
/*Posso mudar os nomes SIZE - PAGE - etc para portugues no application.properties*/
/*se eu abrir o terminal aqui no intelij, vejo que não mostra qual SQL foi executado para essa query. Posso ativar
mudando a configuração no aplication.properties
* */