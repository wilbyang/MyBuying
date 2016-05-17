package libwy.symbio.com.mybuying;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import libwy.symbio.com.mybuying.model.Sku;

public class SkuDetailActivity extends AppCompatActivity {

    private ImageView skuImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        skuImg = (ImageView) findViewById(R.id.sku_image);
        Sku sku = getIntent().getExtras().getParcelable("sku");
        setTitle(sku.getName());
        Glide.with(this).load(sku.getPicture()).into(skuImg);

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            SkuDetailActivityFragment fragment = new SkuDetailActivityFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("sku", sku);
            fragment.setArguments(bundle);
            fm.beginTransaction().add(R.id.item_detail_container, fragment).commit();
        }

    }

}
