package com.app.proyectofinalonepiece;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.proyectofinalonepiece.databinding.FragmentMostrarFrutaDelDiabloBinding;
import com.app.proyectofinalonepiece.databinding.FragmentMostrarIslaBinding;
import com.app.proyectofinalonepiece.models.FrutaDelDiablo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MostrarFrutaDelDiabloFragment extends Fragment {

    private FragmentMostrarFrutaDelDiabloBinding binding;
    private FrutaDelDiablo frutaDelDiablo;
    private FrutasDelDiabloViewModel frutasDelDiabloViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        frutasDelDiabloViewModel = new ViewModelProvider(requireActivity()).get(FrutasDelDiabloViewModel.class);
        this.frutaDelDiablo = frutasDelDiabloViewModel.getFrutaDelDiablo().getValue();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(MostrarFrutaDelDiabloFragment.this)
                .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + frutaDelDiablo.getId() + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.frutaPhotoView);
        binding.frutaFullNameView.setText(frutaDelDiablo.getNombre().toUpperCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarFrutaDelDiabloBinding.inflate(inflater, container, false)).getRoot();
    }
}