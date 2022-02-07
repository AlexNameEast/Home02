package com.example.home02.domain;

import com.example.home02.R;

public enum Theme {

    ONE(R.style.Theme_Home02, "one"),
    TWO(R.style.Theme_Home02V2, "two"),
    TREE(R.style.Theme_Home02V3, "tree");

    private int style;
    private String key;

    Theme(int style, String key) {
        this.style = style;
        this.key = key;
    }

    public int getStyle() {
        return style;
    }

    public String getKey() {
        return key;
    }
}
