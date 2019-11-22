package guitar.academyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class DriveActivity extends AppCompatActivity {
    TMapView tMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("c12f44ac-89a3-4580-993b-44df9a168afd");
        LinearLayout linearLayoutTmap = (LinearLayout) findViewById(R.id.linearLayoutTmap);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.busicon);

        TMapPoint tmapPointNamsan = new TMapPoint(37.551135, 126.988205); // 남산타워
        TMapPoint tMapPointJongkak = new TMapPoint(37.570841, 126.985302); // 종각역

        linearLayoutTmap.addView(tMapView);
        tMapView.setCenterPoint(126.988205, 37.551135);
        tMapView.MapZoomOut();
        tMapView.MapZoomOut();

        tMapView.addTMapPolyLine("firstpath", findPath(tmapPointNamsan, tMapPointJongkak));
//        tMapView.addMarkerItem("markeritem", createMarker(bitmap, 0.5f, 1, tmapPointNamsan)); // create marker
//        new Thread() {
//            TMapPoint startpoint = new TMapPoint(37.5248, 126.93);
//            TMapPoint endpoint = new TMapPoint(37.4601, 128.0428);
//
//            public void run() {
//                findPath(startpoint, endpoint);
//            }
//        }.start();

        tMapView.setOnClickListenerCallBack(new TMapView.OnClickListenerCallback() {
            public boolean onPressEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                //Toast.makeText(MapEvent.this, "onPress~!", Toast.LENGTH_SHORT).show();
                return false;
            }

        @Override
            public boolean onPressUpEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
             //Toast.makeText(MapEvent.this, "onPressUp~!", Toast.LENGTH_SHORT).show();
              return false;
            }
        });
    }

    public TMapPolyLine findPath(TMapPoint startpoint, TMapPoint endpoint){
        TMapPolyLine tMapPolyLine = null;
        try {
            tMapPolyLine = new TMapData().findPathData(startpoint, endpoint);
            if(tMapPolyLine.getLinePoint().isEmpty())
                Log.d("test", "empty");
            else
                Log.d("test", Integer.toString(tMapPolyLine.getLinePoint().size()));

            tMapPolyLine.setLineColor(Color.BLUE);
            tMapPolyLine.setLineWidth(5);
            return tMapPolyLine;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tMapPolyLine;
    }

    public TMapMarkerItem createMarker(Bitmap icon, float pivotX, float pivotY, TMapPoint point){
        TMapMarkerItem markerItem = new TMapMarkerItem();
        markerItem.setIcon(icon);
        markerItem.setPosition(pivotX, pivotY); // 마커의 중심점을 중앙, 하단으로 설정
        markerItem.setTMapPoint(point); // 마커의 좌표 지정
        markerItem.setName("namsan"); // 마커의 타이틀 지정

        return markerItem;
    }
}
