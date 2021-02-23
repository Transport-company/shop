package com.training.shop;

public interface Urls {

    String ROOT = "";

    interface Cart {
        String PART = "cart";
        String FULL = ROOT + "/" + PART;

        interface Create {
            String PART = "add";
            String FULL = ROOT + "/" + PART;

            interface Id {
                String PART = "{id}";
                String FULL = Cart.FULL + "/" + PART;
            }
        }

        interface Delete {
            String PART = "remove";
            String FULL = ROOT + "/" + PART;

            interface Id {
                String PART = "{id}";
                String FULL = Cart.FULL + "/" + PART;
            }
        }

        interface GetList {
            String PART = "getCart";
            String FULL = ROOT + "/" + PART;

            interface Id {
                String PART = "{id}";
                String FULL = Cart.FULL + "/" + PART;
            }
        }

        interface Id {
            String PART = "{id}";
            String FULL = Cart.FULL + "/" + PART;
        }
    }

    interface Delivery{
        String PART = "delivery";
        String FULL = ROOT + "/" + PART;
    }
}
