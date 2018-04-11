package com.runshoptechnology.runshop.utils.crash;

/**
 * @author Ryder
 * create at 2018/4/11 14:37
 * package name:com.runshoptechnology.runshop.utils.crash
 * description:  引用的 GitHub上的一个crash的项目  地址为：https://github.com/android-notes/Cockroach
 **/


final class QuitCockroachException extends RuntimeException {
    public QuitCockroachException(String message) {
        super(message);
    }
}
