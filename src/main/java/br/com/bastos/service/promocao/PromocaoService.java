package br.com.bastos.service.promocao;

import br.com.bastos.rh.ValidacaoException;
import br.com.bastos.rh.model.Cargo;
import br.com.bastos.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida) {
        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }
        if (!metaBatida) {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }
}
