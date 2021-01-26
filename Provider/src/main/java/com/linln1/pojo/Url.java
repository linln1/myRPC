package com.linln1.pojo;

public class Url {
    private String hostname;
    private Integer port;

    public Url(String hostname, Integer port){
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(!(o instanceof Url)){
            return false;
        }
        Url url = (Url) o;
        if(hostname.equals(url.getHostname()) && port.intValue() == url.port.intValue()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hostname.hashCode();
    }
}
