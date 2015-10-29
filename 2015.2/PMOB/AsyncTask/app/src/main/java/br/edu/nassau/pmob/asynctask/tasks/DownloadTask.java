package br.edu.nassau.pmob.asynctask.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dhiego on 28/10/15.
 */

/**
 * 1- String - Tipo dos parâmetros de entrada
 * 2- String - Tipo de entrada do onProgressUpdate
 * 3- Bitmap - Retorno da execução
 */
public class DownloadTask extends AsyncTask<String, String, Bitmap>{

    //É necessario o context pois é utilizado no ProgressDialog. É recebido no construtor.
    private Context context;
    private ProgressDialog progress;

    public DownloadTask(){

    }

    public DownloadTask(Context context){
        this.context = context;
    }

    /**
     * Executado na main thread
     */
    @Override
    protected void onPreExecute() {
        if(this.context != null){
            progress = new ProgressDialog(this.context);
            progress.setMessage("Carregando...");
            progress.show();
        }
    }

    /**
     * Executado na background thread
     */
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap image = null;
        try{
            publishProgress("Ainda carregando");
            URL url = new URL("http://www.dhiegoabrantes.com/images/android.png");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            image = BitmapFactory.decodeStream(is);
            publishProgress("Concluído!");
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        if(progress != null)
            progress.setMessage(values[0]);
    }

    /**
     * Executado na main thread
     */
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(progress != null)
            progress.dismiss();
    }
}
