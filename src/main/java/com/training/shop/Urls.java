package com.training.shop;

public interface Urls {

    String ROOT = "";

    interface OrderInfo {
        String PART = "order";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = OrderInfo.FULL + "/" + PART;
        }
    }
}
