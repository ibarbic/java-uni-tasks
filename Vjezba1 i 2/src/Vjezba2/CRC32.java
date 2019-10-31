
package Vjezba2;

public
class CRC32 implements Checksum {
    private int crc;

    /**
     * Creates a new CRC32 object.
     */
    public CRC32() {
    }


    /**
     * Updates the CRC-32 checksum with the specified byte (the low
     * eight bits of the argument b).
     *
     * @param b the byte to update the checksum with
     */
    public void update(int b) {
        crc = update1(crc, b);
    }

    /**
     * Updates the CRC-32 checksum with the specified array of bytes.
     */
    public void update(byte[] b, int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        crc = updateBytes(crc, b, off, len);
    }

    /**
     * Updates the CRC-32 checksum with the specified array of bytes.
     *
     * @param b the array of bytes to update the checksum with
     */
    public void update(byte[] b) {
        crc = updateBytes(crc, b, 0, b.length);
    }

    /**
     * Resets CRC-32 to initial value.
     */
    public void reset() {
        crc = 0;
    }

    /**
     * Returns CRC-32 value.
     */
    public long getValue() {
        return (long)crc & 0xffffffffL;
    }

    private int update1(int crc, int b){
        int poly = 0xEDB88320;
            //byte result[]=intToByteArray(b);
        byte[] result = new byte[1];
        result[0]=(byte)(b & 0xff);
        for (byte a : result) {

            int temp = (crc ^ a) & 0xff;

            for (int i = 0; i < 8; i++) {
                if
                    ((temp & 1) == 1) temp = (temp >>> 1) ^ poly;
                else
                    temp = (temp >>> 1);
            }
            crc = (crc >>> 8) ^ temp;
        }

        crc = crc ^ 0xffffffff;
        return crc;
    }








    private int updateBytes(int crc, byte[] b, int off, int len){

            crc  = 0xFFFFFFFF;       // initial contents of LFBSR
            int poly = 0xEDB88320;   // reverse polynomial

            for (byte a : b) {
                int temp = (crc ^ a) & 0xff;

                for (int i = 0; i < 8; i++) {
                    if ((temp & 1) == 1) temp = (temp >>> 1) ^ poly;
                    else                 temp = (temp >>> 1);
                }
                crc = (crc >>> 8) ^ temp;
            }

            crc = crc ^ 0xffffffff;
            return crc;
    }
    public static final byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
    }

}
