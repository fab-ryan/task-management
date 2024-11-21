package com.task_management.utils;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseDto<T> {
    private String message;
    private boolean status;
    private HttpStatus httpStatus = HttpStatus.OK;
    private String date;
    private String url;

    @JsonIgnore
    private T data;

    @JsonIgnore
    private Map<String, Object> dynamicData = new HashMap<>();


    public ResponseDto(String message, T data, boolean status, HttpStatus httpStatus , String dataKey) {
        this.message = message;
        this.data = data;
        this.status = status;
        this.httpStatus = httpStatus;
        this.date = LocalDateTime.now().toString();
        this.url = null;
        dynamicData.put(dataKey != null && !dataKey.isEmpty() ? dataKey : "data", data);

    }

    public static <T> ResponseDto<T> createResponse(
            String message,
            T data,
            boolean status,
            HttpStatus httpStatus,
            HttpServletRequest request,
            String dataKey

    ) {

        ResponseDto<T> response = new ResponseDto<>(message, data, status, httpStatus , dataKey);
        response.url = request.getRequestURL().toString();
        return response;
    }

    public void setDataWithKey(String key, T data) {
        dynamicData.clear(); // Clear previous data
        dynamicData.put(key, data);
    }

    @JsonAnyGetter
    public Map<String, Object> getDynamicData() {
        return dynamicData;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", httpStatus=" + httpStatus +
                ", date='" + date + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}

