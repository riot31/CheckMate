package com.springapp.mvc.dao;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public class SearchCriteria {
    private String nameColumn;
    private String value;

    public String getNameColumn() {
        return nameColumn;
    }

    public SearchCriteria(String nameColumn, String value) {
        this.nameColumn = nameColumn;
        this.value = value;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
