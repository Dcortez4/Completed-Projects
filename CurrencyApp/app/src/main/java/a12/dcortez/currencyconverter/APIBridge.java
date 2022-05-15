package a12.dcortez.currencyconverter;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//This APIBridge was modeled after the one made for the weather tracker android app
public class APIBridge {
    private String apiKey, currencyURL;
    private CurrencyModel currencyModel = new CurrencyModel();
    private UIBind uiBind;
    private RequestQueue queue;

    public APIBridge(UIBind uiBind, Context context){
        this.uiBind = uiBind;
        this.queue = Volley.newRequestQueue(context);

        String apiJson = null;
        try{
            InputStream is = context.getAssets().open("api.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            apiJson = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retrieves data from the api.json file so we can do calls
        try{
            JSONObject jsonObject = new JSONObject(apiJson);
            this.apiKey = jsonObject.getString("apikey");
            this.currencyURL = jsonObject.getString("currencyURL");
            Log.i("JSON", "We have a json Object!");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void getCurrency(String cur1, String cur2, String original){
        String url = String.format(this.currencyURL, this.apiKey, cur1, cur2, original);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject tmp = new JSONObject(response);
                            JSONObject rates = tmp.getJSONObject("rates");
                            // Had to make one off rates itself since apparently this API has them
                            // Within each other hence why I had to make two JSONObjects
                            JSONObject type = rates.getJSONObject(cur2);
                            // This line retrieves the update date for the rate done from tmp
                            currencyModel.setUpdate(tmp.getString("updated_date"));
                            // This line retrieves the converted amount from the type JSONObject
                            currencyModel.setResult(type.getDouble("rate_for_amount"));
                            // Retrieves the rate being used on the amount from the "type" JSONObject
                            currencyModel.setRate(type.getDouble("rate"));

                            uiBind.mapUI(currencyModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Rest", error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}

