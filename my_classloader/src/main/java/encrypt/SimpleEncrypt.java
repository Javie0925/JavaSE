package encrypt;

import sun.net.www.content.text.plain;

/**
 * @author javie
 * @date 2019/8/3 14:56
 */
public class SimpleEncrypt {

    private final static String plain = "hello classload";

    private static final byte ENCRYPT_FACTOR = (byte)0xff;

    public static void main(String[] args) {

        byte[] bytes = plain.getBytes();

        byte[] encrypt = new byte[bytes.length];

        for (int i = 0;i<encrypt.length;i++){
            encrypt[i] = ((byte) (bytes[i] ^ ENCRYPT_FACTOR));

        }
        System.out.println(new String(encrypt));


    }
}
