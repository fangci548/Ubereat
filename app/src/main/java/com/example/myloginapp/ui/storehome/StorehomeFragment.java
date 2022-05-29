package com.example.myloginapp.ui.storehome;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.myloginapp.databinding.FragmentStoreHomeBinding;

public class StorehomeFragment extends Fragment {

  private FragmentStoreHomeBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    StorehomeViewModel storehomeViewModel =
            new ViewModelProvider(this).get(StorehomeViewModel.class);

    binding = FragmentStoreHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    //final TextView textView = binding.textSlideshow;
    //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
