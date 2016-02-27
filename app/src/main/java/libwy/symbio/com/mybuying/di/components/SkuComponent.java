package libwy.symbio.com.mybuying.di.components;

import javax.inject.Singleton;

import dagger.Component;
import libwy.symbio.com.mybuying.LoginActivity;
import libwy.symbio.com.mybuying.MainActivity;
import libwy.symbio.com.mybuying.di.modules.AppModule;
import libwy.symbio.com.mybuying.di.modules.NetModule;
import libwy.symbio.com.mybuying.di.modules.SkuModule;
import libwy.symbio.com.mybuying.view.SkuFragment;

@Singleton
@Component(modules={AppModule.class, NetModule.class, SkuModule.class})
public interface SkuComponent {
    void inject(MainActivity activity);
    void inject(LoginActivity activity);
    void inject(SkuFragment fragment);
}
