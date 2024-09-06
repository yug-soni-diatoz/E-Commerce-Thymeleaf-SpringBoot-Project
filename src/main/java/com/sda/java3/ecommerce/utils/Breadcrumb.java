package com.sda.java3.ecommerce.utils;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Breadcrumb {
    protected String url;
    protected String name;
    boolean last = false;

    private static String setString(final String param, final String value) {
        return String.format("set %s \"%s\"\n", param, value);
    }
}
