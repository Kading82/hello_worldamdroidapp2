package com.example.august.hello_world;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static org.junit.Assert.*;

public class Main2ActivityTest {

    private Resources resources

    public boolean matchesSafely(View view) {
        this.resources = view.getResources();

        if (childView == null) {
            RecyclerView recyclerView =
                    (RecyclerView) view.getRootView().findViewById(recyclerViewId);
            if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                RecyclerView.ViewHolder viewHolder =
                        recyclerView.findViewHolderForAdapterPosition(position);
                if (viewHolder != null) {
                    childView = viewHolder.itemView;
                }
            }
            else {
                return false;
            }
        }

        if (targetViewId == -1) {
            return view == childView;
        } else {
            View targetView = childView.findViewById(targetViewId);
            return view == targetView;
        }
    }

}