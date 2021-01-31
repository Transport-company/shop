package com.training.shop;

public interface Urls {

    String ROOT = "";

    interface ParcelInfo {
        String PART = "info";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = ParcelInfo.FULL + "/" + PART;
        }
    }
}
