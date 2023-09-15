package com.item.itemservice.service;

import com.item.itemservice.domain.Item;
import com.item.itemservice.mapper.ItemMapper;
import com.item.itemservice.model.ItemRequestDto;
import com.item.itemservice.repository.ItemRepository;
import com.item.itemservice.service.publisher.ItemPublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    private final ItemPublisherService itemPublisherService;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper, ItemPublisherService itemPublisherService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.itemPublisherService = itemPublisherService;
    }

    @Override
    public Item createItem(ItemRequestDto itemRequestDto) {
        log.info("Create-Item Service Started");
        Item item = itemMapper.itemRequestDtoToItem(itemRequestDto);
        itemRepository.save(item);
        log.info(String.format("Item Created Success with ID:%s",item.getId()));
        itemPublisherService.publish(item);
        return item;
    }

    @Override
    public Item getItem(int id) {
        log.info("Get-Item Service Started");

        Item item = itemRepository.findById(id);
        if (item==null){
            log.error(String.format("Item Not Found with ID:%s",id));
        }
        log.info(String.format("Item Founded Success:%s",id));
        return item;
    }

    @Override
    public List<Item> getItems() {
        log.info("List-Item Service Started");

        return itemRepository.findAll();
    }
}
