package vn.linh.androidslidingpanelayout.slidemenuwithrecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import vn.linh.androidslidingpanelayout.R;
import vn.linh.androidslidingpanelayout.normalslidemenu.fragment.Fragment1;
import vn.linh.androidslidingpanelayout.normalslidemenu.fragment.OnFocusChangeListener;
import vn.linh.androidslidingpanelayout.normalslidemenu.fragment.OnFocusChangeListener1;
import vn.linh.androidslidingpanelayout.slidemenuwithrecycler.adapter.MenuAdapter;
import vn.linh.androidslidingpanelayout.slidemenuwithrecycler.adapter.MenuItem;

public class SlideMenuWithRecyclerActivity extends AppCompatActivity implements
        OnFocusChangeListener1 {

    RecyclerView recyclerViewMenu;
    MenuAdapter menuAdapter;
    FrameLayout frameLayout;
    View mView;
    public boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_menu_with_recycler);
        frameLayout = findViewById(R.id.frame_container);
        recyclerViewMenu = findViewById(R.id.recycler_view_menu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this) {
            @Nullable
            @Override
            public View onInterceptFocusSearch(@NonNull View focused, int direction) {
                if (direction == View.FOCUS_UP) {
                    View view = getChildAt(0);
                    if (view == focused) {
                        return focused;
                    }
                } else if (direction == View.FOCUS_DOWN) {
                    View view = getChildAt(getChildCount() - 1);
                    if (view == focused) {
                        return focused;
                    }
                }
                return super.onInterceptFocusSearch(focused, direction);
            }
        });
        menuAdapter = new MenuAdapter();
        recyclerViewMenu.setAdapter(menuAdapter);

        menuAdapter.setData(adapters());
        menuAdapter.setListener(this);
        replace();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            FrameLayout frameLayout = findViewById(R.id.frame_container);
            frameLayout.requestFocus();
            return false;
        }
        if ( keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
                recyclerViewMenu.getChildViewHolder(mView).itemView.requestFocus();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private List<MenuItem> adapters() {
        return new ArrayList<MenuItem>() {{
            add(new MenuItem("1"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
        }};
    }

    private void replace() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, Fragment1.newInstance(), "sss")
                .commit();
    }

    @Override
    public void onFocus(View view) {
        mView = view;
    }
}
