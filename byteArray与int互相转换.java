public class MyClass {
    public static void main(String args[]) {
      int x=0xfffff0;
      int p=(x)&0xff;
      int y=(x>>8)&0xff;
      int z=(x>>16)&0xff;
      System.out.printf("%s,%s,%s\n", Integer.toBinaryString(y), Integer.toBinaryString(z), Integer.toBinaryString(p));
      //start
      int k=0x0004d5;
      System.out.println(k);//4080
      System.out.println(Integer.toBinaryString(k));
      byte[] b = intToBytes(k);//int转byte[]
      System.out.println(bytesToHexString(b));
      int c = bytesToInt(new byte[]{(byte)0x00,(byte)0x04,(byte)0xd5});//byte[]转int
      System.out.println("c:"+Integer.toBinaryString(c));
      System.out.println("s:"+Integer.toBinaryString((byte)0x0004d5));
      /*int d = bytesToInt(b);//byte[]转int
      System.out.println(d);
      System.out.println(Integer.toBinaryString(d));*/
      //end
    }
    /**
     * byte数组转16进制字符串
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
    //int转为byte数组
    public static byte[] intToBytes(int a) {
        int len = getIntLength16(a);
        byte[] res = new byte[len];
        for(int i=len-1,j=0;i>=0;i--,j++) {
            int r = i*8;
            int z=(a>>r)&0xff;
            //System.out.println(r+"Z:"+Integer.toBinaryString(z));
            res[j] = (byte) z;
            //System.out.println(r+"B:"+Integer.toBinaryString(res[j]));
            //System.out.println(r+"G:"+Integer.toBinaryString(intInactivePositionSet0(res[j])));
        }
        return res;
    }
    //获取int的十六进制长度n（16位*n）
    public static int getIntLength16(int a) {
        int l1 = Integer.toHexString(a).length()/2;
        int l2 = Integer.toHexString(a).length()%2;
        if(l2>0) {
            return l1+1;
        }
        return l1;
    }
    //int(32位)非有效位（前24位）置0(仅保留单个byte)
    public static int int8InactivePositionSet0(int a) {
        if(Integer.toBinaryString(a).length()%8 != 0) {
            //System.out.println(r+"K:"+Integer.toBinaryString(a));
            return a;
        }else {
            //System.out.println(r+"K:"+Integer.toBinaryString(a&0xff));
            return a&0xff;
        }
    }
    //byte转int
    public static int bytesToInt(byte[] bArr) {
        System.out.println(bArr);
        int len = bArr.length;
        int res = 0;
        int rlen = 0;//真实长度
        boolean zeroStarted = false;
        for(int i=0;i<len;i++) {
            int b2 = int8InactivePositionSet0(bArr[i]);
            //System.out.println("I:"+Integer.toBinaryString(b2));
            res = res | b2;
            if(i != len-1) {
                res = res<<8;
            }
            if(b2 != 0) {
                if(zeroStarted) {
                    rlen += 8;
                }else {
                    rlen += Integer.toBinaryString(b2).length();
                }
                if(!zeroStarted) zeroStarted = true;
            }
            //System.out.println("I:"+Integer.toBinaryString(b2));
            //System.out.println("A:"+Integer.toBinaryString(res));
        }
        return int32InactivePositionSet0(res,rlen);
    }
    //int(32位)非有效位置0
    public static int int32InactivePositionSet0(int a, int len) {
        int blen = Integer.toBinaryString(a).length();
        if (len == blen) {
            return a;
        }
        for(int i=len;i<blen;i++){//将len~blen位全部置0
            int c = ~(0x00000001<<i);
            //System.out.println("A:"+Integer.toBinaryString(c));
            a = a&c;
        }
        return a;
    }
}
