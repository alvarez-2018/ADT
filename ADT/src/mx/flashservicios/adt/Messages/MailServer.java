/*
 * MailServer.java
 */
package mx.flashservicios.adt.Messages;

/**
 *
 * @author giancarlo
 */
public class MailServer {
    private int port;
    private String host;
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}