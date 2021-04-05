package com.kl.wework;

public class WeworkConfig {
    public String agentId = "1000002";
    public String secret = "yQvRMp3M3aNHnWpGZ8tnNRLMBY84GefYNE__B74im74";
    //   企业ID
    public String corId = "ww73530bb447ccc302";
    public String contactSecret = "vylR7G5h1o1Rvf4DOTxCBHn5Qq3K9MITuHxDNESoKso";

    private static WeworkConfig weworkConfig;
    public static WeworkConfig getInstance() {
        if(weworkConfig == null) {
            weworkConfig = new WeworkConfig();
        }
        return weworkConfig;
    }

    public static void load(String path) {
//        read from yaml or json

    }

}
