package com.example.android.currencyconvert;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    RadioGroup radio_from;
    RadioGroup radio_to;
    RadioButton radio_fromUsd, radio_fromBtc, radio_fromDoge;
    RadioButton radio_toUsd, radio_toBtc, radio_toDoge;

    EditText inPutText;
    EditText outPutText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radio_from = findViewById(R.id.fromGroup);
        radio_to = findViewById(R.id.toGroup);
        radio_toUsd = findViewById(R.id.toUSD);
        radio_toBtc = findViewById(R.id.toBTC);
        radio_toDoge = findViewById(R.id.toDOGE);
        inPutText = findViewById(R.id.inPutText);
        outPutText = findViewById(R.id.outPutText);


        //set text change listener

        inPutText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                radio_fromUsd = findViewById(R.id.fromUSD);
                radio_fromBtc = findViewById(R.id.fromBTC);
                radio_fromDoge = findViewById(R.id.fromDOGE);
                radio_toBtc = findViewById(R.id.toBTC);

                //set single from-radio button click listener

                radio_fromUsd.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio_to.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                float temp1 = Float.parseFloat(inPutText.getText().toString());

                                if (radio_toBtc.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertUSDtoBTC(temp1)));
                                } else if (radio_toUsd.isChecked()) {
                                    outPutText.setText(inPutText.getText());

                                } else if (radio_toDoge.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertUSDtoDOGE(temp1)));
                                }
                            }
                        });
                    }
                });

                radio_fromBtc.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        radio_to.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {

                                float temp1 = Float.parseFloat(inPutText.getText().toString());
                                if (radio_toUsd.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertBTCtoUSD(temp1)));
                                } else if (radio_toBtc.isChecked()) {
                                    outPutText.setText(inPutText.getText());

                                } else if (radio_toDoge.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertBTCtoDOGE(temp1)));

                                }

                            }
                        });
                    }
                });


                radio_fromDoge.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        radio_to.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {

                                float temp1 = Float.parseFloat(inPutText.getText().toString());
                                if (radio_toUsd.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertDOGEtoUSD(temp1)));
                                } else if (radio_toDoge.isChecked()) {
                                    outPutText.setText(inPutText.getText());

                                } else if (radio_toBtc.isChecked()) {
                                    outPutText.setText(String.valueOf(converter.convertDOGEtoBTC(temp1)));
                                }
                            }
                        });
                    }
                });
            }
        });
        outPutText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                radio_fromUsd = findViewById(R.id.fromUSD);
                radio_fromBtc = findViewById(R.id.fromBTC);
                radio_fromDoge = findViewById(R.id.fromDOGE);
                radio_toBtc = findViewById(R.id.toBTC);
                radio_toUsd = findViewById(R.id.toUSD);
                radio_toDoge = findViewById(R.id.toDOGE);

                //set single from-radio button click listener

                radio_toUsd.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio_from.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                float temp1 = Float.parseFloat(outPutText.getText().toString());

                                if (radio_fromBtc.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertUSDtoBTC(temp1)));
                                } else if (radio_fromUsd.isChecked()) {
                                    inPutText.setText(outPutText.getText());

                                } else if (radio_fromDoge.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertUSDtoDOGE(temp1)));
                                }
                            }
                        });
                    }
                });

                radio_toBtc.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        radio_from.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {

                                float temp1 = Float.parseFloat(outPutText.getText().toString());
                                if (radio_fromUsd.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertBTCtoUSD(temp1)));
                                } else if (radio_fromBtc.isChecked()) {
                                    inPutText.setText(outPutText.getText());

                                } else if (radio_fromDoge.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertBTCtoDOGE(temp1)));

                                }

                            }
                        });
                    }
                });


                radio_toDoge.setOnClickListener(new RadioButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        radio_from.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {

                                float temp1 = Float.parseFloat(outPutText.getText().toString());
                                if (radio_fromUsd.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertDOGEtoUSD(temp1)));

                                } else if (radio_fromDoge.isChecked()) {
                                    inPutText.setText(outPutText.getText());

                                } else if (radio_fromBtc.isChecked()) {
                                    inPutText.setText(String.valueOf(converter.convertDOGEtoBTC(temp1)));
                                }
                            }
                        });
                    }
                });
            }
        });
    }



    public void displayForText1(int score) {
        EditText display1 = findViewById(R.id.inPutText);
        display1.setText(String.valueOf(score));
    }

    public void displayForText2(int score) {
        EditText display2 = findViewById(R.id.outPutText);
        display2.setText(String.valueOf(score));
    }

    public void Zero(View view) {


        displayForText1(0);
        displayForText2(0);


    }

//API retrive---udacity find the code

//private String TAG = MainActivity.class.getSimpleName();
//public Void getCurrency(Integer view) throws JSONException {

        // Making a request to url and getting response
   //String url = " https://api.coinmarketcap.com/v1/ticker/dogecoin/";
 // JSONObject baseJsonResponse= new JSONObject(url);

//    Log.e(TAG, "Response from url: " + baseJsonResponse);
//  if (baseJsonResponse != null) {
    //     try {

  //      Integer usd = baseJsonResponse.getInt("price_usd");

   //         Integer btc = baseJsonResponse.getInt("price_btc");

 //      } catch (final JSONException e) {
  //        Log.e(TAG, "Json parsing error: " + e.getMessage());
  //   runOnUiThread(new Runnable() {
   //           @Override
   //            public void run() {
    //          Toast.makeText(getApplicationContext(),
    //                        "Json parsing error: " + e.getMessage(),
    //                       Toast.LENGTH_LONG).show();}});}

  //   } else {
   //        Log.e(TAG, "Couldn't get json from server.");
   //      runOnUiThread(new Runnable() {
    //       @Override
    //       public void run() {
      //          Toast.makeText(getApplicationContext(),
       //                  "Couldn't get json from server. Check LogCat for possible errors!",
       //               Toast.LENGTH_LONG).show();}});}
      //                return null;}





}






