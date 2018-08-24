package com.zhangcf.one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) throws IOException {
        Charset latin1 = Charset.forName( "ISO-8859-1" );
        CharsetDecoder decoder = latin1.newDecoder();
        CharsetEncoder encoder = latin1.newEncoder();


        FileInputStream file = new FileInputStream("d:\\test.txt");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            int r = channel.read(buffer);
            CharBuffer charBuffer = decoder.decode(buffer);

            if (r == -1){
                break;
            }
//            for (int i = 0; i < 1024; i++) {
//                System.out.print(buffer.get(i));
//            }
        }

    }
}
