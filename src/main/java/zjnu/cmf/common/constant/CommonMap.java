package zjnu.cmf.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @classname: Constants
 * @description: 通用数据库映射Map数据
 * @author: zhuyuchao
 * @date: 2018/8/9 16:44
 * @version: 1.0
 */
public class CommonMap
{
    /** 状态编码转换 */
    public static Map<String, String> javaTypeMap = new HashMap<String, String>();

    static
    {
        initJavaTypeMap();
    }

    /**
     * 返回状态映射
     */
    public static void initJavaTypeMap()
    {
        javaTypeMap.put("tinyint", "Integer");
        javaTypeMap.put("smallint", "Integer");
        javaTypeMap.put("mediumint", "Integer");
        javaTypeMap.put("int", "Integer");
        javaTypeMap.put("integer", "integer");
        javaTypeMap.put("bigint", "Long");
        javaTypeMap.put("float", "Float");
        javaTypeMap.put("double", "Double");
        javaTypeMap.put("decimal", "BigDecimal");
        javaTypeMap.put("bit", "Boolean");
        javaTypeMap.put("char", "String");
        javaTypeMap.put("varchar", "String");
        javaTypeMap.put("tinytext", "String");
        javaTypeMap.put("text", "String");
        javaTypeMap.put("mediumtext", "String");
        javaTypeMap.put("longtext", "String");
        javaTypeMap.put("time", "Date");
        javaTypeMap.put("date", "Date");
        javaTypeMap.put("datetime", "Date");
        javaTypeMap.put("timestamp", "Date");
    }
}
