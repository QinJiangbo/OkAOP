package com.qinjiangbo.util;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @date: 04/01/2017 11:12 PM
 * @author: qinjiangbo@github.io
 */
public class PackageUtils {

    /**
     * find the class list in the package
     *
     * @param packageName
     * @param recursive   if true, traverse recursively to find all class files
     * @param annotation  filter the class by annotation
     * @return
     */
    public static List<Class<?>> findClassList(String packageName, boolean recursive, Class<? extends Annotation> annotation) {
        List<Class<?>> classList = new LinkedList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packagePath0 = packageName.replace(".", File.separator); // os related
        try {
            Enumeration<URL> urls = classLoader.getResources(packagePath0);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    String packagePath = url.getPath();
                    if ("file".equals(protocol)) {
                        findClassName(classList, packageName, packagePath, recursive, annotation);
                    } else if ("jar".equals(protocol)) {
                        findClassName(classList, packageName, url, annotation);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * find the class list of current project
     *
     * @param classList
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param annotation
     */
    private static void findClassName(List<Class<?>> classList, String packageName, String packagePath, boolean recursive, Class<? extends Annotation> annotation) {
        if (classList == null) {
            return;
        }
        File[] files = filterClassFiles(packagePath);
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if (file.isFile()) {
                    // .class files
                    String className = getClassName(packageName, fileName);
                    addClassName(classList, className, annotation);
                } else {
                    if (recursive) {
                        String subPackageName = packageName + "." + fileName;
                        String subPackagePath = packagePath + File.separator + fileName;
                        findClassName(classList, subPackageName, subPackagePath, recursive, annotation);
                    }
                }
            }
        }

    }

    /**
     * find the class list of third-party jar file
     *
     * @param classList
     * @param packageName
     * @param url
     * @param annotation
     */
    private static void findClassName(List<Class<?>> classList, String packageName, URL url, Class<? extends Annotation> annotation) throws IOException {
        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            String jarEntryName = jarEntry.getName(); // such as */*/*.class
            String className = jarEntryName.replace(File.separator, ".");
            if (className.endsWith(".class") && className.startsWith(packageName)) {
                addClassName(classList, className, annotation);
            }
        }
    }

    /**
     * filter the class files
     *
     * @param packagePath
     */
    private static File[] filterClassFiles(String packagePath) {
        if (packagePath == null) {
            return null;
        }
        return new File(packagePath).listFiles(file -> file.isFile() && file.getName().endsWith(".class") || file.isDirectory());
    }

    /**
     * get class name by file name
     *
     * @param packageName
     * @param fileName
     * @return
     */
    private static String getClassName(String packageName, String fileName) {
        int endIndex = fileName.lastIndexOf(".");
        String clazz = null;
        if (endIndex >= 0) {
            clazz = fileName.substring(0, endIndex);
        }
        String className = null;
        if (clazz != null) {
            className = packageName + "." + clazz;
        }
        return className;
    }

    /**
     * add class name to the class list
     *
     * @param classList
     * @param className
     * @param annotation
     */
    private static void addClassName(List<Class<?>> classList, String className, Class<? extends Annotation> annotation) {
        if (classList != null && className != null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            if (clazz != null) {
                if (annotation == null) {
                    classList.add(clazz);
                } else if (clazz.isAnnotationPresent(annotation)) {
                    classList.add(clazz);
                }
            }
        }
    }
}
