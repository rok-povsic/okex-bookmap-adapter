package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeFuturesPositionResponse;


public class SubscribePositionFuturesDecoder
  extends AbstractDecoder<SubscribeFuturesPositionResponse> {

	public SubscribePositionFuturesDecoder() {
		super(SubscribeFuturesPositionResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("\"table\":\"futures/position\",\"data\":[");
        return contains;
	}

}
