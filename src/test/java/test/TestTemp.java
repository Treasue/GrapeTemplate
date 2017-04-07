package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import interfaceApplication.TempList;
import interfaceApplication.TemplateContext;

public class TestTemp {
//	private static TempList tempList = new TempList();
	private static TemplateContext templateContext = new TemplateContext();

	public static void main(String[] args) throws ParseException {
//		String tempinfo = "{\"_id\":{\"$oid\":\"58d230ad0d42891014386172\"},\"name\":\"test\"}";
//		String tempinfos = "{\"name\":\"test001\"}";
//		System.out.println(tempList.TempList_Insert(tempinfos));
//		System.out.println(tempList.TempList_Update(tempinfo));   
//		System.out.println(tempList.TempList_Select());
//		System.out.println(tempList.TempList_Select("58d232150d428911fc9c1569"));
//		System.out.println(tempList.TempList_Page(2, 2));
//		System.out.println(tempList.TempList_Delete("58d232150d428911fc9c1569"));
		
		
		String tempinfo = "{\"name\":\"temp002\",\"tid\":\"58d230ad0d42891014386172\",\"time\":\"2017-03-22\"}";
//	System.out.println(templateContext.Temp_Addtemp(tempinfo));
//	System.out.println(templateContext.Temp_Updatetemp(tempinfos));   
//	System.out.println(templateContext.Temp_Showtemp());
//	System.out.println(templateContext.Temp_Findtemp("58d23d480d428917b4f1c051"));
//	System.out.println(templateContext.Temp_Pagetemp(2, 1));
	}

}
