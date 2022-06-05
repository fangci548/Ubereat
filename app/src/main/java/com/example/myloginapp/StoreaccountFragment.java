package com.example.myloginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myloginapp.databinding.FragmentStoreAccountBinding;
import com.google.firebase.auth.FirebaseAuth;

public class StoreaccountFragment extends Fragment {

  private FragmentStoreAccountBinding binding;
  Context context;
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    context = container.getContext();
    View view = inflater.inflate(R.layout.fragment_store_account, container, false);
    LinearLayout logout = (LinearLayout) view.findViewById(R.id.store_layout9);
    logout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(context, RoleChose.class));
      }
    });

    return view;
  }



}
