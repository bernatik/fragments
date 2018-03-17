package com.alexbernat.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Scene defaultScene;
    Scene opened2Frame;
    Scene opened3Frame;
    Transition changeBoundsTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.layout_with_scenes);

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        defaultScene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_default, this);
        opened2Frame = Scene.getSceneForLayout(sceneRoot, R.layout.scene_2fr_opened, this);
        opened3Frame = Scene.getSceneForLayout(sceneRoot, R.layout.scene_3fr_opened, this);

        changeBoundsTransition =
                TransitionInflater.from(this)
                        .inflateTransition(R.transition.change_bounds_transition);
    }

    public void goTo2FrOpenedScene(View view) {
        Log.e("Click f2", "f2");
        TransitionManager.go(opened2Frame, changeBoundsTransition);
    }

    public void goTo3FrOpenedScene(View view) {
        Log.e("Click f3", "f3");
        TransitionManager.go(opened3Frame, changeBoundsTransition);
    }

    public void goToDefaultScene(View view) {
        Log.e("Click f1", "f1");
        TransitionManager.go(defaultScene, changeBoundsTransition);
    }
}
