package com.mybatisplus.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R setData(Object o) {
		put("data",o);
		return this;
	}

	public <T> T getData(TypeReference<T> typeReference) {
		Object o = get("data");
		String s = JSON.toJSONString(o);
		return JSON.parseObject(s,typeReference);
	}

	public R() {
		put("code", 0);
		put("msg", "success");
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Object value) {
		R r = new R();
		r.put("data", value);
		return r;
	}
	public static R map(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public  Integer getCode() {
		return (Integer) this.get("code");
	}

	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}
}