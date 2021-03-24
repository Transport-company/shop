package com.training.shop;

public interface Urls {

    String ROOT = "";

    interface Cart {
        String PART = "cart";
        String FULL = ROOT + "/" + PART;

        interface Create {
            String PART = "plus-position";
            String FULL = ROOT + "/" + PART;

            interface Id {
                String PART = "{id}";
                String FULL = Cart.FULL + "/" + PART;
            }
        }

        interface Delete {
            String PART = "minus-position";
            String FULL = ROOT + "/" + PART;

            interface Id {
                String PART = "{id}";
                String FULL = Cart.FULL + "/" + PART;
            }
        }

        interface GetList {
            String PART = "cart-info";
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
        String PART = "formed-delivery";
        String FULL = ROOT + "/" + PART;
    }
}
