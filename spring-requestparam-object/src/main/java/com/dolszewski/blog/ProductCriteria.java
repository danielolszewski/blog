package com.dolszewski.blog;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

final class ProductCriteria {

    @NotBlank
    private String query;
    @Min(0)
    private int offset = 0;
    @Min(1)
    private int limit = 10;
    @NotNull
    @Valid
    private SortCriteria sort;

    private ProductCriteria() {
    }

    public String getQuery() {
        return query;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public SortCriteria getSort() {
        return sort;
    }

}
