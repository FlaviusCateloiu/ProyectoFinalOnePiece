package com.app.proyectofinalonepiece;

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

import com.app.proyectofinalonepiece.databinding.FragmentRecycleViewIslaBinding;
import com.app.proyectofinalonepiece.databinding.ItemIslaBinding;
import com.app.proyectofinalonepiece.models.Isla;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class RecycleViewIslaFragment extends Fragment {

    private FragmentRecycleViewIslaBinding binding;
    private IslaViewModel islaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecycleViewIslaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        islaViewModel = new ViewModelProvider(requireActivity()).get(IslaViewModel.class);
        navController = Navigation.findNavController(view);

        RecycleViewIslaFragment.IslaAdapter adapter = new RecycleViewIslaFragment.IslaAdapter();
        binding.recyclerView.setAdapter(adapter);

        islaViewModel.getListIsla().observe(getViewLifecycleOwner(), adapter::establecerLista);
    }

    class IslaAdapter extends RecyclerView.Adapter<RecycleViewIslaFragment.IslaViewHolder> {

        ArrayList<Isla> islas;

        @NonNull
        @Override
        public RecycleViewIslaFragment.IslaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecycleViewIslaFragment.IslaViewHolder(ItemIslaBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleViewIslaFragment.IslaViewHolder holder, int position) {
            Isla isla = islas.get(position);

            holder.binding.nombreIslaView.setText(isla.getNombre());

            /* ********* Cambiar la ruta de donde coge la imagen. ****************** */
            Glide.with(RecycleViewIslaFragment.this)
                    .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + isla.getId() + ".jpg")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.fotoIslaView);

            holder.itemView.setOnClickListener(view -> {
                islaViewModel.seleccionar(isla);
                navController.navigate(R.id.action_recycleViewIslaFragment_to_mostrarIslaFragment);
            });
        }

        @Override
        public int getItemCount() {
            return islas != null ? islas.size() : 0;
        }

        public void establecerLista(ArrayList<Isla> islas) {
            this.islas = islas;
            notifyDataSetChanged();
        }
    }

    class IslaViewHolder extends RecyclerView.ViewHolder {
        private final ItemIslaBinding binding;

        public IslaViewHolder(ItemIslaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}