package chironhealth.chironskeleton.otto;

import com.squareup.otto.Bus;

/**
 * Created by SamMyxer on 10/15/15.
 */
public class BusProvider {

    private static MainThreadBus BUS;

    private BusProvider() {};

    public static Bus getInstance() {

        if(BUS == null) {
            BUS = new MainThreadBus(new Bus());
        }
        return BUS;
    }
}
