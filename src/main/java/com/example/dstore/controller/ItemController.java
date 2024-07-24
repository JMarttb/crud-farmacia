package com.example.dstore.controller;

import com.example.dstore.entities.Item;
import com.example.dstore.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemServices itemServices;

    @GetMapping
    public List<Item> getAllItems() {
        return itemServices.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id){
        return  itemServices.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemServices.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        return itemServices.updateItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        itemServices.deleteItem(id);

    }

}
