package alim.math.coders;

public final class Gray {

    /**
     * Function to code to Gray's code
     *
     * @param x to code
     * @return result of the coding
     */
    public static int codeGray(int x) {
        return (x > 0) ? x ^ (x >> 1) : 0;
    }

    /**
     * Encode from Gray's code
     *
     * @param binaryX binary presentation of x to encode ("110011")
     * @return result of the encoding
     */
    public static int encodeGray(String binaryX) {
        long x = Long.parseLong(binaryX, 2);
        return encodeGray((int) x);
    }

    /**
     * Encode from Gray's code with beautiful string presentation
     *
     * @param binaryX binary presentation of x to encode ("110011")
     * @param buffer  to save result
     * @return result in the string's format
     */
    public static StringBuffer encodeGray(String binaryX, StringBuffer buffer) {
        long x = Long.parseLong(binaryX, 2);
        return encodeGray((int) x, buffer);
    }

    /**
     * Fast Encode from Gary's code
     *
     * @param x to encode
     * @return result of the encoding
     */
    public static int encodeGray(int x) {
        int b;
        for (b = 0; x > 0; x >>= 1) {
            b ^= x;
        }
        return b;
    }

    /**
     * Encode from Gray's code with beautiful string presentation
     *
     * @param x      to encode
     * @param buffer to save result
     * @return result of the encoding
     */
    public static StringBuffer encodeGray(int x, StringBuffer buffer) {
        if (x <= 0) return buffer.append("0\n");

        int b = 0;
        int length = Integer.toBinaryString(x).length();

        for (int i = 0; x > 0; x >>= 1, ++i) {
            String rightX = Integer.toBinaryString(x);

            int countZero = length - rightX.length();
            buffer.append("0".repeat(Math.max(0, countZero)));

            buffer.append(rightX).append("\n");
            b ^= x;
        }
        buffer.append("-".repeat(length)).append("\n");
        buffer.append(String.format("%s\n", Integer.toBinaryString(b)));

        return buffer;
    }
}
