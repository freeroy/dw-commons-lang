package org.developerworld.commons.lang;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 一般web常用工具类
 * 
 * @author Roy Huang
 * @version 20110410
 * 
 */
public class StringWebUtils {

	/**
	 * 获取URL的域名部分
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlDomain(String url) {
		if (StringUtils.isBlank(url))
			return url;
		url = url.trim();
		int begin = url.indexOf("://");
		if (begin == -1)
			begin = 0;
		else
			begin += 3;
		int end = url.indexOf("/", begin);
		if (end == -1)
			end = url.length();
		String tmp = url.substring(begin, end);
		if (tmp.indexOf(":") != -1)
			return tmp.substring(0, tmp.indexOf(":"));
		else
			return tmp;
	}

	/**
	 * 获取url 端口地址
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlPort(String url) {
		if (StringUtils.isBlank(url))
			return url;
		url = url.trim();
		int begin = url.indexOf("://");
		if (begin == -1)
			begin = 0;
		else
			begin += 3;
		int end = url.indexOf("/", begin);
		if (end == -1)
			end = url.length();
		String tmp = url.substring(begin, end);
		if (tmp.indexOf(":") != -1)
			return tmp.substring(tmp.indexOf(":") + 1);
		else
			return null;
	}

	/**
	 * 获取地址的访问协议
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlProtocol(String url) {
		if (StringUtils.isBlank(url))
			return url;
		url = url.trim();
		int end = url.indexOf("://");
		if (end == -1)
			end = url.length();
		return url.substring(0, end);
	}

	/**
	 * 获取URL的目录部分
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlDirectory(String url) {
		if (StringUtils.isBlank(url))
			return url;
		int begin = url.indexOf("://");
		if (begin == -1)
			begin = 0;
		else
			begin = begin + 3;
		begin = url.indexOf("/", begin);
		// 无目录，返回空白
		if (begin == -1)
			return "/";
		else {
			url = url.substring(begin);
			int end = url.indexOf("?");
			if (end == -1)
				end = url.length();
			url = url.substring(0, end);
			end = url.lastIndexOf("/");
			if (end == -1)
				return "/";
			else {
				String tmp = url.substring(0, end);
				return StringUtils.isBlank(tmp) ? "/" : tmp;
			}
		}
	}

	/**
	 * 获取排除域名后的URL
	 * 
	 * @param url
	 * @return
	 */
	public static String getWithoutDomainUrl(String url) {
		return getWithoutDomainUrl(getUrlDomain(url), url);
	}

	/**
	 * 获取排除域名后的URL
	 * 
	 * @param url
	 * @return
	 */
	public static String getWithoutDomainUrl(String domain, String url) {
		if (StringUtils.isBlank(url))
			return url;
		int begin = url.indexOf(domain);
		if (begin != -1)
			url = url.substring(begin + domain.length(), url.length());
		return url;
	}

	/**
	 * 获取排除请求参数后的链接
	 * 
	 * @param url
	 * @return
	 */
	public static String getWithoutQueryStringUrl(String url) {
		String rst = url;
		if (url != null && url.indexOf("?") != -1)
			rst = url.substring(0, url.indexOf("?"));
		return rst;
	}

	/**
	 * 获取连接的请求参数
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlQueryString(String url) {
		String rst = "";
		if (url != null && url.indexOf("?") != -1)
			rst = url.substring(url.indexOf("?") + 1, url.length());
		return rst;
	}

	/**
	 * 获取URL请求参数
	 * 
	 * @param url
	 * @return
	 */
	public static Map<String, String[]> getUrlQueryParamsMap(String url) {
		Map<String, String[]> rst = new LinkedHashMap<String, String[]>();
		String query = getUrlQueryString(url);
		if (StringUtils.isNotEmpty(query)) {
			String[] params = query.split("&");
			if (params != null && params.length > 0) {
				for (String param : params) {
					String[] data = param.split("=");
					if (data != null) {
						String[] arrs = rst.get(data[0]);
						if (arrs == null)
							arrs = new String[1];
						else {
							String[] tmp = arrs;
							arrs = new String[tmp.length + 1];
							System.arraycopy(tmp, 0, arrs, 0, tmp.length);
							;
						}
						if (data.length == 1)
							arrs[arrs.length - 1] = "";
						else if (data.length == 2)
							arrs[arrs.length - 1] = data[1];
						rst.put(data[0], arrs);
					}
				}
			}
		}
		return rst;
	}

	/**
	 * 获取针对Web应用的根目录
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getWebRootPath() throws IOException {
		String rst = null;
		rst = new File(StringWebUtils.class.getResource("/").getFile(),
				"../../").getCanonicalPath();
		return rst;
	}

}
