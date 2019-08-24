package com.stableapps.okex;

import com.stableapps.bookmapadapter.provider.RelayProvider;

import velox.api.layer0.annotations.Layer0LiveModule;
import velox.api.layer1.Layer1ApiProvider;
import velox.api.layer1.annotations.Layer1ApiVersion;
import velox.api.layer1.annotations.Layer1ApiVersionValue;
import velox.api.layer1.common.ListenableHelper;
import velox.api.layer1.common.Log;
import velox.api.layer1.data.LoginData;
import velox.api.layer1.data.UserPasswordDemoLoginData;


@Layer0LiveModule(fullName = OkexConstants.ADAPTER_FULL_NAME, shortName = OkexConstants.ADAPTER_SHORT_NAME)
@Layer1ApiVersion(Layer1ApiVersionValue.VERSION2)
public class OkexRelayProvider extends RelayProvider {

    public OkexRelayProvider() {
        super(OkexConstants.EXCHANGE, OkexConstants.WS_PORT_NUMBER, OkexConstants.WS_LINK);
        Log.info("Relay " + this.hashCode());
    }

    @Override
    public void login(LoginData loginData) {
        UserPasswordDemoLoginData userPasswordDemoLoginData = (UserPasswordDemoLoginData) loginData;
        
        if (userPasswordDemoLoginData.isDemo) {
            Layer1ApiProvider provider = new OkexRealTimeProvider(OkexConstants.EXCHANGE, OkexConstants.WS_PORT_NUMBER, OkexConstants.WS_LINK);
            setProvider(provider);
            Log.info("OkexRealtimeProvider " + provider.hashCode());
        } else {
            Layer1ApiProvider provider = new OkexRealTimeTradingProvider(OkexConstants.EXCHANGE, OkexConstants.WS_PORT_NUMBER, OkexConstants.WS_LINK);
            setProvider(provider);
            Log.info("OkexRealtimeTradingProvider " + provider.hashCode());
        }
        ListenableHelper.addListeners(provider, this);
        super.login(loginData);
    }
}