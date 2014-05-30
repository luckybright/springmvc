package ming.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {
		List<Object> array = new ArrayList<Object>();
		List<Object> arr1 = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		obj.put("name", "1");
		obj.put("url", "url1");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "2");
		obj.put("url", "url2");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "3");
		obj.put("url", "url3");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "4");
		obj.put("url", "url4");
		arr1.add(obj);
		
		obj = new JSONObject();
		obj.put("name", "文件");
		obj.put("url", arr1);
		array.add(obj);
		
		arr1 = new ArrayList<Object>();
		obj = new JSONObject();
		obj.put("name", "1");
		obj.put("url", "url1");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "2");
		obj.put("url", "url2");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "3");
		obj.put("url", "url3");
		arr1.add(obj);
		obj = new JSONObject();
		obj.put("name", "4");
		obj.put("url", "url4");
		arr1.add(obj);
		
		obj = new JSONObject();
		obj.put("name", "编辑");
		obj.put("url", arr1);
		
		array.add(obj);
		System.out.println(array);
//		List<Object> array = new ArrayList<Object>();
//		array.add("功能1");
//		array.add(obj);
//		array.add("功能3");
//		array.add("功能4");
//		JSONArray ja = new JSONArray(array);
//		System.out.println(ja.toString());
//		
//		Map map = new HashMap();
//		map.put("选项", "/qq.cmd");
	}

}
