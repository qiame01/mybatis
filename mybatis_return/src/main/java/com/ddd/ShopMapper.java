package com.ddd;

import com.uuu.Shop;

import java.util.List;

//@Mapper
public interface ShopMapper {

    Shop getShop();

    List<Shop> getClerksJoin();

    Shop getClerksLazy();

    Shop getClerksEager();

}
