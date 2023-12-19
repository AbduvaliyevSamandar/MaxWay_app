package com.example.maxwayapp.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentMapBinding
import com.example.maxwayapp.extention.requarebuttonNav
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment :Fragment(R.layout.fragment_map) , OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private  val binding: FragmentMapBinding by viewBinding()

    private lateinit var permissionResult: ActivityResultLauncher<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requarebuttonNav(this)

        permissionResult = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return@registerForActivityResult
            }
            if (isGranted) map.isMyLocationEnabled = true
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getCenterCoordinates(): LatLng {

        val cameraPosition = map.cameraPosition
        return cameraPosition.target

    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun getPlaceNameFromCoordinates(
        latLng: LatLng,
        callback: (String) -> Unit
    ) {
        val geocoder = Geocoder(requireContext())
        geocoder.getFromLocation(
            latLng.latitude,
            latLng.longitude,
            1
        ) { addresses ->
            val placeName = addresses[0].thoroughfare ?: addresses[0].locality
            callback(placeName)
        }

    }


    @SuppressLint("MissingPermission", "SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.mapType = GoogleMap.MAP_TYPE_NORMAL

        map.setOnCameraIdleListener {
            val center = getCenterCoordinates()
            val geocoder = Geocoder(requireContext())
            geocoder.getFromLocation(center.latitude, center.longitude, 1) { locations ->
                val address = locations.firstOrNull()
                binding.locationtext.text="${address?.countryName} , ${address?.adminArea} , ${address?.subLocality} "
            }
        }
        val marker = LatLng(40.2356469, 71.5829803)

        map.addMarker(MarkerOptions().position(marker).title("My House"))
        map.uiSettings.isZoomControlsEnabled = true
        if (isLocationEnabled()) map.isMyLocationEnabled = true
        else LOCATIONS.forEach {
            permissionResult.launch(it)
        }
        map.moveCamera(CameraUpdateFactory.newLatLng(marker))

    }

    private fun isLocationEnabled(): Boolean {
        return LOCATIONS.all { ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED }
    }

    companion object {
        val LOCATIONS = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }


}