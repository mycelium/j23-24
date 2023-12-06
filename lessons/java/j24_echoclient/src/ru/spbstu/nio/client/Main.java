package ru.spbstu.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {
	
	private static SocketChannel client;
	private static ByteBuffer buffer;
	
	public static void main(String[] args) {
		try {
			client = SocketChannel.open(new InetSocketAddress("localhost", 8888));
			sendMessage("Hello");
			sendMessage(" ");
			sendMessage("World");
			sendMessage("POISON_PILL");
			sendMessage("Hack!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        buffer = ByteBuffer.allocate(256);
	}


    public static void stop() throws IOException {
        client.close();
        buffer = null;
    }

    public static String sendMessage(String msg) {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            client.write(buffer);
            buffer.clear();
            client.read(buffer);
            response = new String(buffer.array()).trim();
            System.out.println("response=" + response);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }
}
