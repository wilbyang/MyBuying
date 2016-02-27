package libwy.symbio.com.mybuying.services;

import java.util.List;

import libwy.symbio.com.mybuying.model.Sku;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by wilbyang on 26/02/16.
 */
public interface SkuApiInterface {

    @GET("VkL8kMOox")
    Call<List<Sku>> getProducts();
}
