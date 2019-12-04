package VO;

import com.google.gson.annotations.SerializedName;

public class UserLoginResponse {

    @SerializedName("ResultCode")
    public String resultCode;

    @SerializedName("Message")
    public String message;

    @SerializedName("StatusCode")
    public int statusCode;

    @SerializedName("Response")
    public Response response;

    public class Response {

        @SerializedName("msg")
        public String msg;

        @SerializedName("y_tkn")
        public String y_tkn;
    }
}

