package com.shenby.grfa1;

public class CustomApi implements ICustomApi {

    @Override
    public String getText() {
        return "Api24";
    }

    @Override
    public int getVersion() {
        return 24;
    }
}
