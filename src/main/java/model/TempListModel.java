package model;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import esayhelper.DBHelper;
import esayhelper.JSONHelper;
import esayhelper.formHelper;
import esayhelper.jGrapeFW_Message;

public class TempListModel {
	private static DBHelper dbtemp;
	private formHelper _form;
	static {
		dbtemp = new DBHelper("mongodb", "templist", "_id");
	}

	public TempListModel() {
		_form = new formHelper();
		_form.addNotNull("name");
		HashMap<String, Object> map = new HashMap<>();
		map.put("tid", getID());
		map.put("ownid", "0");
		map.put("isdelete", 0);
		map.put("sort", 0);
		_form.adddef(map);
	}

	public int insert(JSONObject tempinfo) {
		int ckcode = _form.check_forminfo(tempinfo);
		if (ckcode == 1) {
			return 1;
		}
		return dbtemp.insert(tempinfo) != null ? 0 : 99;
	}

	public int delete(String id) {
		return dbtemp.eq("_id", new ObjectId(id)).delete()!=null?0:99;
	}

	public JSONArray select() {
		return dbtemp.select();
	}

	public String select(String tempinfo) {
		JSONObject object = JSONHelper.string2json(tempinfo);
		@SuppressWarnings("unchecked")
		Set<Object> set = object.keySet();
		for (Object object2 : set) {
			dbtemp.eq(object2.toString(), object.get(object2.toString()));
		}
		return dbtemp.select().toString();
	}

	public int update(String tid, JSONObject tempinfo) {
		// 非空字段判断
		if (!_form.check_notnull_safe(tempinfo)) {
			return 1;
		}
		return dbtemp.eq("_id", new ObjectId(tid)).data(tempinfo).update() != null ? 0 : 99;
	}

	@SuppressWarnings("unchecked")
	public String page(int idx, int pageSize) {
		JSONArray array = dbtemp.page(idx, pageSize);
		JSONObject object = new JSONObject() {
			private static final long serialVersionUID = 1L;

			{
				put("totalSize", (int) Math.ceil((double) array.size() / pageSize));
				put("currentPage", idx);
				put("pageSize", pageSize);
				put("data", array);

			}
		};
		return object.toString();
	}

	@SuppressWarnings("unchecked")
	public String page(String tempinfo, int idx, int pageSize) {
		Set<Object> set = JSONHelper.string2json(tempinfo).keySet();
		for (Object object2 : set) {
			dbtemp.eq(object2.toString(), JSONHelper.string2json(tempinfo).get(object2.toString()));
		}
		JSONArray array = dbtemp.page(idx, pageSize);
		JSONObject object = new JSONObject() {
			private static final long serialVersionUID = 1L;

			{
				put("totalSize", (int) Math.ceil((double) array.size() / pageSize));
				put("currentPage", idx);
				put("pageSize", pageSize);
				put("data", array);

			}
		};
		return object.toString();
	}

	public String sort(String tid, long num) {
		return dbtemp.eq("_id", new ObjectId(tid)).add("sort", num).toString();
	}

	public int delete(String[] arr) {
//		StringBuffer stringBuffer = new StringBuffer();
		dbtemp = (DBHelper)dbtemp.or();
		for (int i = 0; i < arr.length; i++) {
			dbtemp.eq("_id", new ObjectId(arr[i]));
		}
		return dbtemp.delete()!=null ? 0 : 3;
	}

	/**
	 * 生成32位随机编码
	 * 
	 * @return
	 */
	protected static String getID() {
		String str = UUID.randomUUID().toString().trim();
		return str.replace("-", "");
	}

	public String resultmessage(int num, String message) {
		String msg = "";
		switch (num) {
		case 0:
			msg = message;
			break;
		case 1:
			msg = "必填字段没有填";
			break;
		default:
			msg = "其他操作异常";
			break;
		}
		return jGrapeFW_Message.netMSG(num, msg);
	}
}
