package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import model.Product;



public class SSpringBeanBuilder {

	private static class SSpringBeanBuilderHolder{
		private static final SSpringBeanBuilder INSTANCE = new SSpringBeanBuilder();
	}
	private SSpringBeanBuilder(){}
	
	public static SSpringBeanBuilder getInstance(){
		return SSpringBeanBuilderHolder.INSTANCE;
	}
	
	public List<Product> productBuilder(String json){
		JSONObject photos=JSONObject.fromObject(json).getJSONObject("photos");
		if (photos!=null) {
			JSONArray photol = photos.getJSONArray("photo");
			if (photol!=null) {
				@SuppressWarnings("unchecked")
				Iterator<JSONArray> it = photol.iterator();
				List<Product> result = new ArrayList<Product>();
				while (it.hasNext()) {
					JSONObject temp = JSONObject.fromObject(it.next());
					String pid = temp.getString("id");
					String imgUrl = "https://farm" + temp.getString("farm")+ ".staticflickr.com/" + temp.getString("server")+ "/" + pid + "_" + temp.getString("secret")+ ".jpg";
					result.add(new Product(pid, imgUrl, temp.getString("title")));
				}
				return result;
			}
		}
		return null;
	}
}
