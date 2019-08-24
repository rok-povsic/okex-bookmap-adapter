package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeSpotAccountInitialResponse;


public class SubscribeSpotAccountInitialResponseDecoder
  extends AbstractDecoder<SubscribeSpotAccountInitialResponse> {

	public SubscribeSpotAccountInitialResponseDecoder() {
		super(SubscribeSpotAccountInitialResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("\"event\":\"subscribe\",\"channel\":\"")&&arg0.contains("spot/account:");
        return contains;
	}

}
