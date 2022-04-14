package mybootapp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggerInterceptor implements HandlerInterceptor {

    private static Log log = LogFactory.getLog(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, //
            HttpServletResponse response, Object handler) throws Exception {
        var client = request.getRemoteAddr();
        log.info("Inside pre handle from " + client);
        switch (client) {
        case "127.0.0.1":
        case "0:0:0:0:0:0:0:1":
            return true;
        }
        response.getWriter().printf("Only 127.0.0.1");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, //
            HttpServletResponse response, //
            Object handler, //
            ModelAndView modelAndView) throws Exception {
        log.info("Inside post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, //
            HttpServletResponse response, Object handler, //
            Exception exception) throws Exception {
        log.info("Inside after completion");
    }
}