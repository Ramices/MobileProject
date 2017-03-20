package com.example.ramices.projetoramices.fragment;

import com.example.ramices.projetoramices.R;
import com.example.ramices.projetoramices.TelaDetalhe;
import com.example.ramices.projetoramices.base.Museu;
import com.example.ramices.projetoramices.base.Teatro;
import com.example.ramices.projetoramices.sql.DataBase;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.MapView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.model.Direction;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import net.kjulio.rxlocation.RxLocation;

import java.io.Serializable;
import java.util.ArrayList;

import rx.functions.Action1;

/**
 * Created by RamicesMoises on 04/01/2017.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback, DirectionCallback, GoogleMap.OnMarkerClickListener, LocationListener, Serializable {
    private MapView mMapView;
    private GoogleMap googleMap;
    private Location location = null;
    public static LatLng myPosition;
    private View rootView;
    private ArrayList<Teatro> teatros;
    private ArrayList<Museu> museus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanteState) {
        this.rootView = inflater.inflate(R.layout.fragment_map, container, false);
        getActivity().setTitle("RoleCultural");


        teatros = DataBase.getInstance(getActivity()).getTeatros();
        museus = DataBase.getInstance(getActivity()).getMuseus();



        this.mMapView = (MapView) rootView.findViewById(R.id.map);
        this.mMapView.onCreate(null);
        this.mMapView.onResume();
        this.mMapView.getMapAsync(this);
        return this.rootView;
    }

    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.setOnMarkerClickListener(this);

        if (this.location != null)
        {

            double latitude = this.location.getLatitude();
            double longitude = this.location.getLongitude();
            this.myPosition = new LatLng(latitude, longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(this.myPosition, 14));
            googleMap.addMarker(new MarkerOptions()
                    .title("voce")
                    .position(this.myPosition))
                    .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local));

        }


       for (int i = 0; i < teatros.size(); ++i)
        {
            this.googleMap.addMarker(new MarkerOptions().title(teatros.get(i).getNome()).position(new LatLng(teatros.get(i).getLatitude(), teatros.get(i).getLongitude())));
        }

        for (int i = 0; i < museus.size(); ++i)
        {
            this.googleMap.addMarker(new MarkerOptions().title(museus.get(i).getNome()).position(new LatLng(museus.get(i).getLatitude(), museus.get(i).getLongitude())));
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {


         if(!marker.getTitle().equals("voce"))
         {
             for(int i = 0; i < teatros.size(); ++i)
             {
                 if(marker.getPosition().equals(new LatLng(teatros.get(i).getLatitude(), teatros.get(i).getLongitude())))
                 {
                     Teatro teatro = teatros.get(i);
                     Intent it = new Intent(getActivity(), TelaDetalhe.class);
                     it.putExtra("key", "teatro");
                     it.putExtra("teatro", teatro);
                     startActivity(it);
                     return true;
                 }
             }

             for(int i = 0; i < museus.size(); ++i)
             {
                 if(marker.getPosition().equals(new LatLng(museus.get(i).getLatitude(), museus.get(i).getLongitude())))
                 {
                     Museu museu = museus.get(i);
                     Intent it = new Intent(getActivity(), TelaDetalhe.class);
                     it.putExtra("key", "museu");
                     it.putExtra("museu", museu);
                     startActivity(it);
                     return true;
                 }
             }

         }

        return false;



    }

    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
       /* Route route = direction.getRouteList().get(0);
        Leg leg = route.getLegList().get(0);
        ArrayList<LatLng> directionPositionList = leg.getDirectionPoint();
        Toast.makeText(getActivity(), "Pontos:" + directionPositionList.size(), Toast.LENGTH_SHORT).show();
        PolylineOptions polylineOptions = DirectionConverter.createPolyline(this.getActivity().getApplicationContext(), directionPositionList, 5, Color.RED);
        this.googleMap.addPolyline(polylineOptions);*/
    }

    @Override
    public void onDirectionFailure(Throwable t) {

    }





    @Override
    public void onLocationChanged(Location location)
    {
        this.location = location;
        this.mMapView = (MapView) rootView.findViewById(R.id.map);
        this.mMapView.onCreate(null);
        this.mMapView.onResume();
        this.mMapView.getMapAsync(this);
    }


}
