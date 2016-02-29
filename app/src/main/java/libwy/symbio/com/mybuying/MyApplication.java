package libwy.symbio.com.mybuying;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import libwy.symbio.com.mybuying.di.components.DaggerSkuComponent;
import libwy.symbio.com.mybuying.di.components.SkuComponent;
import libwy.symbio.com.mybuying.di.modules.AppModule;
import libwy.symbio.com.mybuying.di.modules.NetModule;
import libwy.symbio.com.mybuying.di.modules.SkuModule;

/**
 * Created by wilbyang on 26/02/16.
 */
public class MyApplication extends Application{
    private SkuComponent skuComponent;

    public SkuComponent getSkuComponent() {
        return skuComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        Stetho.initializeWithDefaults(this);

        skuComponent = DaggerSkuComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .skuModule(new SkuModule())
                .build();

    }
}
