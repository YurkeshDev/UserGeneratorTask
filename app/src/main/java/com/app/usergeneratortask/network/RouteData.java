package com.app.usergeneratortask.network;

import com.app.usergeneratortask.models.Result;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class RouteData {

    @SerializedName("results")
    private List<Result> mResults;

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

}
