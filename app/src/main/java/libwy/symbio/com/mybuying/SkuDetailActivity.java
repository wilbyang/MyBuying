package libwy.symbio.com.mybuying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import libwy.symbio.com.mybuying.model.Sku;

public class SkuDetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
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

        // get the bottom sheet view
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        // init the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        // set the peek height
        bottomSheetBehavior.setPeekHeight(340);

        // set hideable or not
        bottomSheetBehavior.setHideable(false);

        // set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        skuImg = (ImageView) findViewById(R.id.sku_image);
        Sku sku = getIntent().getExtras().getParcelable("sku");
        setTitle(sku.getName());
        Glide.with(this).load("https://www.libwy.com/" + sku.getImage()).into(skuImg);

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
