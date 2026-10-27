package com.example.scrollview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        TextView scrollingTitle = findViewById(R.id.scrolling_title);
        ViewCompat.setOnApplyWindowInsetsListener(scrollingTitle, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            int paddingStart = v.getPaddingStart();
            int paddingEnd = v.getPaddingEnd();
            float density = getResources().getDisplayMetrics().density;
            int defaultTopBottom = (int) (12 * density);
            v.setPadding(paddingStart, insets.top + defaultTopBottom, paddingEnd, defaultTopBottom);
            return windowInsets;
        });

        TextView articleTextView = findViewById(R.id.article);
        articleTextView.setText(HtmlCompat.fromHtml(getString(R.string.article_text), HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button btnComment = findViewById(R.id.btnComment);
        btnComment.setOnClickListener(v -> {
            Toast.makeText(
                    MainActivity.this,
                    "DODAN KR EN COMMENT:)",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
