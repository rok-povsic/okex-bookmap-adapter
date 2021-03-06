/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stableapps.bookmapadapter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 *
 * @author aris
 */
@Data
@JsonDeserialize(using = CustomSubscribeContractMarketDepthInitialResponseDeserializer.class)
public class SubscribeContractMarketDepthInitialResponse extends Message {

	public int binary;
	public String channel;
	public InitialResponse data = null;
}
