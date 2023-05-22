package com.app.proyectofinalonepiece;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.app.proyectofinalonepiece.databinding.FragmentRecycleViewPirataBinding;
import com.app.proyectofinalonepiece.databinding.ItemPirataBinding;
import com.app.proyectofinalonepiece.models.Pirata;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class RecycleViewPirataFragment extends Fragment {

    private FragmentRecycleViewPirataBinding binding;
    private PirataViewModel pirataViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecycleViewPirataBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pirataViewModel = new ViewModelProvider(requireActivity()).get(PirataViewModel.class);
        navController = Navigation.findNavController(view);

        PirataAdapter adapter = new PirataAdapter();
        binding.recyclerView.setAdapter(adapter);

        pirataViewModel.getListPiratas().observe(getViewLifecycleOwner(), adapter::establecerLista);
    }

    class PirataAdapter extends RecyclerView.Adapter<PirataViewHolder> {

        ArrayList<Pirata> piratas;

        @NonNull
        @Override
        public PirataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PirataViewHolder(ItemPirataBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PirataViewHolder holder, int position) {
            Pirata pirata = piratas.get(position);

            holder.binding.nombrePirataView.setText(pirata.getNombre());

            /********** Cambiar la ruta de donde coge la imagen. *******************/
            Glide.with(RecycleViewPirataFragment.this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pirata.getId() + ".png")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.fotoPirataView);

            holder.itemView.setOnClickListener(view -> {
                pirataViewModel.seleccionar(pirata);
                navController.navigate(R.id.action_recycleViewPokemonFragment_to_detailsPokemonFragment);
            });
        }

        @Override
        public int getItemCount() {
            return piratas != null ? piratas.size() : 0;
        }

        public void establecerLista(ArrayList<Pirata> pokemons) {
            this.piratas = pokemons;
            notifyDataSetChanged();
        }
    }

    class PirataViewHolder extends RecyclerView.ViewHolder {
        private final ItemPirataBinding binding;

        public PirataViewHolder(ItemPirataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}