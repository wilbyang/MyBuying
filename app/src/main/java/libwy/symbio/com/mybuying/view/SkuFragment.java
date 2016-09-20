package libwy.symbio.com.mybuying.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import libwy.symbio.com.mybuying.MyApplication;
import libwy.symbio.com.mybuying.R;
import libwy.symbio.com.mybuying.model.Sku;
import libwy.symbio.com.mybuying.services.SkuApiInterface;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SkuFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";
    private String category = "";
    private OnListFragmentInteractionListener mListener;


    protected List<Sku> skus = new ArrayList<>();
    SkuRecyclerViewAdapter adapter;

    @Inject
    SkuApiInterface skuApiInterface;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkuFragment() {

    }

    @SuppressWarnings("unused")
    public static SkuFragment newInstance(String category) {
        SkuFragment fragment = new SkuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            category = getArguments().getString(ARG_CATEGORY);
        }
        MyApplication myApplication = (MyApplication)(getActivity().getApplication());
        myApplication.getSkuComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sku_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
            recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
/*


            if (mColumnCount <= 1) {
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }*/
            adapter = new SkuRecyclerViewAdapter(skus, mListener);
            recyclerView.setAdapter(adapter);

            Call<List<Sku>> call = skuApiInterface.getProducts(category);
            call.enqueue(new Callback<List<Sku>>() {
                @Override
                public void onResponse(Response<List<Sku>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        skus.addAll(response.body());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Sku item);
    }
}
