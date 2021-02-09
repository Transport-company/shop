package com.training.shop.service.Impl;

import com.training.shop.service.ItemInfo;
import lombok.Data;


@Data
public class ItemInfoImpl implements ItemInfo {

    private String name;
    private Float price;

}
