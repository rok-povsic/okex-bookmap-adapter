package com.stableapps.okcoin;

import com.stableapps.bookmapadapter.util.Constants;

public class OkcoinConstants extends Constants {

    public static final String EXCHANGE = "okcoin";
    public static final String ADAPTER_FULL_NAME = "OKCOIN";
    public static final String ADAPTER_SHORT_NAME = "Okcn";
    public static final String WS_PORT_NUMBER = "8443";
    public static final String WS_LINK = "wss://real." + EXCHANGE + ".com:" + WS_PORT_NUMBER + "/ws/v3";
    
}
