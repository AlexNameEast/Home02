package com.example.home02.domain;

import androidx.annotation.StyleRes;

import com.example.home02.R;

public enum Theme {

    ONE(R.style.Theme_Home02, "one", R.string.theme_one),
    TWO(R.style.Theme_Home02V2, "two", R.string.theme_two),
    TREE(R.style.Theme_Home02V3, "tree", R.string.theme_tree);

    private int style;
    private String key;

    @StyleRes
    private final int title;

    Theme(int style, String key, int title) {
        this.style = style;
        this.key = key;
        this.title = title;
    }

    public int getStyle() {
        return style;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }
}
