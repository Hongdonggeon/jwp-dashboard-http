package org.apache.coyote.http11;

import java.util.LinkedHashMap;
import java.util.Map;

public class HttpHeaders {

    private final Map<String, String> values;

    public HttpHeaders(final Map<String, String> values) {
        this.values = new LinkedHashMap<>(values);
    }

    public void setContentType(final String contentType) {
        values.put("Content-Type", contentType + ";charset=utf-8");
    }

    public void setContentLength(final int contentLength) {
        values.put("Content-Length", String.valueOf(contentLength));
    }

    public String toTextHeader() {
        StringBuilder sb = new StringBuilder();
        for (String s : values.keySet()) {
            sb.append(s).append(": ").append(values.get(s)).append(" \r\n");
        }
        return sb.toString();
    }

    public Map<String, String> getValues() {
        return values;
    }
}
