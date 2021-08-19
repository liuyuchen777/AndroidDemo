package liuyuchen.example.AndroidDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWvMain = (WebView) findViewById(R.id.wv);

        // load local html file
        // mWvMain.loadUrl("file:///android_asset/test.html");
        // load network URL
        mWvMain.getSettings().setJavaScriptEnabled(true);
        mWvMain.setWebViewClient(new MyWebViewClient());
        mWvMain.setWebChromeClient(new MyWebChromeClient());
        // web use native function/method
        // mWvMain.addJavascriptInterface();
        mWvMain.loadUrl("https://www.google.com");
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d("WebView", "onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("WebView", "onPageFinished...");
            // native run javascript code
            // mWvMain.loadUrl("javascript:alert('Hello!')");
            // mWvMain.evaluateJavascript("javascript:alert('Hello!')", null);
        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        if (KeyCode == KeyEvent.KEYCODE_BACK && mWvMain.canGoBack()) {
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }
}