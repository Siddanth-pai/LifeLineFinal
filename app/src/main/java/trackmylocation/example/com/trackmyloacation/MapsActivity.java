package trackmylocation.example.com.trackmyloacation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LocationManager locationManager;
    HashMap<String, String> markerMap = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //checking if network provider is enabled
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //getting latitude and longitude
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    double latitude1 = latitude- 0.0101;
                    double longitude1 = longitude+ 0.0401;
                    double latitude2 = latitude+ 0.023;
                    double longitude2 = longitude- 0.02;
                    double latitude3 = latitude+ 0.5;
                    double longitude3 = longitude+ 0.5;


                    //instantiate the class LatLng
                    LatLng latLng = new LatLng(latitude, longitude);
                    LatLng latLng1 = new LatLng(latitude1, longitude1);
                    LatLng latLng2 = new LatLng(latitude2, longitude2);
                    LatLng latLng3 = new LatLng(latitude3, longitude3);

                    //instantiate the class geocoder -> converts lat and lng to a meaningful address
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try{
                        String id = null;
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getLocality() + ", ";
                        str += addressList.get(0).getPostalCode();

                        Marker a; Marker b; Marker me; Marker c;
                        me=mMap.addMarker(new MarkerOptions().position(latLng).title(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
                        id=me.getId();
                        markerMap.put(id,"me");
                        a=mMap.addMarker(new MarkerOptions().position(latLng1).title("Vraj B+"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 10.2f));
                        id=a.getId();
                        markerMap.put(id,"a");
                        b=mMap.addMarker(new MarkerOptions().position(latLng2).title("Adish A+"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 10.2f));
                        id=b.getId();
                        markerMap.put(id,"b");
                        c=mMap.addMarker(new MarkerOptions().position(latLng3).title("Jayaraj Ajri O+"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng3, 10.2f));
                        id=c.getId();
                        markerMap.put(id,"c");

                        Toast.makeText(MapsActivity.this, "Using Network", Toast.LENGTH_SHORT).show();

                        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                String m = markerMap.get(marker.getId());
                                if(m.equals("me")){
                                    Intent i =  new Intent(MapsActivity.this, ActivityMe.class);
                                    startActivity(i);
                                }
                                else if(m.equals("a")){
                                    Intent i = new Intent(MapsActivity.this, Activity1.class);
                                    startActivity(i);
                                }
                                if(m.equals("b")){
                                    Intent i = new Intent(MapsActivity.this, Activity2.class);
                                    startActivity(i);
                                }
                                if(m.equals("c")){
                                    Intent i = new Intent(MapsActivity.this, Activity3.class);
                                    startActivity(i);
                                }
                            }
                        });









                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        }
        else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //getting latitude and longitude
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    double latitude1 = latitude+1;
                    double longitude1 = longitude+1;

                    //instantiate the class LatLng
                    LatLng latLng = new LatLng(latitude, longitude);
                    LatLng latLng1 = new LatLng(latitude1, longitude1);

                    //instantiate the class geocoder -> converts lat and lng to a meaningful address
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try{
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getLocality() + ", ";
                        str += addressList.get(0).getPostalCode();


                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
                        mMap.addMarker(new MarkerOptions().position(latLng1).title("Another marker at latLng+1"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 10.2f));
                        Toast.makeText(MapsActivity.this, "Using GPS", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10.2f));
    }
}

