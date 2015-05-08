package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import model.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.SSpringBeanBuilder;

@Controller
public class GreetingController {
	
	private String flickrBaseUrl = "https://api.flickr.com/services/rest/";
	private String flickrMethod = "flickr.photos.search";
	private String flickrAPIKey = "8d3fb09eae35f2c1e056e7aee9a9cf84";
	private String flickrPerPage = "10";
	private SSpringBeanBuilder builder=SSpringBeanBuilder.getInstance();
	
    @RequestMapping("/smvc/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        //System.out.println("I am about to return!");
        return "welcome";
    }
    
	@RequestMapping("/smvc/searchProducts")
    public String searchProducts(@RequestParam(value="keyword", required=false, defaultValue="") String keyword, Model model) {
    	BufferedReader in=null;HttpsURLConnection con =null;InputStream ins=null;InputStreamReader isr=null;
    	try {
    		String searchField="";
    		if (!"".equals(keyword.trim())){
    			if (keyword.indexOf("&")<0){searchField="&text="+keyword;}
    		}
    		String url = flickrBaseUrl + "?method="+flickrMethod+"&api_key="+flickrAPIKey+searchField+"&privacy_filter=1&per_page="+flickrPerPage+"&user_id=133070924@N04&format=json";
			URL myurl = new URL(url);
			con = (HttpsURLConnection)myurl.openConnection();
			ins = con.getInputStream();
			isr = new InputStreamReader(ins);
			in = new BufferedReader(isr);
			String inputLine=null;
			String result="";
			while ((inputLine = in.readLine()) != null)
			{
			  System.out.println(inputLine);
			  result+=inputLine;
			}
			if (result!=null) {
				result = result.trim();
				int index = result.indexOf("jsonFlickrApi(");
				List<Product> plist=builder.productBuilder(result.substring(index+14,result.length()-1));
				System.out.println(plist);
				model.addAttribute("products", plist);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in!=null){in.close();}
				if (isr!=null){isr.close();}
				if (ins!=null){ins.close();}
				if (con!=null){con.disconnect();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return "welcome";
    }
}
