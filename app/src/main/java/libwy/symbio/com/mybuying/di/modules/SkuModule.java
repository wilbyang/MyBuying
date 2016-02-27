package libwy.symbio.com.mybuying.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import libwy.symbio.com.mybuying.services.SkuApiInterface;
import retrofit.Retrofit;

@Module
public class SkuModule {

    @Provides
    @Singleton
    public SkuApiInterface providesGitHubInterface(@Named("sku_endpoint")Retrofit retrofit) {
        return retrofit.create(SkuApiInterface.class);
    }
}
