package libwy.symbio.com.mybuying.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import libwy.symbio.com.mybuying.R;
import libwy.symbio.com.mybuying.model.Sku;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SkuRecyclerViewAdapter extends RecyclerView.Adapter<SkuRecyclerViewAdapter.ViewHolder> {

    private final List<Sku> skus;
    private final SkuFragment.OnListFragmentInteractionListener mListener;

    public SkuRecyclerViewAdapter(List<Sku> items, SkuFragment.OnListFragmentInteractionListener listener) {
        skus = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sku, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.sku = skus.get(position);
        holder.nameTextView.setText(holder.sku.getName());
        holder.descriptionTextView.setText(holder.sku.getDescription());
        Glide.with((Context)mListener).load(holder.sku.getPicture()).into(holder.picture);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.sku);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return skus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameTextView;
        public final TextView descriptionTextView;
        public final ImageView picture;
        public Sku sku;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameTextView = (TextView) view.findViewById(R.id.name);
            descriptionTextView = (TextView) view.findViewById(R.id.description);
            picture = (ImageView) view.findViewById(R.id.picture);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + descriptionTextView.getText() + "'";
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
