package com.example.eventhallbooking.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventhallbooking.ClickedItemActivity;
import com.example.eventhallbooking.R;

import java.util.Objects;

public class HallViewActivity extends Fragment {

    GridView gridView;
    int[] images;
    String[] names;

    HallViewActivity(int[] images, String[] names) {
        this.images = images;
        this.names = names;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_hall_view, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter(images,names,
                Objects.requireNonNull(getContext()));
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names[position];
                int selectedImage = images[position];
                startActivity(new Intent(view.getContext(), ClickedItemActivity.class).putExtra(
                        "name",selectedName).putExtra("image",selectedImage));
            }
        });

        return view;
    }

    public class CustomAdapter extends BaseAdapter {
        private int[] images;
        private String[] image_names;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(int[] images, String[] image_names, Context context) {
            this.images = images;
            this.image_names = image_names;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.row_items, parent, false);

            }
            ImageView imagePhoto= convertView.findViewById(R.id.imageView);
            TextView tvName = convertView.findViewById(R.id.tvName);
            imagePhoto.setImageResource(images[position]);
            tvName.setText(image_names[position]);
            return convertView;
        }
    }
}
