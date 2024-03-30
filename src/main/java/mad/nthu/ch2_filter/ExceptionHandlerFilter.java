package mad.nthu.ch2_filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExceptionHandlerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			
			Throwable rootCause=e;
			while(rootCause.getCause()!=null) {
				rootCause=rootCause.getCause();
			}
			
			String message=rootCause.getMessage();
			message=(message==null)?"例外"+rootCause.getClass().getName():message;
			
			request.setAttribute("message", message);
			request.setAttribute("e", e);

			if(rootCause instanceof BusinessException) {
				request.getRequestDispatcher("/businessException.jsp").forward(request, response);
			}else if(rootCause instanceof AccountException) {
				request.getRequestDispatcher("/accountException.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/exception.jsp").forward(request, response);
			}
			
		}
		
	}

}
