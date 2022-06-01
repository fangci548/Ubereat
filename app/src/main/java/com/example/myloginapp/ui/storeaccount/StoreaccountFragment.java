package com.example.myloginapp.ui.storeaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myloginapp.databinding.FragmentSlideshowBinding;
import com.example.myloginapp.databinding.FragmentStoreAccountBinding;
import com.example.myloginapp.ui.slideshow.SlideshowViewModel;

public class StoreaccountFragment extends Fragment {

  private FragmentStoreAccountBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    StoreaccountViewModel storeaccountViewModel =
            new ViewModelProvider(this).get(StoreaccountViewModel.class);

    binding = FragmentStoreAccountBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
