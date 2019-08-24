package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.SubscribeFuturesAccountResponse;


public class SubscribeFuturesAccountResponseDecoder
  extends AbstractDecoder<SubscribeFuturesAccountResponse> {

	public SubscribeFuturesAccountResponseDecoder() {
		super(SubscribeFuturesAccountResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
        boolean contains = arg0.contains("\"table\":\"futures/account\",\"data\":");
        return contains;
	}

}
