package com.dolszewski.blog;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

final class SortCriteria {

    @NotNull
    private SortOrder order;
    @NotBlank
    private String attribute;

    SortCriteria() {
    }

    public SortOrder getOrder() {
        return order;
    }

    public String getAttribute() {
        return attribute;
    }

}
