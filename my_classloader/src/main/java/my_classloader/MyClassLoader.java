package my_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author javie
 * @date 2019/8/2 11:13
 */
public class MyClassLoader extends ClassLoader{

    private final static String DEFAULT_DIR = "F:\\JavaDocuments\\app\\classloader1";

    public String dir = DEFAULT_DIR;

    private String classLoaderName;


    public MyClassLoader() {
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public void setDir(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    /**
     * xxx.xxx.xxx.A
     * xxx/xxx/xxx/A.class
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir,classPath+".class");
        if (!classFile.exists()){
            throw new ClassNotFoundException("Class "+name+" not found under "+this.dir+"...");
        }

        byte[] classBytes = loadClassBytes(classFile);
        if (classBytes == null || classBytes.length==0){
            throw new ClassNotFoundException("Load class "+name+" fail. ");
        }

        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            FileInputStream fis = new FileInputStream(classFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
