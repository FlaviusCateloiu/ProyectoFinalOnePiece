package com.app.proyectofinalonepiece;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.proyectofinalonepiece.databinding.FragmentMostrarArmaBinding;
import com.app.proyectofinalonepiece.databinding.FragmentMostrarIslaBinding;
import com.app.proyectofinalonepiece.models.Isla;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MostrarIslaFragment extends Fragment {

    private FragmentMostrarIslaBinding binding;
    private Isla isla;
    private IslaViewModel islaViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        islaViewModel = new ViewModelProvider(requireActivity()).get(IslaViewModel.class);
        this.isla = islaViewModel.getIsla().getValue();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(MostrarIslaFragment.this)
                .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + isla.getId() + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.islaPhotoView);
        binding.islaFullNameView.setText(isla.getNombre().toUpperCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarIslaBinding.inflate(inflater, container, false)).getRoot();
    }
}