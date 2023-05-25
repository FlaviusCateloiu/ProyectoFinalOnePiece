package com.app.proyectofinalonepiece;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.proyectofinalonepiece.databinding.FragmentMostrarMarineBinding;
import com.app.proyectofinalonepiece.databinding.FragmentMostrarPirataBinding;
import com.app.proyectofinalonepiece.models.Marine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MostrarMarineFragment extends Fragment {

    private FragmentMostrarMarineBinding binding;
    private Marine marine;
    private MarineViewModel marineViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        marineViewModel = new ViewModelProvider(requireActivity()).get(MarineViewModel.class);
        this.marine = marineViewModel.getMarine().getValue();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(MostrarMarineFragment.this)
                .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + marine.getId() + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.marinePhotoView);
        binding.marineFullNameView.setText(marine.getApellido().toUpperCase() + " " + marine.getNombre().toUpperCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarMarineBinding.inflate(inflater, container, false)).getRoot();
    }
}