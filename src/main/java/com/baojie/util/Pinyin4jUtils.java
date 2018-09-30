package com.baojie.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 汉字转换成拼音方法
 *
 * @author baojie.ren
 */
public class Pinyin4jUtils {
    private static final Logger logger = LoggerFactory.getLogger(Pinyin4jUtils.class);
    private enum Type {
        //全拼驼峰
        CAMEL,
        //全拼大写
        UPPERCASE,
        //全拼小写
        LOWERCASE
    }

    /**
     * 转换全拼驼峰
     *
     * @param str 需要转换的字符串
     * @return str为宝杰 ,return获取到的是baoJie
     */
    public static String toAllCamel(String str) throws BadHanyuPinyinOutputFormatCombination {
        return chinese2Pinyin(str, Type.CAMEL);
    }

    /**
     * 转换全拼大写
     *
     * @param str 需要转换的字符串
     * @return str为宝杰 ,return获取到的是BAOJIE
     */
    public static String toAllUppercase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return chinese2Pinyin(str, Type.UPPERCASE);
    }

    /**
     * 转换全拼小写
     *
     * @param str 需要转换的字符串
     * @return str为宝杰 ,return获取到的是baojie
     */
    public static String toAllLowercase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return chinese2Pinyin(str, Type.LOWERCASE);
    }

    /**
     * @param str  需要转换的字符串,如果是非主流字符，则无视
     * @param type 转换格式
     * @return 指定格式转换后的拼音字符串
     */
    private static String chinese2Pinyin(String str, Type type) throws BadHanyuPinyinOutputFormatCombination {
        if (StringUtils.isEmpty(str)) {
            logger.error("都没传字符串,转换个j");
            return "";
        }
        boolean isCamel = false;
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        if (type == Type.UPPERCASE) {
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        } else if (type == Type.LOWERCASE) {
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        } else {
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            isCamel = true;
        }

        StringBuilder py = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int) c <= 128) {
                py.append(c);
            } else {
                String[] pinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (pinyinStringArray != null) {
                    String pyStr = pinyinStringArray[0];
                    if (isCamel) {
                        pyStr = pyStr.toUpperCase().charAt(0) + pyStr.substring(1, pyStr.length() - 1);
                    } else {
                        pyStr = pyStr.substring(0, pyStr.length() - 1);
                    }
                    py.append(pyStr);
                } else {
                    py.append(c);
                }
            }
        }
        return py.toString().trim();
    }
}