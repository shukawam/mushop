package com.oracle.jp.mushop.catalogue.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SizeProducts {

    @NotNull
    @Pattern(regexp = "^[0-9]\\d*$")
    private Long size;

    @Max(value = 100)
    private String err;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    @Override
    public String toString() {
        return "SizeProducts [size=" + size + ", err=" + err + "]";
    }

}
