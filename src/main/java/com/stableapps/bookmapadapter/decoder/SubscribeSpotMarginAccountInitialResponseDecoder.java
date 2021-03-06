package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeSpotMarginAccountInitialResponse;


public class SubscribeSpotMarginAccountInitialResponseDecoder
  extends AbstractDecoder<SubscribeSpotMarginAccountInitialResponse> {

	public SubscribeSpotMarginAccountInitialResponseDecoder() {
		super(SubscribeSpotMarginAccountInitialResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("\"event\":\"subscribe\",\"channel\":\"spot/margin_account:");
        return contains;
	}

}
