package com.jianyan.android.burglaralarm.fragment;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.jianyan.android.burglaralarm.adapter.MyPhoneAdapter;
import com.jianyan.android.burglaralarm.bean.MyPhone;

import java.util.ArrayList;

public class PhoneStateFragment extends ListFragment {
    private static final String TAG = PhoneStateFragment.class.getName();

    private static final int DIVIDER_HEIGHT = 80;

    private LocationManager mLocationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<MyPhone> myPhoneArrayList = new ArrayList<>();
        myPhoneArrayList.add(new MyPhone("Phone1"));
        myPhoneArrayList.add(new MyPhone("Phone2"));
        myPhoneArrayList.add(new MyPhone("Phone3"));
        MyPhoneAdapter myPhoneAdapter = new MyPhoneAdapter(getActivity(), myPhoneArrayList);
        setListAdapter(myPhoneAdapter);

        // 创建LocationManager对象
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        // 从GPS获取最近的最近的定位信息
        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        // 使用location根据EditText的显示
        updateView(location);
        // 设置每2秒获取一次GPS的定位信息
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 8, new LocationListener() {
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            public void onProviderDisabled(String provider) {
                updateView(null);
            }

            // 当GPS LocationProvider可用时，更新位置
            public void onProviderEnabled(String provider) {
                updateView(mLocationManager.getLastKnownLocation(provider));
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView lv = getListView();
        lv.getDivider().setAlpha(0);
        lv.setDividerHeight(DIVIDER_HEIGHT);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    }

    // 更新EditText中显示的内容
    public void updateView(Location newLocation)
    {
        if (newLocation != null)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("实时的位置信息：\n");
            sb.append("经度：");
            sb.append(newLocation.getLongitude());
            sb.append("\n纬度：");
            sb.append(newLocation.getLatitude());
            sb.append("\n高度：");
            sb.append(newLocation.getAltitude());
            sb.append("\n速度：");
            sb.append(newLocation.getSpeed());
            sb.append("\n方向：");
            sb.append(newLocation.getBearing());
            Log.i(TAG, sb.toString());




            // new Task().exclude();
        }
        else
        {
            Log.i(TAG, "没有获取到实时的位置信息！");
        }
    }
}
