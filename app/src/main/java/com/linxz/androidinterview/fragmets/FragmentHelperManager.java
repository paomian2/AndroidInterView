package com.linxz.androidinterview.fragmets;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.Stack;

/**
 * @author Linxz
 * 创建日期：2021年05月27日 2:35 PM
 * version：
 * 描述：
 */
public class FragmentHelperManager {

    private static FragmentHelperManager instance;

    private Stack<Fragment> fragments = new Stack<>();

    private FragmentHelperManager(){}

    public static FragmentHelperManager getInstance(){
        if (instance == null){
            instance = new FragmentHelperManager();
        }
        return instance;
    }

    public void push(Fragment fragment){
        fragments.push(fragment);
    }

    public void pop(AppCompatActivity activity){
       Fragment fragment = fragments.pop();
       activity.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
