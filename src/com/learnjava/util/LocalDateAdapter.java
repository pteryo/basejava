package com.learnjava.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @SuppressWarnings("RedundantThrows")
    @Override
    public LocalDate unmarshal(String str) throws Exception {
        return LocalDate.parse(str);
    }
    @SuppressWarnings("RedundantThrows")
    @Override
    public String marshal(LocalDate ld) throws Exception {
        return ld.toString();
    }
}