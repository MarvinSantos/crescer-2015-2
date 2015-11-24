package br.com.cwi.crescer.lavanderia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDao;
import br.com.cwi.crescer.lavanderia.domain.Cidade;


@Service
public class CidadeService {

    private CidadeDao cidadeDao;

    @Autowired
    public CidadeService(CidadeDao cidadeDao){
        super();
        this.cidadeDao = cidadeDao;
    }

    public String buscarNome(Long id) {
        String nome;
        Cidade cidade;

        cidade = cidadeDao.findById(id);
        if(cidade != null){
            nome = cidade.getNome();
        }else{
            return "cidade não encontrada";
        }

        return nome.toUpperCase();
    }

    public List<Cidade> listar() {
        // TODO Auto-generated method stub
        return cidadeDao.listAll();
    }
}
