package com.app.proyectofinalonepiece;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.proyectofinalonepiece.databinding.FragmentRecycleViewArmaBinding;
import com.app.proyectofinalonepiece.databinding.ItemArmaBinding;
import com.app.proyectofinalonepiece.databinding.ItemMarineBinding;
import com.app.proyectofinalonepiece.models.Arma;
import com.app.proyectofinalonepiece.models.Marine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;


public class RecycleViewArmaFragment extends Fragment {

    private FragmentRecycleViewArmaBinding binding;
    private ArmaViewModel armaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecycleViewArmaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        armaViewModel = new ViewModelProvider(requireActivity()).get(ArmaViewModel.class);
        navController = Navigation.findNavController(view);

        RecycleViewArmaFragment.ArmaAdapter adapter = new RecycleViewArmaFragment.ArmaAdapter();
        binding.recyclerView.setAdapter(adapter);

        armaViewModel.getListArma().observe(getViewLifecycleOwner(), adapter::establecerLista);
    }

    class ArmaAdapter extends RecyclerView.Adapter<RecycleViewArmaFragment.ArmaViewHolder> {

        ArrayList<Arma> armas;

        @NonNull
        @Override
        public RecycleViewArmaFragment.ArmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecycleViewArmaFragment.ArmaViewHolder(ItemArmaBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleViewArmaFragment.ArmaViewHolder holder, int position) {
            Arma arma = armas.get(position);

            holder.binding.nombreArmaView.setText(arma.getNombre());

            /* ********* Cambiar la ruta de donde coge la imagen. ****************** */
            Glide.with(RecycleViewArmaFragment.this)
                    .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + arma.getId() + ".jpg")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.fotoArmaView);

            holder.itemView.setOnClickListener(view -> {
                armaViewModel.seleccionar(arma);
                navController.navigate(R.id.action_recycleViewArmaFragment_to_mostrarArmaFragment);
            });
        }

        @Override
        public int getItemCount() {
            return armas != null ? armas.size() : 0;
        }

        public void establecerLista(ArrayList<Arma> armas) {
            this.armas = armas;
            notifyDataSetChanged();
        }
    }

    class ArmaViewHolder extends RecyclerView.ViewHolder {
        private final ItemArmaBinding binding;

        public ArmaViewHolder(ItemArmaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}