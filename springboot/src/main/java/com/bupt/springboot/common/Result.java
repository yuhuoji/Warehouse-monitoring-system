package com.bupt.springboot.common;

/* Result是返回给前台数据的json包装类, 后台只返回code和msg两个数 */
public class Result<T> {
    /* 用code将后台信息通过json返回给前台，这样前台根据事先约定好的一一对应的code-错误信息就可以知道是咋了*/
    private String code;
    /* 用msg将后台的错误信息返回给前台，前台可以直接弹出或者咋的*/
    private String msg;
    /* T是范型，任何一种数据类型都可以被它所包含（模板类？），可以包装不同的东西 */
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    /* 返回, 0 false, 1 true */
    public static Result success() {
        Result result = new Result<>();
        result.setCode("1");
        result.setMsg("成功");
        return result;
    }

    /* TODO 返回数据 Result类 */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("1");
        result.setMsg("成功");
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /*成功code为0，不成功code不为0*/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
