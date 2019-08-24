/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stableapps.bookmapadapter.decoder;

import com.stableapps.bookmapadapter.model.UnsubscribeResponse;

/**
 *
 * @author aris
 */
public class UnsubscribeResponseDecoder 
	extends AbstractDecoder<UnsubscribeResponse> {

	public UnsubscribeResponseDecoder() {
		super(UnsubscribeResponse.class);
	}

	@Override
	public boolean willDecode(String arg0) {
		return (arg0.contains("\"event\":\"unsubscribe\",\"channel\":"));
	}
	
}
