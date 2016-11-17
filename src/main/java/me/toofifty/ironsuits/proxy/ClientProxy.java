package me.toofifty.ironsuits.proxy;

import me.toofifty.ironsuits.init.BlockInit;
import me.toofifty.ironsuits.init.ItemInit;

public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        ItemInit.registerRenders();
        BlockInit.registerRenders();
    }

}
