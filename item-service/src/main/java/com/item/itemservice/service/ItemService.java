package com.item.itemservice.service;

import com.item.itemservice.domain.Item;
import com.item.itemservice.model.ItemRequestDto;

import java.util.List;

public interface ItemService {

    Item createItem(ItemRequestDto itemRequestDto);

    Item getItem(int id);

    List<Item> getItems();
}
