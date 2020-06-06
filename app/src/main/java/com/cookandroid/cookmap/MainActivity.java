package com.cookandroid.cookmap;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    MapFragment mapFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구글 지도 활용");
        mapFrag = (MapFragment) getFragmentManager()/findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom) (new LatLng (37.568256, 126.897240), 150));
    }

    public boolean onCreateOptionsMenu( Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0, "위성지도");
        menu.add(0,2,0, "일반지도");
        menu.add(0,3,0 , "월드컵경기장 바로가기");
        return true;
    }
    @Override
    public boolean onOptionsItemSelecteD(MenuItem item){
        switch( item.getItemId()){
            case1 :
            gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            returm true;

            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NROMAL);
                return true;
                case3:
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.568256, 126.897240), 15))
;
            return true;

        }

return false;
}
