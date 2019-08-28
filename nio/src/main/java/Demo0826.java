import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

/**
 * @author javie
 * @date 2019/8/26 0:44
 */
public class Demo0826 {

    /**
     * 分散读取
     */
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo2.jpg", "rw");

        FileChannel channel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer[] bufs = {buffer,buffer1};
        channel.read(bufs);

        for (ByteBuffer b : bufs){
            b.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("-----------------------------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

    }

    /**
     * 通道之间的数据传输(使用直接缓冲区)
     */
    @Test
    public void test3() throws Exception {
        FileChannel inChannel = FileChannel.open(
                Paths.get("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo2.jpg"),
                StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(
                Paths.get("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo3.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE);

        // inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    /**
     * 使用直接缓冲区,只支持ByteBuffer
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        FileChannel inChannel = FileChannel.open(
                Paths.get("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo2.jpg"),
                StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(
                Paths.get("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo3.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE);
        // 内存映射文件,直接操作缓冲区
        MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());

        // 直接对缓冲区对数据进行读写操作
        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);
        inChannel.close();
        outChannel.close();


    }


    /**
     * 非直接缓冲区
     * @throws Exception
     */
    @Test
    public  void test1() throws Exception {

        FileInputStream fis = new FileInputStream("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo2.jpg");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer)!=-1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        inChannel.close();
        outChannel.close();
        fis.close();
        fos.close();
    }
}
