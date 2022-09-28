package com.example.forportfoliyo.web.rest;

import com.example.forportfoliyo.entity.Item;
import com.example.forportfoliyo.repository.ItemRepository;
import com.example.forportfoliyo.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemResource {

    public final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity save(@RequestBody Item item){
        Item save = itemService.save(item);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/items")
    public List<Item> getAll(){
        List<Item> all = itemService.getAll();
        return all;
    }
}
