package com.stableapps.okcoin;

import com.stableapps.bookmapadapter.client.Connector;
import com.stableapps.bookmapadapter.model.rest.InstrumentSpot;
import com.stableapps.bookmapadapter.provider.RealTimeProvider;
import com.stableapps.bookmapadapter.util.Utils;
import com.stableapps.bookmapadapter.util.Constants.Market;

import velox.api.layer1.common.Log;
import velox.api.layer1.data.SubscribeInfo;

public class OkcoinRealTimeProvider extends RealTimeProvider {

    public OkcoinRealTimeProvider(String exchange, String wsPortNumber, String wsLink) {
        super(exchange, wsPortNumber, wsLink);
    }

    @Override
    protected void getInstruments() {
        try {
            String spotContent = Connector.getServerResponse(Utils.getMarketInstruments(Market.spot, exchange));
            InstrumentSpot[] spots = objectMapper.readValue(spotContent, InstrumentSpot[].class);
            for (InstrumentSpot spot : spots) {
                knownInstruments.add(new SubscribeInfo(spot.getInstrumentId(), "", "spot"));
                genericInstruments.put("spot@" + spot.getInstrumentId(), spot);
            }
        } catch (Exception e) {
            Log.warn("Spot instruments have not been loaded", e);
        }
    }

}
