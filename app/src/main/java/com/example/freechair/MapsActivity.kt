package com.example.freechair

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.freechair.databinding.ActivityMapsBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.*

class MapsActivity : BaseActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private var marker:Marker?=null
    private var permissionCheck=false
    private var currPosition=false
    private val helper=SqliteHelper(this,"restaurantDb",1)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helper.dbInit()

        binding.backButtonMap.setOnClickListener{
            finish()
        }

        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION)

        requirePermissions(permissions,999)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun permissionGranted(requestCode: Int) {
        startProcess()
    }

    override fun permissionDenied(requestCode: Int) {
        Toast.makeText(this,"?????? ????????? ???????????????.", Toast.LENGTH_LONG).show()
    }

    fun startProcess(){
        permissionCheck=true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnInfoWindowClickListener (this)

        binding.plusButton.setOnClickListener{
            mMap.animateCamera(CameraUpdateFactory.zoomIn())

        }
        binding.minusButton.setOnClickListener{
            mMap.animateCamera(CameraUpdateFactory.zoomOut())

        }



        if (permissionCheck==false){
            //?????? ?????? ??????
            val LATLNGinit = LatLng(37.566418, 126.977943)

            //????????? ?????? ????????? ????????? ?????? ?????? ?????? ??????
            val markerOptions = MarkerOptions()
                .position(LATLNGinit)
                .title("????????????")
                .snippet("????????????")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

            //????????? ?????? ?????? ?????? ??????
            mMap.addMarker(markerOptions)

            //????????? ?????? ?????? ??????. ?????? ??????. ?????? ?????? ????????? ??????.
            val cameraPosition = CameraPosition.Builder()
                .target(LATLNGinit)
                .zoom(15.0f)
                .build()



            //????????? ????????? ?????? ?????? ???????????? ????????? ???????????? ?????? ??????.
            val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)

            //????????? ??????
            mMap.moveCamera(cameraUpdate)

        }

        val listForCoordinate=helper.selectAll()
        for (shop in listForCoordinate){
            val shopCoordinate=LatLng(shop.latitude,shop.longitude)
            val markerOptions = MarkerOptions()
                .position(shopCoordinate)
                .title("${shop.name}")
                .snippet("${shop.phoneNo}")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))

            //????????? ?????? ?????? ?????? ??????
            marker=mMap.addMarker(markerOptions)




        }

        //?????? ????????? ??????
        fusedLocationClient=LocationServices.getFusedLocationProviderClient(this)
        updateLocation()






    }

    override fun onInfoWindowClick(marker:Marker){
        val name=marker.title
        val intentShopInfo=Intent(this,SearchResultActivity::class.java)

        intentShopInfo.putExtra("search","${name}")


        startActivity(intentShopInfo)
    }

    @SuppressLint("MissingPermission")
    fun updateLocation(){
        val locationRequest= LocationRequest.create()
        locationRequest.run{
            priority=LocationRequest.PRIORITY_HIGH_ACCURACY
            interval=1000
        }

        locationCallback = object:LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?){
                locationResult?.let{
                    for((i,location) in it.locations.withIndex()){
                        Log.d("Location","$i ${location.latitude},${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }
        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
        //fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    fun setLastLocation(lastLocation: Location){
        val LATLNG = LatLng(lastLocation.latitude,lastLocation.longitude)
        val markerOptions = MarkerOptions()
            .position(LATLNG)
            .title("????????????")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

        val cameraPosition= CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()

        marker?.remove()
        marker=mMap.addMarker(markerOptions)
        if(currPosition){}
        else{mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))}
        currPosition=true



    }


}