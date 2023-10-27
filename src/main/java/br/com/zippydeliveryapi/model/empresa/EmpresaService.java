package br.com.zippydeliveryapi.model.empresa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public Empresa save(Empresa empresa){

        
       empresa.setHabilitado(Boolean.TRUE);
       empresa.setVersao(1L);
      empresa.setDataCriacao(LocalDate.now());
       return repository.save(empresa);
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterado) {

        Empresa empresa = repository.findById(id).get();
        empresa.setNome(empresaAlterado.getNome());
        empresa.setEmail(empresaAlterado.getEmail());
        empresa.setCnpj(empresaAlterado.getCnpj());
        empresa.setSenha(empresaAlterado.getSenha());
        empresa.setHorario(empresaAlterado.getHorario());
        empresa.setCategoria(empresaAlterado.getCategoria());
        empresa.setImg_capa(empresaAlterado.getImg_capa());
        empresa.setTempo_entrega(empresaAlterado.getTempo_entrega());
        empresa.setTaxa_frete(empresaAlterado.getTaxa_frete());
        empresa.setTelefone(empresaAlterado.getTelefone());
        empresa.setImg_perfil(empresaAlterado.getImg_perfil());
        
        
        empresa.setVersao(empresa.getVersao() + 1);
        repository.save(empresa);
    }

    public List<Empresa> findAll() {

        return repository.findAll();
    }

    public Empresa findById(Long id) {

        Optional<Empresa> consulta = repository.findById(id);

        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new EntidadeNaoEncontradaException("Empresa", id);
        }

    }

    @Transactional
    public void delete(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(Boolean.FALSE);
       
        empresa.setVersao(empresa.getVersao() + 1);

        repository.save(empresa);
    }


    

    
}
