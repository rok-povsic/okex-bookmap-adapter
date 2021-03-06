package com.stableapps.okex;

import java.io.IOException;

import com.stableapps.bookmapadapter.client.Connector;
import com.stableapps.bookmapadapter.model.rest.InstrumentFutures;
import com.stableapps.bookmapadapter.model.rest.InstrumentSpot;
import com.stableapps.bookmapadapter.provider.RealTimeTradingProvider;
import com.stableapps.bookmapadapter.util.Utils;
import com.stableapps.bookmapadapter.util.Constants.Market;

import velox.api.layer1.data.SubscribeInfo;

public class OkexRealTimeTradingProvider extends RealTimeTradingProvider {

    public OkexRealTimeTradingProvider(String exchange, String wsPortNumber, String wsLink) {
        super(exchange, wsPortNumber, wsLink);
    }

    /* TODO: this method is copied from OkexRealTimeProvider
     * because the class already extends RealTimeTradingProvider */
    @Override
    protected void getInstruments() {
        String futuresContent = Connector.getServerResponse(Utils.getMarketInstruments(Market.futures, super.exchange));
        String spotContent = Connector.getServerResponse(Utils.getMarketInstruments(Market.spot, super.exchange));
        
        try {
            InstrumentFutures[] futures = objectMapper.readValue(futuresContent, InstrumentFutures[].class);
            
            for (InstrumentFutures future : futures) {
                knownInstruments.add(new SubscribeInfo(future.getInstrumentId(), "", "futures"));//temp 0.0
                genericInstruments.put("futures@" + future.getInstrumentId(), future);
            }
            InstrumentSpot[] spots = objectMapper.readValue(spotContent, InstrumentSpot[].class);
            for (InstrumentSpot spot : spots) {
                knownInstruments.add(new SubscribeInfo(spot.getInstrumentId(), "", "spot"));
                genericInstruments.put("spot@" + spot.getInstrumentId(), spot);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
