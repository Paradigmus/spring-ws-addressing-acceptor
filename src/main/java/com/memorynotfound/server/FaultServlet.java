package com.memorynotfound.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class FaultServlet extends HttpServlet {

    private static final Log logger = LogFactory.getLog(FaultServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        final String request = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        logger.info("Handling web service fault");
        logger.debug("Received request ["+request+"]");
    }
}
