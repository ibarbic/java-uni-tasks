package Vjezba2;



public class Test {
    public static void main(String[] args) {

        String str = "Generate CRC32 Checksum For Byte Array Example";
        byte bytes[] = str.getBytes();
        Checksum checksum = new CRC32();

        checksum.update(bytes, 0, bytes.length);
        long lngChecksum = checksum.getValue();
        System.out.println("CRC32 checksum for byte array is:" + lngChecksum);
        checksum.reset();
        checksum.update(5);
        lngChecksum = checksum.getValue();
        System.out.println("CRC32 checksum for byte array is:" + lngChecksum);

    }

}
