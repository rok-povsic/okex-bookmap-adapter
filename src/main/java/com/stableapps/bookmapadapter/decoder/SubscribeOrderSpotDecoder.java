package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeOrderSpot;


public class SubscribeOrderSpotDecoder
  extends AbstractDecoder<SubscribeOrderSpot> {

	public SubscribeOrderSpotDecoder() {
		super(SubscribeOrderSpot.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("table\":\"spot/order\",\"data\":[{\"client_oid\":");
        return contains;
	}

}
