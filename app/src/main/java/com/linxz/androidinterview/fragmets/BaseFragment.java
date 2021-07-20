package com.linxz.androidinterview.fragmets;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Linxz
 * 创建日期：2021年05月27日 1:36 PM
 * version：
 * 描述：直接设置在布局上
 */
class BaseFragment extends Fragment {

    private final String TAG="BaseFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()");
        FragmentHelperManager.getInstance().push(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG,"onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG,"onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG,"onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy()");
        super.onDestroy();
    }
}

//布局引入
//2021-05-27 14:54:15.806 9300-9300/com.linxz.streamlet D/BaseFragment: onAttach()
//2021-05-27 14:54:15.806 9300-9300/com.linxz.streamlet D/BaseFragment: onCreate()
//2021-05-27 14:54:15.810 9300-9300/com.linxz.streamlet D/BaseFragment: onViewCreated()
//2021-05-27 14:54:15.818 9300-9300/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 14:54:15.821 9300-9300/com.linxz.streamlet D/BaseFragment: onResume()

//add 第一次
//2021-05-27 14:55:28.795 9300-9300/com.linxz.streamlet D/BaseFragment: onAttach()
//2021-05-27 14:55:28.796 9300-9300/com.linxz.streamlet D/BaseFragment: onCreate()
//2021-05-27 14:55:28.807 9300-9300/com.linxz.streamlet D/BaseFragment: onViewCreated()
//2021-05-27 14:55:28.808 9300-9300/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 14:55:28.808 9300-9300/com.linxz.streamlet D/BaseFragment: onResume()

//add 第二次
//2021-05-27 14:56:13.436 9300-9300/com.linxz.streamlet D/BaseFragment: onAttach()
//2021-05-27 14:56:13.437 9300-9300/com.linxz.streamlet D/BaseFragment: onCreate()
//2021-05-27 14:56:13.453 9300-9300/com.linxz.streamlet D/BaseFragment: onViewCreated()
//2021-05-27 14:56:13.453 9300-9300/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 14:56:13.454 9300-9300/com.linxz.streamlet D/BaseFragment: onResume()


//replace 第一次
//2021-05-27 14:56:39.166 9300-9300/com.linxz.streamlet D/BaseFragment: onAttach()
//2021-05-27 14:56:39.167 9300-9300/com.linxz.streamlet D/BaseFragment: onCreate()
//2021-05-27 14:56:39.179 9300-9300/com.linxz.streamlet D/BaseFragment: onViewCreated()
//2021-05-27 14:56:39.179 9300-9300/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 14:56:39.180 9300-9300/com.linxz.streamlet D/BaseFragment: onResume()

//replace 第二次
//2021-05-27 15:10:37.685 11009-11009/com.linxz.streamlet D/BaseFragment: onAttach()
//2021-05-27 15:10:37.686 11009-11009/com.linxz.streamlet D/BaseFragment: onCreate()
//2021-05-27 15:10:37.687 11009-11009/com.linxz.streamlet D/BaseFragment: onPause()
//2021-05-27 15:10:37.688 11009-11009/com.linxz.streamlet D/BaseFragment: onStop()
//2021-05-27 15:10:37.688 11009-11009/com.linxz.streamlet D/BaseFragment: onDestroyView()
//2021-05-27 15:10:37.692 11009-11009/com.linxz.streamlet D/BaseFragment: onDestroy()
//2021-05-27 15:10:37.704 11009-11009/com.linxz.streamlet D/BaseFragment: onViewCreated()
//2021-05-27 15:10:37.704 11009-11009/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 15:10:37.705 11009-11009/com.linxz.streamlet D/BaseFragment: onResume()

//熄屏后
//2021-05-27 15:04:55.304 11009-11009/com.linxz.streamlet D/BaseFragment: onPause()
//2021-05-27 15:04:55.365 11009-11009/com.linxz.streamlet D/BaseFragment: onStop()

//亮屏后
//2021-05-27 15:05:37.354 11009-11009/com.linxz.streamlet D/BaseFragment: onStart()
//2021-05-27 15:05:37.359 11009-11009/com.linxz.streamlet D/BaseFragment: onResume()

//退栈
//2021-05-27 15:06:47.944 11009-11009/com.linxz.streamlet D/BaseFragment: onPause()
//2021-05-27 15:06:47.945 11009-11009/com.linxz.streamlet D/BaseFragment: onStop()
//2021-05-27 15:06:47.946 11009-11009/com.linxz.streamlet D/BaseFragment: onDestroyView()
//2021-05-27 15:06:47.958 11009-11009/com.linxz.streamlet D/BaseFragment: onDestroy()


