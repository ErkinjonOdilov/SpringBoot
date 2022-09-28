package com.example.forportfoliyo.service;

import com.example.forportfoliyo.entity.Item;
import com.example.forportfoliyo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item item){
        Item save = itemRepository.save(item);
        return save;
    }

    public List<Item> getAll(){
        List<Item> all = itemRepository.findAll();
        return all;
    }
}
