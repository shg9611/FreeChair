package com.example.freechair

import android.Manifest
import android.annotation.SuppressLint
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
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.freechair.databinding.ActivityMapsBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.CameraPosition

class MapsActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private var permissionCheck=false
    private var currPosition=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        Toast.makeText(this,"권한 승인이 필요합니다.", Toast.LENGTH_LONG).show()
    }

    fun startProcess(){
        permissionCheck=true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (permissionCheck==false){
            //좌표 객체 생성
            val LATLNGinit = LatLng(37.566418, 126.977943)

            //생성한 좌표 객체를 위치로 하는 마커 객체 생성
            val markerOptions = MarkerOptions()
                .position(LATLNGinit)
                .title("서울시청")
                .snippet("정보차아아앙")

            //생성한 마커 객체 맵에 추가
            mMap.addMarker(markerOptions)

            //카메라 위치 객체 생성. 마커 위치. 줌을 거리 레밸로 확대.
            val cameraPosition = CameraPosition.Builder()
                .target(LATLNGinit)
                .zoom(15.0f)
                .build()

            //생성한 카메라 위치 객체 전달하여 카메라 업데이트 객체 생성.
            val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)

            //카메라 이동
            mMap.moveCamera(cameraUpdate)
        }

        //현재 위치로 갱신
        fusedLocationClient=LocationServices.getFusedLocationProviderClient(this)
        updateLocation()




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
            .title("현재위치")

        val cameraPosition= CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        mMap.clear()
        mMap.addMarker(markerOptions)
        if(currPosition){}
        else{mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))}
        currPosition=true



    }


}