
package Vjezba2;


public
class myCRC32 implements myChecksum {
    private int crc;

 
    public myCRC32() {
    }
    
    private static int[] crc_table = make_crc_table();
    
    private static int[] make_crc_table () {
        int[] crc_table = new int[256];
        for (int n = 0; n < 256; n++){
            int c = n;
            for(int k = 8;  --k >= 0;) {
                if ((c & 1) != 0)
                    c = 0xedb88320 ^ (c >>> 1);
                else
                    c = c >>> 1;
            }
            crc_table[n] = c;
        }
        return crc_table;
    }

    public void update (int bval) {
        int c = ~crc;
        c = crc_table[(c ^ bval) & 0xff] ^ (c >>> 8);
        crc = ~c;
    }

    
    public void update(byte[] b, int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        crc=updateBytes(crc,b,off,len);
    }

    public void update(byte[] b) {
        crc = updateBytes(crc, b, 0, b.length);
    }

    public void reset() {
        crc = 0;
    }

    public long getValue() {
        return (long)crc & 0xffffffffL;
    }

    private int updateBytes(int crc, byte[] b, int off, int len){

            crc  = 0xFFFFFFFF;       
            int poly = 0xEDB88320;   

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

}