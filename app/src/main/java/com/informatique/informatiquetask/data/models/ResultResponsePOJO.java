package com.informatique.informatiquetask.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class ResultResponsePOJO {
    @SerializedName("result")
    @Expose
    private ResultObjectPOJO result;

    /**
     * No args constructor for use in serialization
     */
    public ResultResponsePOJO() {
    }

    /**
     * @param result
     */
    public ResultResponsePOJO(ResultObjectPOJO result) {
        super();
        this.result = result;
    }

    public ResultObjectPOJO getResult() {
        return result;
    }

    public void setResult(ResultObjectPOJO result) {
        this.result = result;
    }

}
