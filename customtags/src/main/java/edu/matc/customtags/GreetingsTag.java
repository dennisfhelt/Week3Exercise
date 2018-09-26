package edu.matc.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *  Create a tag that shows a greeting onscreen that matches the time of day.
 */
public class GreetingsTag extends SimpleTagSupport {
    private LocalDateTime dateTime = LocalDateTime.now();

    /**
     * Before noon, Good Morning
     * Noon to 6PM, Good Afternoon
     * 6AM to Midnight, Good Evening
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        if (dateTime.getHour() < 12) {
            out.println("Good Morning!");
        } else if (dateTime.getHour() < 18) {
            out.println("Good Afternoon!");
        } else {
            out.println("Good Evening!");
        }
    }
}