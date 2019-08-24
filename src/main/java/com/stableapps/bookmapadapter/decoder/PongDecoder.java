package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.Pong;

/**
 *
 * @author aris
 */
public class PongDecoder extends AbstractDecoder<Pong>{

	public PongDecoder() {
		super(Pong.class);
	}


	@Override
	public boolean willDecode(String arg0) {
		return arg0.startsWith("{\"event\":\"pong\"");
	}

	
}
