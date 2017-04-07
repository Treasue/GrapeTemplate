package interfaceApplication;


import org.json.simple.JSONObject;

import esayhelper.JSONHelper;
import model.TempListModel;

public class TempList {
	private TempListModel temp=new TempListModel();
	
	public String  TempListInsert(String tempinfo) {
		JSONObject object = JSONHelper.string2json(tempinfo);
		return temp.resultmessage(temp.insert(object), "模版方案新增成功");
	}
	public String  TempListDelete(String id) {
		return temp.resultmessage(temp.delete(id), "删除模版方案成功");
	}
	public String  TempListSelect() {
		return temp.select().toJSONString();
	}
	public String  TempListFind(String tempinfo) {
		return temp.select(tempinfo);
	}
	public String  TempListUpdate(String tid,String tempinfo) {
		return temp.resultmessage(temp.update(tid,JSONHelper.string2json(tempinfo)), "模版方案更改成功");
	}
	public String  TempListPage(int idx,int pageSize) {
		return temp.page(idx, pageSize);
	}
	public String  TempListPageBy(int idx,int pageSize,String tempinfo) {
		return temp.page(tempinfo,idx, pageSize);
	}
	public String  TempListSort(String tid,long num) {
		return temp.sort(tid, num);
	}
	public String  TempListBatchDelete(String tid) {
		return temp.resultmessage(temp.delete(tid.split(",")), "批量删除成功"); 
	}
}
