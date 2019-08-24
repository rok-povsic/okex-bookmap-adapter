package com.stableapps.okcoin;

import com.stableapps.bookmapadapter.provider.RelayProvider;

import velox.api.layer0.annotations.Layer0LiveModule;
import velox.api.layer1.Layer1ApiProvider;
import velox.api.layer1.annotations.Layer1ApiVersion;
import velox.api.layer1.annotations.Layer1ApiVersionValue;
import velox.api.layer1.common.ListenableHelper;
import velox.api.layer1.common.Log;
import velox.api.layer1.data.LoginData;
import velox.api.layer1.data.LoginFailedReason;
import velox.api.layer1.data.UserPasswordDemoLoginData;


@Layer0LiveModule(fullName = OkcoinConstants.ADAPTER_FULL_NAME, shortName = OkcoinConstants.ADAPTER_SHORT_NAME)
@Layer1ApiVersion(Layer1ApiVersionValue.VERSION2)
public class OkcoinRelayProvider extends RelayProvider {

    public OkcoinRelayProvider() {
        super(OkcoinConstants.EXCHANGE, OkcoinConstants.WS_PORT_NUMBER, OkcoinConstants.WS_LINK);
        Log.info("Relay " + this.hashCode());
    }

    @Override
    public void login(LoginData loginData) {
        UserPasswordDemoLoginData userPasswordDemoLoginData = (UserPasswordDemoLoginData) loginData;
        
        if (userPasswordDemoLoginData.isDemo) {
            Layer1ApiProvider provider = new OkcoinRealTimeProvider(OkcoinConstants.EXCHANGE, OkcoinConstants.WS_PORT_NUMBER, OkcoinConstants.WS_LINK);
            setProvider(provider);
            Log.info("OkexRealtimeProvider " + provider.hashCode());
        } else {
            adminListeners.forEach(l -> l.onLoginFailed(LoginFailedReason.UNKNOWN,
                    "The provider works only in demo mode now.\nPlease tick the demo checkbox in and leave the login/password fields blank."));
            return;
        }
        ListenableHelper.addListeners(provider, this);
        super.login(loginData);
    }
}
