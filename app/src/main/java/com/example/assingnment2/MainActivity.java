package com.example.assingnment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView quantityTextView;
    private TextView priceTextView;
    private RatingBar ratingBar;
    private int quantity = 0;
    private static final int PRICE_PER_ITEM = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = findViewById(R.id.quantityTextView);
        priceTextView = findViewById(R.id.priceTextView);
        ratingBar = findViewById(R.id.ratingBar);

        Button incrementButton = findViewById(R.id.increment);
        Button decrementButton = findViewById(R.id.decrement);
        Button orderButton = findViewById(R.id.order_btn);

        incrementButton.setOnClickListener(v -> {
            quantity++;
            updateUI();
        });

        decrementButton.setOnClickListener(v -> {
            if (quantity > 0) {
                quantity--;
                updateUI();
            }
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            TextView ratingTextView = findViewById(R.id.rating);
            ratingTextView.setText("Rating: " + rating);
        });

        orderButton.setOnClickListener(v -> {
            // Handle the order placement logic here
        });
    }

    private void updateUI() {
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText("BDT " + (quantity * PRICE_PER_ITEM));
    }
}
