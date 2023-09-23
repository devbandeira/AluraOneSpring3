package med.voll.api.medico;

/*Aqui no DTO ponho somente os campos que quero devolver para o frontend*/
public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico){
     /*Agora temos que chamar o proprio construtor do RECORD.
     * Podemos ter varios construtores aqui nesse RECORD mas temos que chamar o construtor principal*/
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
    /*Feito esse nosso construtor que a partir de Medico ele preenche as informações do construtor desse record aqui
    * DadosListagemMedico*/
}
