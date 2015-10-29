package br.edu.nassau.pmob.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import br.edu.nassau.pmob.asynctask.tasks.AcessWSTask;
import br.edu.nassau.pmob.asynctask.tasks.DownloadTask;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new android.os.Handler();
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.iv = (ImageView) findViewById(R.id.imageView);
        Button buttonMainThread = (Button) findViewById(R.id.buttonMainThread);
        Button buttonAnotherThread = (Button) findViewById(R.id.buttonAnotherThread);
        Button downloadImageAtOtherThreadUsingHandler = (Button) findViewById(R.id.downloadImageAtOtherThreadUsingHandler);
        Button downloadImageUsingAsyncTask = (Button) findViewById(R.id.downloadImageUsingAsyncTask);


        buttonMainThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(null);
                downloadImageAtMainThread();
            }
        });

        buttonAnotherThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(null);
                downloadImageAtOtherThread();
            }
        });

        downloadImageAtOtherThreadUsingHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(null);
                downloadImageAtOtherThreadUsingHandler();
            }
        });

        downloadImageUsingAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageBitmap(null);
                downloadImageUsingAsyncTask();
            }
        });
    }

    /**
     * O código abaixo faz a tentativa de utilizar a thread principal da aplicação para acessar um recurso de rede.
     *
     */
    public void downloadImageAtMainThread(){
        try{
            URL url = new URL("http://www.dhiegoabrantes.com/images/android.png");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);

            InputStream is = connection.getInputStream();
            Bitmap image = BitmapFactory.decodeStream(is);

            final ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageBitmap(image);
        }catch(Exception ex){
            ex.printStackTrace();
            Toast.makeText(this, "Erro ao executar downloadImageAtMainThread()", Toast.LENGTH_LONG).show();
//            10-28 12:01:09.960 2479-2479/br.edu.nassau.pmob.asynctask W/System.err: android.os.NetworkOnMainThreadException
//            10-28 12:01:09.970 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.os.StrictMode$AndroidBlockGuardPolicy.onNetwork(StrictMode.java:1156)
//            10-28 12:01:09.970 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at java.net.InetAddress.lookupHostByName(InetAddress.java:418)
//            10-28 12:01:09.970 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at java.net.InetAddress.getAllByNameImpl(InetAddress.java:252)
//            10-28 12:01:09.970 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at java.net.InetAddress.getAllByName(InetAddress.java:215)
//            10-28 12:01:09.970 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.HostResolver$1.getAllByName(HostResolver.java:29)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.RouteSelector.resetNextInetSocketAddress(RouteSelector.java:232)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.RouteSelector.next(RouteSelector.java:124)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.HttpEngine.connect(HttpEngine.java:272)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.HttpEngine.sendRequest(HttpEngine.java:211)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.HttpURLConnectionImpl.execute(HttpURLConnectionImpl.java:382)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.HttpURLConnectionImpl.getResponse(HttpURLConnectionImpl.java:332)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.okhttp.internal.http.HttpURLConnectionImpl.getInputStream(HttpURLConnectionImpl.java:199)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at br.edu.nassau.pmob.asynctask.MainActivity.downloadImageAtMainThread(MainActivity.java:43)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at br.edu.nassau.pmob.asynctask.MainActivity$1.onClick(MainActivity.java:27)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.performClick(View.java:4856)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View$PerformClick.run(View.java:19956)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.os.Handler.handleCallback(Handler.java:739)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:95)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.os.Looper.loop(Looper.java:211)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:5373)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at java.lang.reflect.Method.invoke(Method.java:372)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1020)
//            10-28 12:01:09.971 2479-2479/br.edu.nassau.pmob.asynctask W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:815)
        }
    }

    /**
     * O código abaixo faz a tentativa de utilizar a thread principal da aplicação para acessar um recurso de rede.
     *
     */
    public void downloadImageAtOtherThread(){
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url = new URL("http://www.dhiegoabrantes.com/images/android.png");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);

                    InputStream is = connection.getInputStream();
                    Bitmap image = BitmapFactory.decodeStream(is);

                    final ImageView iv = (ImageView) findViewById(R.id.imageView);
                    iv.setImageBitmap(image);
                }catch(Exception ex){
                    ex.printStackTrace();
//                    10-28 11:52:38.520 25288-25804/br.edu.nassau.pmob.asynctask W/System.err: android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
//                    10-28 11:52:38.527 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.ViewRootImpl.checkThread(ViewRootImpl.java:6373)
//                    10-28 11:52:38.527 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.ViewRootImpl.requestLayout(ViewRootImpl.java:878)
//                    10-28 11:52:38.527 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.527 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.view.View.requestLayout(View.java:17566)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.widget.ImageView.setImageDrawable(ImageView.java:454)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at android.widget.ImageView.setImageBitmap(ImageView.java:548)
//                    10-28 11:52:38.528 25288-25804/br.edu.nassau.pmob.asynctask W/System.err:     at br.edu.nassau.pmob.asynctask.MainActivity$2.run(MainActivity.java:49)
                }
            }
        }.start();
    }

    public void downloadImageAtOtherThreadUsingHandler(){
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url = new URL("http://www.dhiegoabrantes.com/images/android.png");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);

                    InputStream is = connection.getInputStream();
                    final Bitmap image = BitmapFactory.decodeStream(is);

                    final ImageView iv = (ImageView) findViewById(R.id.imageView);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(image);
                        }
                    });

//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            iv.setImageBitmap(image);
//                        }
//                    });


                }catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Erro ao executar downloadImageAtOtherThreadUsingHandler()", Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            }
        }.start();
    }

    public void downloadImageUsingAsyncTask(){

        try {
            DownloadTask task = new DownloadTask();
            String url = "";
            Bitmap image = task.execute(url).get();

            iv.setImageBitmap(image);

            AcessWSTask wst = new AcessWSTask();
            String result = wst.execute().get();
            Log.i("async", result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
