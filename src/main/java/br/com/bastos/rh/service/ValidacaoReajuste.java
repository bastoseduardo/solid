package br.com.bastos.rh.service;

import br.com.bastos.rh.model.Funcionario;
import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
