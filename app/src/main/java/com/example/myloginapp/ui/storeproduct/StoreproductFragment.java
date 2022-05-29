package com.example.myloginapp.ui.storeproduct;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myloginapp.databinding.FragmentStoreProductBinding;

public class StoreproductFragment extends Fragment {

  private FragmentStoreProductBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    StoreproductViewModel slideshowViewModel =
            new ViewModelProvider(this).get(StoreproductViewModel.class);

    binding = FragmentStoreProductBinding.inflate(inflater, container, false);
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
