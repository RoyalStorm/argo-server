package com.arrayteam.argo.server.dao.response;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;


@Data
public class Response<T, R extends Response<T, ?>> {

    @JsonBackReference
    protected final R self;

    protected Integer count;
    protected Boolean success;
    protected Integer status;
    protected String message;
    protected List<T> data;

    protected Response(final Class<R> selfClass) {
        this.self = selfClass.cast(this);
    }

    public R ok(String message) {
        this.setSuccess(true);
        this.setStatus(HttpStatus.OK.value());
        this.setMessage(message);

        return self;
    }

    public R success(T object) {
        this.setData(Collections.singletonList(object));

        return this.success();
    }

    public R success() {
        this.setSuccess(true);
        this.setStatus(HttpStatus.OK.value());

        if (this.data != null)
            this.setCount(this.data.size());

        return self;
    }

    public R success(List<T> objects) {
        this.setData(objects);

        return this.success();
    }

    public R empty() {
        this.setSuccess(true);
        this.setStatus(HttpStatus.NO_CONTENT.value());

        return self;
    }

    public R error(HttpStatus errorStatus, String errorMessage) {
        this.setSuccess(false);
        this.setStatus(errorStatus.value());
        this.setMessage(errorMessage);

        return self;
    }

}
