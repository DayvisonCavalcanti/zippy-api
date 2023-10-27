package br.com.zippydeliveryapi.model.produto;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// import br.com.ifpe.oxefood.util.exception.ProdutoException;



@Service
public class ProdutoService {

   @Autowired
   private ProdutoRepository repository;

   @jakarta.transaction.Transactional
   public Produto save(Produto produto) {
        // if (produto.getValorUnitario() < 10) {
        //         throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        //     }

       produto.setHabilitado(Boolean.TRUE);
       produto.setVersao(1L);
       produto.setDataCriacao(LocalDate.now());
       return repository.save(produto);
   }

   
   public List<Produto> findAll() {
  
    return repository.findAll();
}

public Produto findById(Long id) {

    return repository.findById(id).get();
}

@Transactional
public void update(Long id, Produto produtoAlterado) {

    Produto produto = repository.findById(id).get();
    // produto.setCategoria(produtoAlterado.getCategoria());

    produto.setDescricao(produtoAlterado.getDescricao());
    produto.setTitulo(produtoAlterado.getTitulo());
    produto.setImagem(produtoAlterado.getImagem());
    produto.setPreco(produtoAlterado.getPreco());
    produto.setDisponibilidade(produtoAlterado.getDisponibilidade());
    produto.setVersao(produto.getVersao() + 1);
    repository.save(produto);
}
  
  @Transactional
  public void delete(Long id) {

      Produto produto = repository.findById(id).get();
      produto.setHabilitado(Boolean.FALSE);
      produto.setVersao(produto.getVersao() + 1);

      repository.save(produto);
  }

  public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

    List<Produto> listaProdutos = repository.findAll();

    // if ((codigo != null && !"".equals(codigo)) &&
    //     (titulo == null || "".equals(titulo)) &&
    //     (idCategoria == null)) {
    //         listaProdutos = repository.consultarPorCodigo(codigo);
    // } else if (
    //     (codigo == null || "".equals(codigo)) &&
    //     (titulo != null && !"".equals(titulo)) &&
    //     (idCategoria == null)) {    
    //         listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
    // } else if (
    //     (codigo == null || "".equals(codigo)) &&
    //     (titulo == null || "".equals(titulo)) &&
    //     (idCategoria != null)) {
    //         listaProdutos = repository.consultarPorCategoria(idCategoria); 
    // } else if (
    //     (codigo == null || "".equals(codigo)) &&
    //     (titulo != null && !"".equals(titulo)) &&
    //     (idCategoria != null)) {
    //         listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria); 
    // }
    // else if (
    //     (codigo != null || !"".equals(codigo)) &&
    //     (titulo != null && !"".equals(titulo)) &&
    //     (idCategoria != null)) {
    //         listaProdutos = repository.consultarPorTituloECategoriaECodigo(titulo, idCategoria, codigo); 
    // }

    return listaProdutos;
}


}
