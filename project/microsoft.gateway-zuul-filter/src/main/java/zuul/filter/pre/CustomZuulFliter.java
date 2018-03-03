package zuul.filter.pre;

 
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class CustomZuulFliter  extends ZuulFilter{
	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomZuulFliter.class);

	@Override
	public Object run() {
		 
		RequestContext ctn=RequestContext.getCurrentContext();
		HttpServletRequest re=ctn.getRequest();
		LOGGER.info(String.format("send %s request to %s",re.getMethod(),re.getRequestURL().toString() ));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
