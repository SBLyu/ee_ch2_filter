package mad.nthu.ch2_filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class OutputReplaceFilter implements Filter {

	private Properties pp=new Properties();
	
	@Override
	public void init(FilterConfig config) throws ServletException {

		String file=config.getInitParameter("file");
		String realPath=config.getServletContext().getRealPath(file);
		
		try {
			pp.load(new FileInputStream(realPath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpCharacterResponseWrapper respone=new HttpCharacterResponseWrapper((HttpServletResponse)res);
		chain.doFilter(req, respone);
		
		String output=respone.getCharArrayWriter().toString();
		for(Object obj:pp.keySet()) {
			String key=(String)obj;
			output=output.replace(key, pp.getProperty(key));
		}
		PrintWriter out=res.getWriter();
		out.write(output);
	}

}
