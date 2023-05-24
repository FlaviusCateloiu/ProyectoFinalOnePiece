package com.app.proyectofinalonepiece;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.proyectofinalonepiece.databinding.FragmentMostrarPirataBinding;
import com.app.proyectofinalonepiece.models.Pirata;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Locale;

public class MostrarPirataFragment extends Fragment {

    private FragmentMostrarPirataBinding binding;
    Pirata pirata;
    PirataViewModel pirataViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pirataViewModel = new ViewModelProvider(requireActivity()).get(PirataViewModel.class);
        this.pirata = pirataViewModel.getPirataMutableLiveData().getValue();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(MostrarPirataFragment.this)
                .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + pirata.getId() + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.pirataPhotoView);
        binding.pirataFullNameView.setText(pirata.getApellido().toUpperCase() + " " + pirata.getNombre().toUpperCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarPirataBinding.inflate(inflater, container, false)).getRoot();
    }
}