package com.whiteStudio.Ecommerce_Platform_Spring.enums;

public enum OrderStatus {
    /* o java gera no enum uma numeração semelhante a arrays

    Digamos que eu adicione um novo estado entre PAID e SHIPPED, vai quebrar o banco
    Portanto, é bom "setarmos" valores nessa lista, pra que se algum for adicionado, o banco não quebre do nada

    */

    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code;

    OrderStatus(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return this.code;
    }

    // metodozinho pra converter de numero pra enum
    public static OrderStatus valueOf(Integer num)
    {
        for(OrderStatus value: OrderStatus.values())
        {
            if(value.getCode() == num)
            {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
