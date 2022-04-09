package br.com.bastos.rh.service;

import br.com.bastos.rh.ValidacaoException;
import br.com.bastos.rh.model.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.5")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
