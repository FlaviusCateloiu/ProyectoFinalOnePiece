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

import com.app.proyectofinalonepiece.databinding.FragmentRecycleViewMarineBinding;
import com.app.proyectofinalonepiece.databinding.ItemMarineBinding;
import com.app.proyectofinalonepiece.models.Marine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class RecycleViewMarineFragment extends Fragment {

    private FragmentRecycleViewMarineBinding binding;
    private MarineViewModel marineViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecycleViewMarineBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        marineViewModel = new ViewModelProvider(requireActivity()).get(MarineViewModel.class);
        navController = Navigation.findNavController(view);

        RecycleViewMarineFragment.MarineAdapter adapter = new RecycleViewMarineFragment.MarineAdapter();
        binding.recyclerView.setAdapter(adapter);

        marineViewModel.getListMarine().observe(getViewLifecycleOwner(), adapter::establecerLista);
    }

    class MarineAdapter extends RecyclerView.Adapter<RecycleViewMarineFragment.MarineViewHolder> {

        ArrayList<Marine> marines;

        @NonNull
        @Override
        public RecycleViewMarineFragment.MarineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecycleViewMarineFragment.MarineViewHolder(ItemMarineBinding.inflate(getLayoutInflater(), parent, false));
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull RecycleViewMarineFragment.MarineViewHolder holder, int position) {
            Marine marine = marines.get(position);

            holder.binding.nombreMarineView.setText(marine.getApellido() + " " + marine.getNombre());

            /* ********* Cambiar la ruta de donde coge la imagen. ****************** */
            Glide.with(RecycleViewMarineFragment.this)
                    .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + marine.getId() + ".jpg")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.fotoMarineView);

            holder.itemView.setOnClickListener(view -> {
                marineViewModel.seleccionar(marine);
                navController.navigate(R.id.action_recycleViewMarineFragment_to_mostrarMarineFragment);
            });
        }

        @Override
        public int getItemCount() {
            return marines != null ? marines.size() : 0;
        }

        public void establecerLista(ArrayList<Marine> marines) {
            this.marines = marines;
            notifyDataSetChanged();
        }
    }

    class MarineViewHolder extends RecyclerView.ViewHolder {
        private final ItemMarineBinding binding;

        public MarineViewHolder(ItemMarineBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}