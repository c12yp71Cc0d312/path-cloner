package com.example.onsitetask2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Path;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private static final String TAG = "FragmentB";

    private FragmentBPaintView paintView;
    private Path path;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paintView = new FragmentBPaintView(this.getActivity(), FragmentB.this);
        return paintView;
    }

    public void updatePath(Path path) {
        this.path = path;
        if(paintView != null) {
            paintView.setPath(path);
        }
        else {
            Log.d(TAG, "updatePath: paintView is null(fragmentB)");
        }
    }
}
