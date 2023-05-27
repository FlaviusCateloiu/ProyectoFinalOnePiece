package com.app.proyectofinalonepiece;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.proyectofinalonepiece.databinding.FragmentMostrarArmaBinding;
import com.app.proyectofinalonepiece.databinding.FragmentMostrarMarineBinding;
import com.app.proyectofinalonepiece.models.Arma;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MostrarArmaFragment extends Fragment {

    private FragmentMostrarArmaBinding binding;
    private Arma arma;
    private ArmaViewModel armaViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        armaViewModel = new ViewModelProvider(requireActivity()).get(ArmaViewModel.class);
        this.arma = armaViewModel.getArma().getValue();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(MostrarArmaFragment.this)
                .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + arma.getId() + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.armaPhotoView);
        binding.armaFullNameView.setText(arma.getNombre().toUpperCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarArmaBinding.inflate(inflater, container, false)).getRoot();
    }
}