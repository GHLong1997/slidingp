package vn.linh.androidslidingpanelayout.normalslidemenu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import vn.linh.androidslidingpanelayout.R;
import vn.linh.androidslidingpanelayout.slidemenuwithrecycler.adapter.MenuAdapter;
import vn.linh.androidslidingpanelayout.slidemenuwithrecycler.adapter.MenuItem;

public class Fragment1 extends Fragment implements OnFocusChangeListener
{

    View mView;
    RecyclerView rc;

    public static Fragment1 newInstance() {
        Bundle args = new Bundle();
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        rc = view.findViewById(R.id.rc_horizontal);
        MenuAdapter menuAdapter = new MenuAdapter();

        menuAdapter.setData(adapters());
//        rc.setAdapter(menuAdapter);
//        mView = view;
        return view;
    }

    private List<MenuItem> adapters() {
        return new ArrayList<MenuItem>() {{
            add(new MenuItem("1"));
            add(new MenuItem("2"));
            add(new MenuItem("3"));
            add(new MenuItem("4"));
        }};
    }

    @Override
    public void onFocus(View view) {
//        mView.findViewById(R.id.ln).requestFocus();
//        rc.requestFocus();
    }
}
