package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


    //沙箱APPID
    public static final  String app_id = "2016101200666634";
    //沙箱私钥
    public static final  String merchant_private_key =
            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC8Q6GtCnG2K8TlT0LX76G4W+uBQcgQQCuU6JVHz/MHZMQLaFBRCXQhIVowRndguH9WHi22pgoxumAMKhwWVv9OVW9B6xfDUZ+CHuh5PWWtVjHh2kdiLT2zgg6eK91TWEtU110PEHfMlEX+e1M0fqMH8yhMbJwy3Xw8In3DjmRMyukO43DdXejsNgEWfNemrmc6+Tj8ExiT7j7CvbBZrW1g+jxD6hiKXR4mN++gqz6qfCZ77VCTaHDHWjvUHOWcY0tFPYcN4dZoNBSzCStxY7A1aa5g27BxTRaneXK71LUb4lh3tkjz07OWEX8Fz8RuYMDjRMidy/XgBSsVnkvAlpgxAgMBAAECggEACtal7y1jwIYijsUSZxYfrFp2Y3mjB/R5zdfaCElbh3hwpOt7fD7cFbAy3gaghsv4YL/aB+LlQVmmf+zIsyyNBDh88EGVm6QOV9JptdkoCmOk+Yi0hV1vaO864jZKRqsVoyvG6sAa9YcvxGfbMXF8908zabry/yarKVcfAGwpMBaBLhqWFK85M52C4fNWRt8u9P+8RpFDS9W654MWFeuUFhHsNkDHynQo+vgMksLr7y8TnfqPjbnfGMzw/5ovaanRqA3ihkYaYv++qbDlaud04O6L1i3O2/Zn3qlmEfyNZIgfF142xwL69mpqwIMg9VCxSvmOjuJsv7/tDFJMTjWxpQKBgQDfrSJU8Y3eHoNFYfX1HwgQXJGYOWJO14tV6SncZek1DBsYf+C7/vKElckMRqoOXojQooYf7wQG7lb8ghR6fmrVTL6vmHQxRplLx1bpQ5rFVGfBzJF1E49XTcDxG83XpLAjbEtitA9hYZYjcJV1OcbjAplz7jwimDsLUVfEHZWW4wKBgQDXeG6ofTIYC5jqjv2bnKb2K14+96Ux4To3ikLGHDpqSxm+UTvoO6Cls1/J2kbBjrb2Pn0AcuZ+szekPsA5dfT6jyedTM+k67ju9Iv7w3i7oO2ET8j5XPoT9JrxE84vJuTiGRpIezhqQ9uxsKXAsHOxhqROWILBScd928vQRSqs2wKBgDe/YQUmxyMLG9CZH8IeH9ZkG+2Cr9vSoOmimUpTJBKSl9Y9WPfCDRO6eUdT/WJjcVn+h8tBuRE5Kfj5Or1k8J+E5ynAp4T4gZB/eEvfC54O8WU95Sr22wz5VhNByMXsR/IsNYW+Nu8gcVkX4Eg9RDKkHTbls5szsdOaTHOWpAfdAoGAJcQ/KRsgj6RgviQoAYF4pkc9sq23b8G5cYizYYQLHRxiu8ADTxY8dy60iG3Q3xZDrW+Qe2aoTebdxtUU3j11ngE/gUu4TYDfnkqQyqUdYU24s+tEH6kTUDIcgkrlZdBcZ+DcgX3PipiwRjnfI6IJ9UDTRcQvzu8+nynKVIv7CecCgYBEuB/2aVWcKqwK5vH9slEz1FaLhCs/6iAJVqUBCuhq12S5hIrmveMOmaUCvwyHjZWtFjgH36pWpQli9nbnHbjaK20rvwbOpjecLvvLPzDapm9SlDRKTgmhPI4LeOVszKMsbsWvwFBxRDRXYihERbMshUF/JdkchCUG3yk26eciUA==";
    //支付宝公钥
    public static final  String alipay_public_key =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7F4TugnmUgcDC1J0VOEG+k13karlTtPSfcg5Y7gxeZIwiaD79ScMtfotPOrNJiGssXxFCDEHk2sgpt49xQPuLaYw7Q+FCQb0fPsxosiNtvW6WV9O1t11ALZaeuF7+NoD3DwohJdYNgkSO4JUPlqdYHFWkHJBTeQCjPMPy4PtMKBS8PW+wmy1SUByROyW8Ev5iUYrOdMCSi612ZTpiJ4oF7iPqKgUFYAylMLN+a2mn/jt94DIMtM4HjuadNgw0QKtTqwWOWGCR1TML0xVf0wM8Z1ezu4EJKSEvNCmJRp9r02XaTy6ywcLZlF4U7sJytEVwTrqdChr46+hFVqTYsvybQIDAQAB";
    //沙箱网关地址
    public static final  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    //	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/gxtravel/pay/notify_url.jsp";

    //	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/gxtravel/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";


    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

