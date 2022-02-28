package temp;


import com.sun.xml.internal.ws.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class TableIndexTest {
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd#HH:mm:ss:SSS";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public TableIndexTest() {
    }

    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();

        try {
            return Integer.parseInt(name.substring(0, name.indexOf(64)));
        } catch (Exception var3) {
            return -1;
        }
    }

    public static String currentStackTrace() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement[] arr$ = stackTrace;
        int len$ = stackTrace.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            StackTraceElement ste = arr$[i$];
            sb.append("\n\t");
            sb.append(ste.toString());
        }

        return sb.toString();
    }

    public static String offset2FileName(long offset) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(20);
        nf.setMaximumFractionDigits(0);
        nf.setGroupingUsed(false);
        return nf.format(offset);
    }

    public static long computeEclipseTimeMilliseconds(long beginTime) {
        return System.currentTimeMillis() - beginTime;
    }

    public static boolean isItTimeToDo(String when) {
        String[] whiles = when.split(";");
        if (whiles != null && whiles.length > 0) {
            Calendar now = Calendar.getInstance();
            String[] arr$ = whiles;
            int len$ = whiles.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String w = arr$[i$];
                int nowHour = Integer.parseInt(w);
                if (nowHour == now.get(11)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String timeMillisToHumanString() {
        return timeMillisToHumanString(System.currentTimeMillis());
    }

    public static String timeMillisToHumanString(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d%02d%02d%02d%02d%02d%03d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13), cal.get(14));
    }

    public static long computNextMorningTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computNextMinutesTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 0);
        cal.add(12, 1);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computNextHourTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 1);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static long computNextHalfHourTimeMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(5, 0);
        cal.add(11, 1);
        cal.set(12, 30);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static String timeMillisToHumanString2(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d-%02d-%02d %02d:%02d:%02d,%03d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13), cal.get(14));
    }

    public static String timeMillisToHumanString3(long t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        return String.format("%04d%02d%02d%02d%02d%02d", cal.get(1), cal.get(2) + 1, cal.get(5), cal.get(11), cal.get(12), cal.get(13));
    }

    public static double getDiskPartitionSpaceUsedPercent(String path) {
        if (null != path && !path.isEmpty()) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    boolean result = file.mkdirs();
                    if (!result) {
                    }
                }

                long totalSpace = file.getTotalSpace();
                long freeSpace = file.getFreeSpace();
                long usedSpace = totalSpace - freeSpace;
                return totalSpace > 0L ? (double)usedSpace / (double)totalSpace : -1.0D;
            } catch (Exception var8) {
                return -1.0D;
            }
        } else {
            return -1.0D;
        }
    }

    public static final long crc32(byte[] array) {
        return array != null ? crc32(array, 0, array.length) : 0L;
    }

    public static final long crc32(byte[] array, int offset, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(array, offset, length);
        return crc32.getValue();
    }

    public static String bytes2string(byte[] src) {
        StringBuilder sb = new StringBuilder();
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    sb.append(0);
                }

                sb.append(hv.toUpperCase());
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static byte[] string2bytes(String hexString) {
        if (hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static byte[] uncompress(byte[] src) throws IOException {
        byte[] uncompressData = new byte[src.length];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);

        try {
            while(true) {
                int len = inflaterInputStream.read(uncompressData, 0, uncompressData.length);
                if (len <= 0) {
                    byteArrayOutputStream.flush();
                    byte[] result = byteArrayOutputStream.toByteArray();
                    return result;
                }

                byteArrayOutputStream.write(uncompressData, 0, len);
            }
        } catch (IOException var20) {
            throw var20;
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException var19) {
            }

            try {
                inflaterInputStream.close();
            } catch (IOException var18) {
            }

            try {
                byteArrayOutputStream.close();
            } catch (IOException var17) {
            }

        }
    }

    public static byte[] compress(byte[] src, int level) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(src.length);
        Deflater deflater = new Deflater(level);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);

        byte[] result;
        try {
            deflaterOutputStream.write(src);
            deflaterOutputStream.finish();
            deflaterOutputStream.close();
            result = byteArrayOutputStream.toByteArray();
        } catch (IOException var14) {
            deflater.end();
            throw var14;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException var13) {
            }

            deflater.end();
        }

        return result;
    }

    public static int asInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception var3) {
            return defaultValue;
        }
    }

    public static long asLong(String str, long defaultValue) {
        try {
            return Long.parseLong(str);
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            return df.parse(date);
        } catch (ParseException var4) {
            return null;
        }
    }

    public static String responseCode2String(int code) {
        return Integer.toString(code);
    }

    public static String frontStringAtLeast(String str, int size) {
        return str != null && str.length() > size ? str.substring(0, size) : str;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static Long getTableIndex(String key) {
        if (null != key && !"".equals(key)) {
            return (crc32(key.toLowerCase().getBytes())) % 1000;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getTableIndex("SF1308932077607"));
    }
}
