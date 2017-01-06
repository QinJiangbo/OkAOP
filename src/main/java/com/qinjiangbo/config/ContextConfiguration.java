package com.qinjiangbo.config;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 03/01/2017 3:21 PM
 * @author: qinjiangbo@github.io
 */
public class ContextConfiguration {

    // packages to be scanned
    private List<String> packages;

    /**
     * get scan packages path
     *
     * @return
     */
    public List<String> getPackages() {
        return packages;
    }

    /**
     * set the packages to be scanned
     *
     * @param packages0
     */
    public void setPackages(String packages0) {
        String[] packageArr = packages0.split(",|;|&");
        this.packages = new LinkedList<>();
        for (String packagge : packageArr) {
            if (!this.packages.contains(packagge)) {
                this.packages.add(packagge);
            }
        }
    }
}
