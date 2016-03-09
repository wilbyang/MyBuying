package libwy.symbio.com.mybuying;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import libwy.symbio.com.mybuying.model.Sku;

/**
 * A placeholder fragment containing a simple view.
 */
public class SkuDetailActivityFragment extends Fragment {
    Sku sku;
    @Bind(R.id.detail_description)
    TextView description;

    public SkuDetailActivityFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        sku = (Sku)bundle.getParcelable("sku");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sku_detail, container, false);
        ButterKnife.bind(this, view);
        if (sku != null) {
            description.setText(sku.getDescription());
        }


        return view;
    }
}
