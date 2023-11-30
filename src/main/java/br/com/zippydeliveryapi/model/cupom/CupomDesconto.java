package br.com.zippydeliveryapi.model.cupom;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Where;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "CupomDesconto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CupomDesconto extends EntidadeAuditavel{

    @Column(unique = true)
    private String codigo;

    @Column(nullable = false)
    private Double percentualDesconto;

    @Column
    private Double valorDesconto;

    @Column
    private Double valorMinimoPedidoPermitido;

    @Column
    private Integer quantidadeMaximaUso;

    @Column
    private LocalDate inicioVigencia;

    @Column
    private LocalDate fimVigencia;
    
}
