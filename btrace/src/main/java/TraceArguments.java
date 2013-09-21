import com.mkyong.common.controller.obj.Name;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceArguments {

    @OnMethod(
            clazz = "com.mkyong.common.controller.obj.NameProcess",
            method = "process"
            ,location = @Location(Kind.RETURN)
    )
    /**
     * 1 process(Name) 格式，将name作为参数至于m方法,然后利用field（filed,name）方法获取字段值
     * 2 查看target 中的字段名称,在行参中使用@self 标记onMethod中的class,然后利用field(filed,self)方法获取值
     */
    public static void m(@ProbeMethodName String me,@Return Name re,Name name) {

        println(get(field("com.mkyong.common.controller.obj.Name", "name"), re));
        println(get(field("com.mkyong.common.controller.obj.Name", "name"), name));

    }

}
