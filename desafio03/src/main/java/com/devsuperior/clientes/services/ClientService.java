package com.devsuperior.clientes.services;

import com.devsuperior.clientes.dto.ClientDTO;
import com.devsuperior.clientes.entities.Client;
import com.devsuperior.clientes.repositories.ClientRepository;
import com.devsuperior.clientes.services.exceptions.DatabaseException;
import com.devsuperior.clientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(client -> new ClientDTO(client));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client clientEntity = new Client();
        this.copyDtoToEntity(clientEntity, clientDTO);
        clientEntity = clientRepository.save(clientEntity);
        return new ClientDTO(clientEntity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client clientEntity = clientRepository.getReferenceById(id);
            this.copyDtoToEntity(clientEntity, clientDTO);
            clientEntity = clientRepository.save(clientEntity);
            return new ClientDTO(clientEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {   // Não está utilizando, mantive para meu arquivo/consulta posterior.
            throw new DatabaseException("Não é permitido eliminar cliente que já foi referenciado em outras tabelas.");
        }
    }

    private void copyDtoToEntity(Client clientEntity, ClientDTO clientDTO) {
        clientEntity.setName(clientDTO.getName());
        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setIncome(clientDTO.getIncome());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setChildren(clientDTO.getChildren());
    }
}
