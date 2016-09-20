package libwy.symbio.com.mybuying.services;

import java.util.List;

import libwy.symbio.com.mybuying.model.Sku;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by wilbyang on 26/02/16.
 */
public interface SkuApiInterface {

    @GET("data/{category}.json")
    Call<List<Sku>> getProducts(@Path("category") String category);
}
