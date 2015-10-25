package Model;

import com.squareup.otto.Bus;


public final class BUS {
    private static final Bus bus= new Bus();
    public static Bus  getInstance(){

        return bus;
    }
    private BUS(){

    }

}
