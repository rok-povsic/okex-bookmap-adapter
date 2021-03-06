package com.stableapps.bookmapadapter.provider;

import velox.api.layer1.annotations.Layer1ApiVersion;
import velox.api.layer1.annotations.Layer1ApiVersionValue;
import velox.api.layer1.common.ListenableHelper;
import velox.api.layer1.common.Log;
import velox.api.layer1.data.Layer1ApiProviderSupportedFeatures;
import velox.api.layer1.data.LoginData;
import velox.api.layer1.data.SubscribeInfo;
import velox.api.layer1.layers.Layer1ApiRelay;


@Layer1ApiVersion(Layer1ApiVersionValue.VERSION2)
public class RelayProvider extends Layer1ApiRelay {

    Thread providerThread;

    public RelayProvider(String exchange, String wsPortNumber, String wsLink) {
        super(new RealTimeProvider(exchange, wsPortNumber, wsLink), false);
        Log.info("Relay " + this.hashCode());
    }

    @Override
    public Layer1ApiProviderSupportedFeatures getSupportedFeatures() {
        return provider.getSupportedFeatures();
    }
    
    @Override
    public void login(LoginData loginData) {
        providerThread = new Thread(() -> provider.login(loginData));
        providerThread.setName("-> " + provider.getClass().getSimpleName());
        providerThread.start();
    }
    
    
    @Override
    public void close() {
        super.close();
        ListenableHelper.removeListeners(provider, this);
        provider.close();
        providerThread.interrupt();
    }
    
    @Override
    public void subscribe(SubscribeInfo subscribeInfo) {
        Log.info("Relay " + this.hashCode());
        Log.info("provider " + provider.hashCode());
        provider.subscribe(subscribeInfo);
    }
}
