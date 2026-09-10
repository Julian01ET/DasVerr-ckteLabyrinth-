package at.mci.labyrinth.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Startpunkt des Spiele-Servers. Nimmt aktuell nur TCP-Verbindungen entgegen und loggt sie -
 * das eigentliche Nachrichtenformat folgt, sobald der gruppenübergreifende Kommunikationsstandard
 * feststeht (siehe docs/protokoll-entwurf.md und Lastenheft Kapitel 5).
 */
public final class ServerMain {

    private static final int DEFAULT_PORT = 5000;

    private ServerMain() {
    }

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Labyrinth-Server gestartet auf Port " + port);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client verbunden: " + client.getRemoteSocketAddress());
            }
        }
    }
}
