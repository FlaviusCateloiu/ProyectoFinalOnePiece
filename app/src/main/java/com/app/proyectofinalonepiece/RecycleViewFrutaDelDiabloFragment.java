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

import com.app.proyectofinalonepiece.databinding.FragmentRecycleViewFrutaDelDiabloBinding;
import com.app.proyectofinalonepiece.databinding.ItemFrutaDelDiabloBinding;
import com.app.proyectofinalonepiece.models.FrutaDelDiablo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;


public class RecycleViewFrutaDelDiabloFragment extends Fragment {

    private FragmentRecycleViewFrutaDelDiabloBinding binding;
    private FrutasDelDiabloViewModel frutasDelDiabloViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecycleViewFrutaDelDiabloBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        frutasDelDiabloViewModel = new ViewModelProvider(requireActivity()).get(FrutasDelDiabloViewModel.class);
        navController = Navigation.findNavController(view);

        RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloAdapter adapter = new RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloAdapter();
        binding.recyclerView.setAdapter(adapter);

        frutasDelDiabloViewModel.getListFrutasDelDiablo().observe(getViewLifecycleOwner(), adapter::establecerLista);
    }

    class FrutaDelDiabloAdapter extends RecyclerView.Adapter<RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloViewHolder> {

        ArrayList<FrutaDelDiablo> frutasDelDiablo;

        @NonNull
        @Override
        public RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloViewHolder(ItemFrutaDelDiabloBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleViewFrutaDelDiabloFragment.FrutaDelDiabloViewHolder holder, int position) {
            FrutaDelDiablo frutaDelDiablo = frutasDelDiablo.get(position);

            holder.binding.nombreFrutaView.setText(frutaDelDiablo.getNombre());

            /* ********* Cambiar la ruta de donde coge la imagen. ****************** */
            Glide.with(RecycleViewFrutaDelDiabloFragment.this)
                    .load("https://github.com/FlaviusCateloiu/ProyectoFinalOnePieceAPI/blob/master/src/main/resources/static/" + frutaDelDiablo.getId() + ".jpg")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.fotoFrutaView);

            holder.itemView.setOnClickListener(view -> {
                frutasDelDiabloViewModel.seleccionar(frutaDelDiablo);
                navController.navigate(R.id.action_recycleViewFrutaDelDiabloFragment_to_mostrarFrutaDelDiabloFragment);
            });
        }

        @Override
        public int getItemCount() {
            return frutasDelDiablo != null ? frutasDelDiablo.size() : 0;
        }

        public void establecerLista(ArrayList<FrutaDelDiablo> frutasDelDiablo) {
            this.frutasDelDiablo = frutasDelDiablo;
            notifyDataSetChanged();
        }
    }

    class FrutaDelDiabloViewHolder extends RecyclerView.ViewHolder {
        private final ItemFrutaDelDiabloBinding binding;

        public FrutaDelDiabloViewHolder(ItemFrutaDelDiabloBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}