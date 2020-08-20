package com.example.onsitetask2;

import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    private static final String TAG = "FragmentA";

    private FragmentAListener listener;
    private FragmentAPaintView paintView;
    private Path path;

    public interface FragmentAListener {
        void OnInputSentA(Path path);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paintView = new FragmentAPaintView(this.getActivity(), FragmentA.this);
        return paintView;
    }

    public void callPathGetter() {
        pathGetter();
    }

    public void pathGetter() {
        if(paintView != null) {
            path = paintView.getPath();
            listener.OnInputSentA(path);
        }
        else
            Log.d(TAG, "pathGetter: paintView is null(fragmentA)");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        }
        else {
            throw new RuntimeException(context.toString() + " should be implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
