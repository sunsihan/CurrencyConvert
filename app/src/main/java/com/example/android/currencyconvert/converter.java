package com.example.android.currencyconvert;



public class converter {
    public final static float convertUSDtoBTC(float USD) {

        float BTC = (float) (USD * (1/3416.01));
        return BTC;
    }

    public final static float convertBTCtoUSD(float BTC) {
        float USD = (float) (BTC *3416.01);
        return USD;
    }

    public final static float convertUSDtoDOGE(float USD) {
        float DOGE = (float) (USD * (1/0.00188));
        return DOGE;
    }


    public final static float convertDOGEtoUSD(float DOGE) {
        float USD = (float) (DOGE *0.00188);
        return USD;
    }

    public final static float convertDOGEtoBTC(float DOGE) {
        float BTC = (float) (DOGE *(1/1897783.33));
        return BTC;
    }

    public final static float convertBTCtoDOGE(float BTC) {
        float DOGE = (float) (BTC * 1897783.33);
        return DOGE;
    }

}


