package com.item.itemservice.mapper;

import com.item.itemservice.domain.Item;
import com.item.itemservice.model.ItemRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item itemRequestDtoToItem(ItemRequestDto itemRequestDto);
}
