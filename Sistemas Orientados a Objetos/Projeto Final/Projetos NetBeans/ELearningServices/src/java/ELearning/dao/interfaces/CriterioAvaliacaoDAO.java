/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.CriterioAvaliacao;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface CriterioAvaliacaoDAO {

    public boolean cadastrar(CriterioAvaliacao newCriterion);

    public List<CriterioAvaliacao> procurar(CriterioAvaliacao criterion);

    public CriterioAvaliacao editar(CriterioAvaliacao oldCriterion, CriterioAvaliacao newCriterion);

    public boolean deletar(CriterioAvaliacao criterion);
    
}
