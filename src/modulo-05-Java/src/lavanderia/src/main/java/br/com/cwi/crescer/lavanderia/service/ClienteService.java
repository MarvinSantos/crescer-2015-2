package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.dao.CidadeDao;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDao clienteDao;
    private CidadeDao cidadeDao;

    @Autowired
    public ClienteService(ClienteDao clienteDAO, CidadeDao cidadeDao) {
        super();
        this.clienteDao = clienteDAO;
        this.cidadeDao = cidadeDao;
    }

    public String buscarNome(Long id) {
        String nome;
        Cliente cliente;

        cliente = clienteDao.findById(id);
        if(cliente != null){
            nome = cliente.getNome();
        }else{
            return "cliente não encontrado";
        }

        return nome.toUpperCase();
    }

    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteDao.findById(id);
        return ClienteMapper.toDTO(cliente);
    }

    public void atualizar(ClienteDTO dto) {

        Cliente entity = clienteDao.findById(dto.getId());

        ClienteMapper.merge(dto, entity);

        entity.setCidade(cidadeDao.findById(dto.getIdCidade()));

        clienteDao.save(entity);
    }

    public List<ClienteResumoDTO> listarClientesAtivos() {

        List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

}
