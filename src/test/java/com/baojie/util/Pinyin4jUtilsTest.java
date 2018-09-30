package com.baojie.util;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import static org.junit.Assert.*;

public class Pinyin4jUtilsTest {

    @Test
    public void toAllCamel() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(Pinyin4jUtils.toAllCamel("任宝杰"));
    }

    @Test
    public void toAllUppercase() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(Pinyin4jUtils.toAllUppercase("任宝杰"));
    }

    @Test
    public void toAllLowercase() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(Pinyin4jUtils.toAllLowercase("任宝杰"));
    }
}