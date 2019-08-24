/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stableapps.bookmapadapter.client;

/**
 *
 * @author aris
 */
public abstract class AbstractClient implements	Connector.MarketDepthListener,
		Connector.PositionListener,

		Connector.FuturesPositionListener,
		
		Connector.FuturesAccountListener,
		Connector.SpotAccountListener,
		Connector.TradeRecordListener,
		Connector.OrderListener,
		Connector.ConnectionListener {

}
