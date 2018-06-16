package Server;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;

public final class Converter {

    private static final int BYTES_IN_INT = 4;

    private Converter() {}

    public static byte [] convert(int [] array) {
        if (array.length == 0) {
            return new byte[0];
        }

        return writeInts(array);
    }

    public static int [] convert(DatagramPacket packet) {
        if (packet.getLength() == 0) {
            return new int[0];
        }

        return readInts(packet);
    }

    private static byte [] writeInts(int [] array) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(array.length * 4);
            DataOutputStream dos = new DataOutputStream(bos);
            for (int i = 0; i < array.length; i++) {
                dos.writeInt(array[i]);
            }

            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int [] readInts(DatagramPacket packet) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(packet.getData());
            DataInputStream dataInputStream = new DataInputStream(bis);
            int size = packet.getLength() / BYTES_IN_INT;
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = dataInputStream.readInt();
            }
            return res;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}