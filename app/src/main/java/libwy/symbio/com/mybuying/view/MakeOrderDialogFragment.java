package libwy.symbio.com.mybuying.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import libwy.symbio.com.mybuying.R;

/**
 * Created by wilbyang on 29/02/16.
 */
public class MakeOrderDialogFragment extends DialogFragment {
    MakeOrderDialogListener mListener;
    private EditText quantityEditText;
    private EditText noteEditText;

    public interface MakeOrderDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        quantityEditText = (EditText) view.findViewById(R.id.quantity);
        noteEditText = (EditText) view.findViewById(R.id.note);
        // Fetch arguments from bundle and set title

        getDialog().setTitle("booking");
        // Show soft keyboard automatically and request focus to field
        quantityEditText.requestFocus();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (MakeOrderDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.make_order_form, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); //don't show dialog title
        return view;
    }
}
