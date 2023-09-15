package com.item.itemservice.controller;

import com.item.itemservice.domain.Item;
import com.item.itemservice.model.ItemRequestDto;
import com.item.itemservice.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public Item createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping("")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @PostMapping("/{id}")
    public Item getItem(@PathVariable("id") int id){
        return itemService.getItem(id);
    }
}
