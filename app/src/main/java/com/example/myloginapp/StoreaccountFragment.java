package com.example.myloginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myloginapp.R;
import com.example.myloginapp.databinding.FragmentSlideshowBinding;
import com.example.myloginapp.databinding.FragmentStoreAccountBinding;
import com.example.myloginapp.ui.slideshow.SlideshowViewModel;

public class StoreaccountFragment extends Fragment {

  private FragmentStoreAccountBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_store_account, container, false);
  }

}
