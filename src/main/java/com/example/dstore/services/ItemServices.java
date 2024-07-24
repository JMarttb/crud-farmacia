package com.example.dstore.services;  // Pacote onde a classe está localizada

import com.example.dstore.entities.Item;
import com.example.dstore.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;  // Importa a classe List para manipular listas
import java.util.Optional;  // Importa a classe Optional para manipular valores que podem ou não estar presentes

@Service  // Marca a classe como um serviço do Spring, permitindo a injeção de dependências
public class ItemServices {

    @Autowired  // Injeta automaticamente a implementação do ItemRepository
    private ItemRepository itemRepository;  // Declaração do repositório de itens

    // Método para obter todos os itens do repositório
    public List<Item> getAllItems() {
        return itemRepository.findAll();  // Retorna a lista de todos os itens
    }

    // Método para obter um item pelo ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);  // Retorna um Optional contendo o item, se encontrado
    }

    // Método para criar um novo item
    public Item createItem(Item item) {
        return itemRepository.save(item);  // Salva o novo item no repositório e o retorna
    }

    // Método para atualizar um item existente
    public Item updateItem(Long id, Item itemDetails) {
        // Encontra o item pelo ID ou lança uma exceção se não for encontrado
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

        // Atualiza as propriedades do item com os detalhes fornecidos
        item.setName(itemDetails.getName());  // Atualiza o nome do item
        item.setDescription(itemDetails.getDescription());  // Atualiza a descrição do item
        item.setQuantity(itemDetails.getQuantity());  // Atualiza a quantidade do item
        item.setPrice(itemDetails.getPrice());  // Atualiza o preço do item

        // Salva o item atualizado no repositório e retorna o item salvo
        return itemRepository.save(item);
    }

    // Método para deletar um item
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(item);
    }
}

