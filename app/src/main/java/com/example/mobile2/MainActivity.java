package com.example.mobile2;

import android.os.Bundle;

import android.widget.ImageView;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.Rotate;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView=findViewById(R.id.imageView3);
        Glide.with(this)
                .load( "https://upload.wikimedia.org/wikipedia/commons/9/98/Logo_udinus1.jpg")
                .error(R.drawable.ic_launcher_background)
                .centerCrop()
//                .apply(new RequestOptions().transform(new Rotate(270),
//                        new CircleCrop()))
                .apply(RequestOptions.circleCropTransform())
                .apply(new RequestOptions().override(1500,1500))
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .into(imageView);

    }
}