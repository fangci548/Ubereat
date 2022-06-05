package com.example.myloginapp.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myloginapp.R;
import com.example.myloginapp.RoleChose;
import com.example.myloginapp.databinding.FragmentSlideshowBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SlideshowFragment extends Fragment {

  private FragmentSlideshowBinding binding;
  Context context;
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    SlideshowViewModel slideshowViewModel =
            new ViewModelProvider(this).get(SlideshowViewModel.class);
    View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
    context = container.getContext();
    FirebaseAuth.getInstance().signOut();
    startActivity(new Intent(context, RoleChose.class));
    binding = FragmentSlideshowBinding.inflate(inflater, container, false);
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