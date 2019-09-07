package broken;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author javie
 * @date 2019/8/2 11:13
 */
public class SimpleClassLoader extends ClassLoader{

    private final static String DEFAULT_DIR = "F:\\JavaDocuments\\app\\classloader1";

    public String dir = DEFAULT_DIR;

    private String classLoaderName;


    public SimpleClassLoader() {
    }

    public SimpleClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public SimpleClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public void setDir(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;

        if (name.startsWith("java.")){
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                clazz = systemClassLoader.loadClass(name);
                if (clazz!=null){
                    if(resolve){
                        resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (Exception e){

            }
        }
        try {
            clazz = findClass(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (clazz == null){
            getParent().loadClass(name);
        }

        return clazz;
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
