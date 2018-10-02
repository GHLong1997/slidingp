package vn.linh.androidslidingpanelayout.slidemenuwithrecycler.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import vn.linh.androidslidingpanelayout.R;
import vn.linh.androidslidingpanelayout.normalslidemenu.fragment.OnFocusChangeListener;
import vn.linh.androidslidingpanelayout.normalslidemenu.fragment.OnFocusChangeListener1;

public class MenuAdapter extends RecyclerView.Adapter {
    private List<MenuItem> data;
    private OnFocusChangeListener1 mOnFocusChangeListener;

    public void setData(List<MenuItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(OnFocusChangeListener1 focusChangeListener) {
        mOnFocusChangeListener = focusChangeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_menu, viewGroup, false);
        return new ItemViewHolder(v, mOnFocusChangeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((ItemViewHolder) viewHolder).textTitle.setText(data.get(position).title);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private OnFocusChangeListener1 onFocusChangeListener;
        TextView textTitle;

        public ItemViewHolder(@NonNull View itemView, OnFocusChangeListener1 focusChangeListener) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            onFocusChangeListener = focusChangeListener;
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus && onFocusChangeListener!= null) {
                        onFocusChangeListener.onFocus(v);
                    }
                }
            });
        }
    }
}
