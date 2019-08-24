package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeFuturesPositionInitialResponse;


public class SubscribePositionFuturesInitialResponseDecoder
  extends AbstractDecoder<SubscribeFuturesPositionInitialResponse> {

	public SubscribePositionFuturesInitialResponseDecoder() {
		super(SubscribeFuturesPositionInitialResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("\"event\":\"subscribe\",\"channel\":\"futures/position:");
        return contains;
	}

}
