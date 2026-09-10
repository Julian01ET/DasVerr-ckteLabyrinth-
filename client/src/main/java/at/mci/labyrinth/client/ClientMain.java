package at.mci.labyrinth.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Startpunkt des verpflichtenden Desktop-Clients. Baut aktuell nur die TCP-Verbindung auf -
 * das eigentliche Nachrichtenformat folgt, sobald der gruppenübergreifende Kommunikationsstandard
 * feststeht (siehe docs/protokoll-entwurf.md und Lastenheft Kapitel 5).
 */
public final class ClientMain {

    private static final int DEFAULT_PORT = 5000;

    private ClientMain() {
    }

    public static void main(String[] args) throws IOException {
        String host = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PORT;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Mit Server verbunden: " + socket.getRemoteSocketAddress());
        }
    }
}
