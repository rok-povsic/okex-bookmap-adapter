package com.stableapps.okex;

import com.stableapps.bookmapadapter.util.Constants;

public class OkexConstants extends Constants {

    public static final String EXCHANGE = "okex";
    public static final String ADAPTER_FULL_NAME = "OKEx2";
    public static final String ADAPTER_SHORT_NAME = "Okex2";
    public static final String WS_PORT_NUMBER = "8443";
    public static final String WS_LINK = "wss://real." + EXCHANGE + ".com:" + WS_PORT_NUMBER + "/ws/v3";
    
}
