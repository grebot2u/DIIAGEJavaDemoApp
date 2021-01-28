package diiage.potherat.demo.demoapp3.ui.vehicle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.databinding.FragmentVehicleBinding;

@AndroidEntryPoint
public class VehicleFragment extends Fragment {

    @Inject
    VehicleViewModel viewModel;
    private FragmentVehicleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentVehicleBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(VehicleViewModel.class);

    }

    @Override
    public void onStart() {
        super.onStart();
        ready();
    }

    private void ready(){
        if (binding != null && viewModel != null){
            binding.setLifecycleOwner(getViewLifecycleOwner());
            binding.setViewmodel(viewModel);

            binding.btnValid.setOnClickListener(view -> {
                viewModel.searchVehicle();
            });

            viewModel.getVehicle().observe(getViewLifecycleOwner(), vehicle -> {
                if (vehicle == null) {
                    binding.vehicleResult.setText("None vehicle to display.");
                } else {
                    binding.vehicleResult.setText("Name:" + vehicle.name + ", Model:" + vehicle.model);
                }
            });
        }
    }
}
