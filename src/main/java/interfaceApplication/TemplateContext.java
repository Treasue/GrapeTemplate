package interfaceApplication;

import esayhelper.JSONHelper;
import model.TemplateContextModel;

public class TemplateContext {
	private TemplateContextModel temp = new TemplateContextModel();

	public String TempInsert(String tempinfo) {
		return temp.resultMessage(temp.insert(JSONHelper.string2json(tempinfo)), "新增模版成功");
	}
	public String TempDelete(String tempID) {
		return temp.resultMessage(temp.delete(tempID), "删除模版成功");
	}
	public String TempSelect() {
		return temp.select().toString();
	}
	public String TempFind(String tempinfo){
		return temp.select(tempinfo);
	}
	public String TempUpdate(String tempid,String tempinfo) {
		return temp.resultMessage(temp.update(tempid,JSONHelper.string2json(tempinfo)), "模版更新成功");
	}
	public String TempPage(int idx,int pageSize){
		return temp.page(idx, pageSize);
	}
	public String TempPageBy(int idx,int pageSize,String tempinfo){
		return temp.page(tempinfo,idx, pageSize);
	}
	public String TempSort(String tempid,long num){
		return temp.sort(tempid,num);
	}
	public String TempSetTid(String tempid,String tid) {
		return temp.resultMessage(temp.setTid(tempid, tid), "设置模版方案成功");
	}
	public String TempBatchDelete(String tempid) {
		return temp.resultMessage(temp.delete(tempid.split(",")), "批量删除成功"); 
	}
}
