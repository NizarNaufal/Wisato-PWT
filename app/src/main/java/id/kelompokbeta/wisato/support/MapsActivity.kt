package id.kelompokbeta.wisato.support

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import id.kelompokbeta.wisato.R
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    var backbtn: ImageView? = null
    private var mGoogleMap: GoogleMap? = null
    var lat: String? = null
    var lon: String? = null
    var name: String? = null
    private var marker_view: View? = null

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val intent = intent
        lat = intent.getStringExtra("lat")
        lon = intent.getStringExtra("lon")
        name = intent.getStringExtra("name")
        backbtn = findViewById(R.id.back_btn)
        val inflater =
                getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        marker_view = Objects.requireNonNull(inflater).inflate(R.layout.maps_marker, null)
        backbtn?.setOnClickListener { finish() }
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.mapView) as SupportMapFragment?
        Objects.requireNonNull(mapFragment)?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        mGoogleMap!!.mapType = GoogleMap.MAP_TYPE_NORMAL
        //googleMap.setMyLocationEnabled(true);
        mGoogleMap!!.isTrafficEnabled = false
        mGoogleMap!!.isIndoorEnabled = false
        mGoogleMap!!.isBuildingsEnabled = true
        mGoogleMap!!.uiSettings.isZoomControlsEnabled = true
        mGoogleMap!!.uiSettings.isZoomGesturesEnabled = true
        if (lat!!.isNotEmpty() && lon!!.isNotEmpty()) {
            val latitude = lat!!.toDouble()
            val longitude = lon!!.toDouble()
            drawMarker(latitude, longitude, name)
        }
    }

    private fun drawMarker(
            latitude: Double,
            longitude: Double,
            propname: String?
    ) {
        mGoogleMap!!.clear()
        val markerOptions = MarkerOptions()
        markerOptions.position(LatLng(latitude, longitude))
        markerOptions.title(propname)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(createBitmapFromView(marker_view)))
        markerOptions.draggable(false)
        mGoogleMap!!.addMarker(markerOptions)
        mGoogleMap!!.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                        LatLng(latitude, longitude),
                        15f
                )
        )
    }

    fun createBitmapFromView(view: View?): Bitmap {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        view!!.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.buildDrawingCache()
        val bitmap = Bitmap.createBitmap(
                view.measuredWidth,
                view.measuredHeight,
                Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
}